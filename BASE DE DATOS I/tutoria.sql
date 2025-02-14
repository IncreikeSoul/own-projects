create database BDTUTORIA
go
use BDTUTORIA
go
create table ESCUELA(
id_escuela int PRIMARY KEY,
nombre_escuela varchar(30)
)
go
create table CURSO(
id_curso int IDENTITY PRIMARY KEY,
codigo_curso varchar(8) UNIQUE CHECK(LEN(codigo_curso) <= 6) not null,
nombre_curso varchar(40) not null,
creditos int not null,
id_escuela int not null,
FOREIGN KEY(id_escuela) REFERENCES ESCUELA(id_escuela)
)
go
create table PROFESOR(
id_profesor int IDENTITY PRIMARY KEY,
codigo_profesor int UNIQUE CHECK(LEN(codigo_profesor) <= 9) not null,
nombre_prof varchar(50),
apellido_prof varchar(50) not null,
fecha_nacimiento date
)
go
create table PROFxCURSO(
codigo_gen int IDENTITY UNIQUE,
id_profesor int,
id_curso int,
etiqueta_grupo char(2) not null,
PRIMARY KEY(id_profesor,id_curso),
FOREIGN KEY(id_profesor) REFERENCES PROFESOR(id_profesor),
FOREIGN KEY(id_curso) REFERENCES CURSO(id_curso)
)
go
create table AULA(
id_aula int PRIMARY KEY,
etiqueta_aula varchar(10) UNIQUE not null
)
go
create table TUTORIA(
id_tutoria int IDENTITY PRIMARY KEY,
aspecto_tratado varchar(30) not null,
fecha_tutoria date not null,
hora_inicio varchar(10) not null,
hora_fin varchar(10) not null,
id_aula int FOREIGN KEY REFERENCES AULA(id_aula),
codigo_gen int FOREIGN KEY REFERENCES PROFxCURSO(codigo_gen)
)
go
create table ALUMNO(
id_alumno int IDENTITY PRIMARY KEY,
codigo_alumno int UNIQUE CHECK(LEN(codigo_alumno) <= 9) not null,
nombre_alum varchar(50),
apellido_alum varchar(50) not null,
fecha_nacimiento date,
carrera varchar(20) not null
)
go
create table REGISTRO(
id_registro varchar(6) PRIMARY KEY,
fecha_reg date not null,
nombreTutor varchar(50) not null
)
go
create table ASISTENCIA(
id_asistencia int PRIMARY KEY,
descripcionAsist varchar(30)
)
go
/*cuando se inserte, al principio sera nulo el id_asistencia
pero despues que el profe tome asistencia, cambiara su valor actualizandolo.*/
create table GRUPO(
codigo_grupo int IDENTITY UNIQUE,
id_tutoria int,
id_alumno int,
id_asistencia int,
id_registro varchar(6),
PRIMARY KEY(codigo_grupo,id_alumno,id_tutoria),
FOREIGN KEY(id_tutoria) REFERENCES TUTORIA(id_tutoria),
FOREIGN KEY(id_alumno) REFERENCES ALUMNO(id_alumno),
FOREIGN KEY(id_asistencia) REFERENCES ASISTENCIA(id_asistencia),
FOREIGN KEY(id_registro) REFERENCES REGISTRO(id_registro)
)
go
create table ESTADO_DETALLE_GRUPO(
id_EstDetGrupo int PRIMARY KEY,
descripcionCupo varchar(15)
)
go
--Tabla no relacional para detalle de cada GRUPO x ASISTENCIA
create table DETALLE_ASISTENCIA(
id_detalleAsist int PRIMARY KEY,
cant_asistidos int,
cant_faltan int,
cant_justificado int
)
go
--Tabla no relacional para detalle de cada GRUPO
--cuando la cantidad de alumnos registrados este lleno, muestra el estado entre: Disponible y Cerrado
create table DETALLE_GRUPO(
id_detalleGrp int IDENTITY PRIMARY KEY,
curso varchar(40) not null,
aspecto_tratado varchar(30) not null,
grupo char(2) not null,
cant_regAlumno int CHECK(cant_regAlumno > 0 AND cant_regAlumno <= 40),
id_EstDetGrupo int not null FOREIGN KEY REFERENCES ESTADO_DETALLE_GRUPO(id_EstDetGrupo),
id_detalleAsist int UNIQUE REFERENCES DETALLE_ASISTENCIA(id_detalleAsist)
)
go
go

--TRIGGERS PARA INSERCCION Y TABLAS NO RELACIONADAS
--inserccion de la tabla 'detalle_grupo'
CREATE TRIGGER t_detalle_grupo
ON GRUPO
AFTER INSERT
AS
DECLARE @curso varchar(40), @grupo char(2), @queryIdTutoria int, @id_tutoriaClase int, @cant_regAlumnno int, @nombreTutoria varchar(30)
SET @id_tutoriaClase = (Select id_tutoria from inserted)
SET @curso = (Select cur.nombre_curso
			  from	 CURSO as cur,
					 PROFxCURSO as pc,
					 TUTORIA as tut
			  where	(tut.codigo_gen = pc.codigo_gen AND
					 pc.id_curso = cur.id_curso AND
					 tut.id_tutoria = @id_tutoriaClase))
SET @nombreTutoria = (Select aspecto_tratado from TUTORIA where id_tutoria = @id_tutoriaClase)
SET @queryIdTutoria = (Select COUNT(id_tutoria) from GRUPO where id_tutoria = @id_tutoriaClase)
SET @cant_regAlumnno = (Select COUNT(id_alumno) from GRUPO where id_tutoria = @id_tutoriaClase)
SET @grupo = (Select TOP 1 pc.etiqueta_grupo
			  from	  GRUPO as grp, 
			  		  TUTORIA as tut,
					  ALUMNO as alum,
					  PROFxCURSO as pc
			  where  (grp.id_tutoria = tut.id_tutoria AND
			          grp.id_alumno = alum.id_alumno AND
					  tut.codigo_gen = pc.codigo_gen AND
					  grp.id_tutoria = @id_tutoriaClase))

IF (@queryIdTutoria >= 2)
begin
	IF(@cant_regAlumnno = 40)
	begin
		print 'se cerro cupos'
		UPDATE DETALLE_GRUPO SET id_EstDetGrupo = 2
		WHERE aspecto_tratado = @nombreTutoria
	end
	IF(@cant_regAlumnno <= 40)
	begin
		print 'aumenta la cantidad de alumnos en detalle grupo'
		UPDATE DETALLE_GRUPO SET cant_regAlumno = @cant_regAlumnno
		WHERE aspecto_tratado = @nombreTutoria
	end
end
ELSE
begin
	print 'inserta en detalle grupo'
	INSERT INTO DETALLE_GRUPO VALUES(@curso, @nombreTutoria, @grupo, @cant_regAlumnno, 1, null)
end
go

--inserccion de la tabla 'detalle_asistencia'
CREATE TRIGGER t_detalle_asistencia
ON DETALLE_GRUPO
AFTER INSERT
AS
BEGIN
	DECLARE @id_detalleAsist int
	SET @id_detalleAsist = (select id_detalleGrp from inserted)
	print 'se une detalle asistencia'
	INSERT INTO DETALLE_ASISTENCIA VALUES(@id_detalleAsist, null, null, null)
	UPDATE DETALLE_GRUPO SET id_detalleAsist = @id_detalleAsist
	WHERE id_detalleGrp = @id_detalleAsist
END
go

--actualiza el nombre del tutor ni bien registra una tutoria
CREATE TRIGGER t_autoGeneraTutor
ON TUTORIA
AFTER INSERT
AS
BEGIN
	DECLARE @codigo_gen int, @nombreTutor varchar(50), @cantNombTut int
	SET @codigo_gen = (select codigo_gen from inserted)
	SET @cantNombTut = (select COUNT(tut.codigo_gen)
						from   PROFESOR as prof,
							   TUTORIA as tut,
							   PROFxCURSO as pf
						where (prof.id_profesor = pf.id_profesor AND
							   tut.codigo_gen = pf.codigo_gen AND
							   tut.codigo_gen = @codigo_gen))
	SET @nombreTutor = (select distinct CONCAT(prof.apellido_prof,', ',prof.nombre_prof) as nombreTutor
						from   PROFESOR as prof,
							   TUTORIA as tut,
						       PROFxCURSO as pf
						where (prof.id_profesor = pf.id_profesor AND
							   tut.codigo_gen = pf.codigo_gen AND
							   tut.codigo_gen = @codigo_gen))
	IF(@cantNombTut >= 2)
	begin
		print 'se lleno'
	end
	ELSE
	begin
		print 'inserta en registro nuevo ***'
		INSERT INTO REGISTRO VALUES(SUBSTRING(CONVERT(varchar(255), NEWID()), 0, 7),GETDATE(), @nombreTutor)
	end
END
go

--Hace rollback/elimina cada vez que haya repetidos en el campo nombreTutor de la tabla REGISTRO
CREATE TRIGGER t_regulaRegistro
ON REGISTRO
AFTER INSERT
AS
BEGIN TRY
	DECLARE @nombreTutor varchar(50), @cantNombTutor int
	SET @nombreTutor = (select nombreTutor from inserted)
	SET @cantNombTutor = (select count(nombreTutor) from REGISTRO where nombreTutor = @nombreTutor)
	IF(@cantNombTutor >= 2)
	begin
		print 'elimina registro si es repetido'
		DELETE FROM REGISTRO
		WHERE id_registro in (
			select a1.id_registro from REGISTRO a1
			inner join REGISTRO a2
			on a1.nombreTutor = a2.nombreTutor
			and a1.id_registro > a2.id_registro
		);
	end
	ELSE
	begin
		print 'commitea'
	end
END TRY
BEGIN CATCH
	print 'Mensaje de error en t_regulaRegistro: '+ERROR_MESSAGE()
END CATCH
go

--Calcula la cantidad de asistidos, falta y justificados x horarios -> alumno
CREATE TRIGGER t_calculoAsist
ON GRUPO
AFTER UPDATE
AS
DECLARE @id_tutoria int, @cant_Presente int, @cant_falta int, @cant_justificado int
SET @id_tutoria = (select id_tutoria from inserted)
SET @cant_Presente = (select  COUNT(*) as cant_Presente
				      from	  GRUPO
					  where	  id_tutoria = @id_tutoria AND id_asistencia = 1)
SET @cant_falta = (select  COUNT(*) as cant_falta
				   from	   GRUPO
				   where   id_tutoria = @id_tutoria AND id_asistencia = 2)
SET @cant_justificado = (select  COUNT(*) as cant_justificado
				         from	 GRUPO
					     where	 id_tutoria = @id_tutoria AND id_asistencia = 3)
/*Cuenta uno x uno sumando la cantidad de las asistencias por acutalizacion en el grupo*/	
print 'promedia cantidad asistencia'			
UPDATE DETALLE_ASISTENCIA 
SET cant_asistidos = @cant_Presente, cant_faltan = @cant_falta, cant_justificado = @cant_justificado
WHERE id_detalleAsist = @id_tutoria
go
go

/*INSERCCION DE DATOS DE CADA TABLA.*/
--Tabla ESTADO_DETALLE_GRUPO
INSERT INTO ESTADO_DETALLE_GRUPO VALUES(1, 'ABIERTO');
INSERT INTO ESTADO_DETALLE_GRUPO VALUES(2, 'CERRADO');
--Tabla ASISTENCIA
INSERT INTO ASISTENCIA VALUES(1, 'PRESENTE');
INSERT INTO ASISTENCIA VALUES(2, 'FALTA');
INSERT INTO ASISTENCIA VALUES(3, 'JUSTIFICADO');
--Tabla AULA
INSERT INTO AULA VALUES(1, 'B-301');
INSERT INTO AULA VALUES(2, 'G-202B');
INSERT INTO AULA VALUES(3, 'B-410');
INSERT INTO AULA VALUES(4, 'B-110');
INSERT INTO AULA VALUES(5, 'B-105');
INSERT INTO AULA VALUES(6, 'G-202A');
INSERT INTO AULA VALUES(7, 'B-402');
INSERT INTO AULA VALUES(8, 'G-201A');
INSERT INTO AULA VALUES(9, 'B-201');
INSERT INTO AULA VALUES(10, 'B-306');
INSERT INTO AULA VALUES(11, 'G-201B');
INSERT INTO AULA VALUES(12, 'B-304');
INSERT INTO AULA VALUES(13, 'G-310');
INSERT INTO AULA VALUES(14, 'B-108');
INSERT INTO AULA VALUES(15, 'B-408');
INSERT INTO AULA VALUES(16, 'B-406');
INSERT INTO AULA VALUES(17, 'B-309');
INSERT INTO AULA VALUES(18, 'B-401');
INSERT INTO AULA VALUES(19, 'B-403');
INSERT INTO AULA VALUES(20, 'B-307');
--Tabla ESCUELA
INSERT INTO ESCUELA VALUES(1, 'CIVIL');
INSERT INTO ESCUELA VALUES(2, 'ELECTRONICA');
INSERT INTO ESCUELA VALUES(3, 'INDUSTRIAL');
INSERT INTO ESCUELA VALUES(4, 'INFORMATICA');
INSERT INTO ESCUELA VALUES(5, 'MECATRONICA');
--Tabla CURSO
INSERT INTO CURSO VALUES('INF123', 'BASE DE DATOS I', 4, 4);
INSERT INTO CURSO VALUES('ELT456', 'FISICA II', 3, 2);
INSERT INTO CURSO VALUES('IND533', 'SISTEMA DE INFORMACION EMPRESARIAL II', 3, 4);
INSERT INTO CURSO VALUES('IND521', 'INGENIERIA DE PROCESO DE NEGOCIOS', 2, 3);
INSERT INTO CURSO VALUES('INF111', 'DERECHO INFORMATICO', 3, 4);
INSERT INTO CURSO VALUES('MCT788', 'CIRCUITOS ELECTRICOS', 3, 5);
INSERT INTO CURSO VALUES('CVL918', 'MECANICA DE FLUIDOS', 4, 1);
INSERT INTO CURSO VALUES('ELT498', 'ELECTROMAGNETISMO', 3, 2);
INSERT INTO CURSO VALUES('CVL955', 'CIMENTACIONES', 5, 1);
INSERT INTO CURSO VALUES('MCT755', 'MECATRONICA MEDICA', 5, 5);
--Tabla PROFESOR
INSERT INTO PROFESOR VALUES(07156121, 'PEDRO', 'CARPIO FARFAN', '1968/09/12');
INSERT INTO PROFESOR VALUES(02119333, 'JOSE', 'PEREZ HUAMAN', '1962/04/19');
INSERT INTO PROFESOR VALUES(05984000, 'CARLOS', 'QUISPE ATUNCAR', '1958/10/16');
INSERT INTO PROFESOR VALUES(02344569, 'AUGUSTO', 'VEGA PINEDO', '1958/10/16');
INSERT INTO PROFESOR VALUES(05984518, 'MIGUEL', 'ARRUNATEGUI ANGULO', '1962/12/01');
INSERT INTO PROFESOR VALUES(03695489, 'FRANCISCO', 'AGUILAR VASQUEZ', '1950/06/20');
INSERT INTO PROFESOR VALUES(02384518, 'SILVIA', 'CAMPOS BENITEZ', '1970/08/23');
INSERT INTO PROFESOR VALUES(03212186, 'LUIS', 'ALARCON LOAYZA', '1968/10/01');
INSERT INTO PROFESOR VALUES(07548563, 'DAVID', 'ARAUCO CABRERA', '1959/03/16');
INSERT INTO PROFESOR VALUES(09964324, 'FABIOLA', 'CORAL MESTANZA', '1965/09/13');
--Tabla PROFxCURSO
INSERT INTO PROFxCURSO VALUES(1, 1, '01');
INSERT INTO PROFxCURSO VALUES(2, 2, '01');
INSERT INTO PROFxCURSO VALUES(3, 3, '01');
INSERT INTO PROFxCURSO VALUES(3, 2, '02');
INSERT INTO PROFxCURSO VALUES(1, 10, '01');
INSERT INTO PROFxCURSO VALUES(2, 9, '01');
INSERT INTO PROFxCURSO VALUES(3, 8, '01');
INSERT INTO PROFxCURSO VALUES(4, 7, '01');
INSERT INTO PROFxCURSO VALUES(6, 5, '01');
INSERT INTO PROFxCURSO VALUES(5, 6, '01');
INSERT INTO PROFxCURSO VALUES(7, 4, '01');
INSERT INTO PROFxCURSO VALUES(8, 3, '02');
INSERT INTO PROFxCURSO VALUES(9, 2, '03');
INSERT INTO PROFxCURSO VALUES(10, 1, '02');
--Tabla TUTORIA
INSERT INTO TUTORIA VALUES('Normalizacion', '2017/11/18', '10:30', '12:30', 2, 1);
INSERT INTO TUTORIA VALUES('Triggers', '2017/11/20', '11:30', '13:30', 2, 1);
INSERT INTO TUTORIA VALUES('Energia Electrica', '2017/11/20', '15:30', '17:30', 1, 2);
INSERT INTO TUTORIA VALUES('Mecanica Basica', '2017/11/21', '15:30', '16:30', 1, 4);
INSERT INTO TUTORIA VALUES('Cuentas y Saldos', '2017/11/22', '8:30', '11:30', 3, 3);
INSERT INTO TUTORIA VALUES('Sueldos y Bases', '2017/11/10', '8:30', '11:30', 10, 3);
INSERT INTO TUTORIA VALUES('Corriente Continua', '2017/11/12', '8:30', '11:30', 8, 4);
INSERT INTO TUTORIA VALUES('Implementacion Manufacturada', '2017/11/13', '8:30', '11:30', 8, 5);
INSERT INTO TUTORIA VALUES('Integrales Definidas', '2017/11/14', '8:30', '11:30', 15, 6);
INSERT INTO TUTORIA VALUES('Diseño Web', '2017/11/16', '8:30', '11:30', 11, 5);
INSERT INTO TUTORIA VALUES('MRUV', '2017/11/17', '8:30', '11:30', 15, 13);
INSERT INTO TUTORIA VALUES('Algoritmos', '2017/11/20', '8:30', '11:30', 17, 6);
INSERT INTO TUTORIA VALUES('Dibujo Tecnico', '2017/11/21', '8:30', '11:30', 9, 7);
INSERT INTO TUTORIA VALUES('Maquinaria Pesada', '2017/11/22', '8:30', '11:30', 5, 7);
INSERT INTO TUTORIA VALUES('Estructuras', '2017/11/23', '8:30', '11:30', 5, 8);
INSERT INTO TUTORIA VALUES('Programacion en Arduino', '2017/11/24', '8:30', '11:30', 9, 8);
INSERT INTO TUTORIA VALUES('JAVA', '2017/11/27', '8:30', '11:30', 2, 9);
INSERT INTO TUTORIA VALUES('Normas Legales', '2017/11/28', '8:30', '11:30', 6, 9);
INSERT INTO TUTORIA VALUES('Derivadas', '2017/11/29', '8:30', '11:30', 1, 10);
INSERT INTO TUTORIA VALUES('Estatica', '2017/11/30', '8:30', '11:30', 1, 10);
--Tabla ALUMNO
INSERT INTO ALUMNO VALUES(201410465, 'Jose', 'Miralles', '1997/01/18', 'Informatica');
INSERT INTO ALUMNO VALUES(201061567, 'Julio', 'Zurita', '1991/04/11', 'Informatica');
INSERT INTO ALUMNO VALUES(201518566, 'Jhairo', 'Caja', '1998/11/11', 'Informatica');
INSERT INTO ALUMNO VALUES(201418566, 'Christian', 'Salazar', '1996/07/17', 'Industrial');
INSERT INTO ALUMNO VALUES(201235698, 'Jordi', 'Cordova', '1996/09/01', 'Informatica');
INSERT INTO ALUMNO VALUES(201845654, 'Franco', 'Condor', '1998/12/01', 'Informatica');
INSERT INTO ALUMNO VALUES(201230259, 'David', 'Saico', '1995/09/12', 'Informatica');
INSERT INTO ALUMNO VALUES(201032012, 'Pedro', 'Aguilar', '1994/10/22', 'Informatica');
INSERT INTO ALUMNO VALUES(201985602, 'Marcial', 'Cabrejos', '1997/04/15', 'Informatica');
INSERT INTO ALUMNO VALUES(201395162, 'Jose', 'Gonzales', '1996/07/17', 'Industrial');
INSERT INTO ALUMNO VALUES(201758419, 'Beatriz', 'Ordoñez', '1994/09/19', 'Industrial');
INSERT INTO ALUMNO VALUES(201987123, 'Bruno', 'Diaz', '1996/10/11', 'Industrial');
INSERT INTO ALUMNO VALUES(201369825, 'Ricardo', 'Tapia', '1993/03/06', 'Industrial');
INSERT INTO ALUMNO VALUES(201741593, 'Roger', 'Fernandez', '1995/10/19', 'Industrial');
INSERT INTO ALUMNO VALUES(201362895, 'Rodolfo', 'Gomez', '1997/05/18', 'Industrial');
INSERT INTO ALUMNO VALUES(201719540, 'Braulio', 'Trigueros', '1998/12/23', 'Industrial');
INSERT INTO ALUMNO VALUES(201032163, 'Angel', 'Villar', '1990/09/16', 'Industrial');
INSERT INTO ALUMNO VALUES(201395170, 'Ricardo', 'Salazar', '1992/05/20', 'Industrial');
INSERT INTO ALUMNO VALUES(201316855, 'Armando', 'Casas', '1998/11/17', 'civil');
INSERT INTO ALUMNO VALUES(201559432, 'Alisson', 'Garcia', '1996/09/12', 'civil');
INSERT INTO ALUMNO VALUES(201020123, 'Roberto', 'Alvarez', '1993/08/01', 'civil');
INSERT INTO ALUMNO VALUES(201332012, 'Enrique', 'Cornejo', '1994/07/10', 'civil');
INSERT INTO ALUMNO VALUES(201998741, 'Leao', 'Gomez', '1990/12/06', 'civil');
INSERT INTO ALUMNO VALUES(201031208, 'Arlette', 'Soriano', '1995/09/12', 'civil');
INSERT INTO ALUMNO VALUES(201985037, 'Carlos', 'Castañeda', '1994/08/10', 'civil');
INSERT INTO ALUMNO VALUES(201610324, 'Jose', 'Taipe', '1992/01/29', 'civil');
INSERT INTO ALUMNO VALUES(201978803, 'Jorge', 'Vera', '1994/04/20', 'civil');
INSERT INTO ALUMNO VALUES(201903108, 'Shirley', 'Alvarez', '1996/07/30', 'Electronica');
INSERT INTO ALUMNO VALUES(201316428, 'Antonio', 'Cartagena', '1990/08/31', 'Electronica');
INSERT INTO ALUMNO VALUES(201147024, 'Karla', 'Peralta', '1992/02/19', 'Electronica');
INSERT INTO ALUMNO VALUES(201021479, 'Lizet', 'Saravia', '1993/06/12', 'Electronica');
INSERT INTO ALUMNO VALUES(201206483, 'Christian', 'Rojas', '1990/01/21', 'Electronica');
INSERT INTO ALUMNO VALUES(201394056, 'Teresa', 'Alvarado', '1996/10/15', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201003150, 'Kiara', 'Benitez', '1994/12/05', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201318310, 'Flor', 'Vega', '1997/06/01', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201031819, 'Rodrigo', 'Huerta', '1995/08/12', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201474582, 'Arnold', 'Alegria', '1996/07/06', 'Informatica');
INSERT INTO ALUMNO VALUES(201423652, 'Pamela', 'Meza', '1998/04/28', 'Informatica');
INSERT INTO ALUMNO VALUES(201130246, 'Marisol', 'Mallma', '1997/12/09', 'Informatica');
INSERT INTO ALUMNO VALUES(201301648, 'Ligia', 'Montoya', '1993/12/25', 'Informatica');
INSERT INTO ALUMNO VALUES(201363036, 'Guadalupe', 'Morales', '1995/01/30', 'Informatica');
INSERT INTO ALUMNO VALUES(201232036, 'Bryan', 'Valdivia', '1992/11/02', 'Informatica');
INSERT INTO ALUMNO VALUES(201362314, 'Carmen', 'Palma', '1990/03/04', 'Informatica');
INSERT INTO ALUMNO VALUES(201356945, 'Pablo', 'Apaza', '1993/08/24', 'Informatica');
INSERT INTO ALUMNO VALUES(201121211, 'Cesar', 'Padilla', '1997/06/17', 'Industrial');
INSERT INTO ALUMNO VALUES(201232018, 'Liam', 'Solorzano', '1992/09/27', 'Industrial');
INSERT INTO ALUMNO VALUES(201213485, 'Robert', 'Ayala', '1994/03/26', 'Industrial');
INSERT INTO ALUMNO VALUES(201326798, 'Jose', 'Perez', '1991/01/19', 'Industrial');
INSERT INTO ALUMNO VALUES(201129879, 'Elias', 'Fano', '1996/08/20', 'Industrial');
INSERT INTO ALUMNO VALUES(201012452, 'Lucero', 'Pascual', '1993/09/16', 'Civil');
INSERT INTO ALUMNO VALUES(201078456, 'Alberto','Chavez', '1990/12/06', 'Civil');
INSERT INTO ALUMNO VALUES(201079656, 'Lisset', 'Villalobos', '1998/09/18', 'Civil');
INSERT INTO ALUMNO VALUES(201236470, 'Jesus', 'Quispe', '1994/06/21', 'Civil');
INSERT INTO ALUMNO VALUES(201647951, 'Jennifer', 'Jimenez', '1995/05/29', 'Civil');
INSERT INTO ALUMNO VALUES(201214579, 'Pedro', 'Godoy', '1994/06/16', 'Civil');
INSERT INTO ALUMNO VALUES(201032030, 'Astrid', 'Caña', '1993/04/10', 'Electronica');
INSERT INTO ALUMNO VALUES(200984266, 'Segundo', 'Vilchez', '1993/11/22', 'Electronica');
INSERT INTO ALUMNO VALUES(201023989, 'Raul', 'Vallejos', '1992/06/21', 'Electronica');
INSERT INTO ALUMNO VALUES(201127956, 'Ernesto', 'Medina', '1994/07/16', 'Electronica');
INSERT INTO ALUMNO VALUES(201321599, 'Manuel', 'Martinez', '1992/10/18', 'Electronica');
INSERT INTO ALUMNO VALUES(201278789, 'Jureck', 'Durand', '1989/10/22', 'Electronica');
INSERT INTO ALUMNO VALUES(201215456, 'Joseph', 'Alcantara', '1996/10/30', 'Electronica');
INSERT INTO ALUMNO VALUES(201125558, 'Elizabeth', 'Salas', '1997/12/08', 'Electronica');
INSERT INTO ALUMNO VALUES(201124533, 'Claudia', 'Valencia', '1992/08/06', 'Electronica');
INSERT INTO ALUMNO VALUES(201110210, 'Magyuri', 'Tanta', '1996/10/08', 'Electronica');
INSERT INTO ALUMNO VALUES(201201202, 'Maria', 'Diez Canseco', '1993/10/01', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201203635, 'Alberto', 'Cueva', '1995/05/17', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201280470, 'Daniel', 'Ramirez', '1996/06/04', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201320120, 'Ronald', 'Vargas', '1993/08/03', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201309879, 'Andy', 'Delgado', '1991/10/09', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201420123, 'Anthony', 'Rocha', '1996/06/03', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201210166, 'Jorge', 'Acurio', '1994/08/12', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201102099, 'Johana', 'San Miguel', '1990/07/30', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201345200, 'Angel', 'Chipa', '1992/08/29', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201236523, 'Rafael', 'Chang', '1992/03/06', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201120303, 'Saul', 'Mascco', '1996/05/20', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201345655, 'Roberto', 'Sediño', '1989/08/12', 'Informatica');
INSERT INTO ALUMNO VALUES(201103492, 'Amparo', 'Almanza', '1989/08/13', 'Informatica');
INSERT INTO ALUMNO VALUES(201310361, 'Rebeca', 'Escribens', '1989/08/14', 'Informatica');
INSERT INTO ALUMNO VALUES(201023659, 'Gianluca', 'Lapadula', '1989/08/15', 'Informatica');
INSERT INTO ALUMNO VALUES(201036429, 'Felix', 'Ortiz', '1989/08/16', 'Informatica');
INSERT INTO ALUMNO VALUES(201236952, 'Rina', 'Castro', '1989/05/30', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201299999, 'Fernado', 'Baltazar', '1991/10/28', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201265633, 'Felipe', 'Pinglo', '1990/06/26', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201218565, 'Henry', 'Arias', '1990/07/24', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201189669, 'Ivan', 'Putin', '1991/08/22', 'Mecatronica');
INSERT INTO ALUMNO VALUES(201659236, 'Dimitri', 'Smith', '1992/10/20', 'Electronica');
INSERT INTO ALUMNO VALUES(201359848, 'Dante', 'Alighieri', '1992/08/17', 'Electronica');
INSERT INTO ALUMNO VALUES(201396981, 'Hector', 'Espinoza', '1992/10/15', 'Electronica');
INSERT INTO ALUMNO VALUES(201300000, 'Arnulfo', 'Buenafuente', '1992/01/13', 'Electronica');
INSERT INTO ALUMNO VALUES(201312500, 'Cecilia', 'Tai', '1992/09/09', 'Electronica');
INSERT INTO ALUMNO VALUES(201300032, 'Susana', 'Baca', '1990/12/06', 'Civil');
INSERT INTO ALUMNO VALUES(201300320, 'Lisa', 'Ann', '1990/12/01', 'Civil');
INSERT INTO ALUMNO VALUES(201400003, 'Kendra', 'Furtado', '1990/04/04', 'Civil');
INSERT INTO ALUMNO VALUES(201400623, 'Daysi', 'Araujo', '1990/04/05', 'Civil');
INSERT INTO ALUMNO VALUES(201400564, 'Victor', 'Becerril', '1990/05/04', 'Civil');
INSERT INTO ALUMNO VALUES(201503132, 'Vanessa', 'de la luz', '1993/10/30', 'Industrial');
INSERT INTO ALUMNO VALUES(201015123, 'Carmen', 'Montana', '1997/12/30', 'Industrial');
INSERT INTO ALUMNO VALUES(201000321, 'Marcelino', 'Sibile', '1997/08/30', 'Industrial');
INSERT INTO ALUMNO VALUES(201011235, 'Carlos', 'Galdos', '1997/03/30', 'Industrial');
INSERT INTO ALUMNO VALUES(201031312, 'Reginaldo', 'Ponce', '1997/05/30', 'Industrial');
go
go

/*CREANDO VIEWS*/
CREATE VIEW [dbo.ESCUELA] AS SELECT * FROM ESCUELA
go
CREATE VIEW [dbo.CURSO] AS SELECT * FROM CURSO
go
CREATE VIEW [dbo.PROFESOR] AS SELECT * FROM PROFESOR
go
CREATE VIEW [dbo.PROFxCURSO] AS SELECT * FROM PROFxCURSO
go
CREATE VIEW [dbo.TUTORIA] AS SELECT * FROM TUTORIA
go
CREATE VIEW [dbo.ALUMNO] AS SELECT * FROM ALUMNO
go
CREATE VIEW [dbo.GRUPO] AS SELECT * FROM GRUPO
go
CREATE VIEW [dbo.REGISTRO] AS SELECT * FROM REGISTRO
go
CREATE VIEW [dbo.AULA] AS SELECT * FROM AULA
go
CREATE VIEW [v.DETALLExGRUPO]
AS
SELECT dg.curso,dg.aspecto_tratado, dg.grupo, dg.cant_regAlumno, edg.descripcionCupo, 
	   da.cant_asistidos, da.cant_faltan, da.cant_justificado
FROM   DETALLE_GRUPO as dg,
	   ESTADO_DETALLE_GRUPO as edg,
	   DETALLE_ASISTENCIA as da
WHERE (dg.id_EstDetGrupo = edg.id_EstDetGrupo AND
	   dg.id_detalleAsist = da.id_detalleAsist)
go
CREATE VIEW [v.GRUPO]
AS
SELECT  grp.codigo_grupo, tut.aspecto_tratado, tut.fecha_tutoria,alum.codigo_alumno,
		CONCAT(alum.apellido_alum,', ',alum.nombre_alum) as alumno, pc.etiqueta_grupo as grupo,
		grp.id_asistencia, reg.nombreTutor, reg.fecha_reg
FROM	GRUPO as grp,
		TUTORIA as tut,
		ALUMNO as alum,
		REGISTRO AS reg,
		PROFxCURSO as pc
WHERE  (grp.id_tutoria = tut.id_tutoria AND
		grp.id_alumno = alum.id_alumno AND
		grp.id_registro = reg.id_registro AND
		tut.codigo_gen = pc.codigo_gen)
go
CREATE VIEW [v.TUTORIAxPROFESOR]
AS
SELECT	tut.id_tutoria, tut.fecha_tutoria, esc.nombre_escuela, tut.aspecto_tratado,
		CONCAT(pro.apellido_prof,', ',pro.nombre_prof) as profesor, cur.nombre_curso, pc.etiqueta_grupo,
		CONCAT(tut.hora_inicio,' - ',tut.hora_fin) as horario, aula.etiqueta_aula
FROM	ESCUELA as esc,
		CURSO as cur,
		PROFESOR as pro,
		PROFxCURSO as pc,
		TUTORIA as tut,
		AULA as aula
WHERE  (tut.codigo_gen = pc.codigo_gen AND
		pc.id_profesor = pro.id_profesor AND
		pc.id_curso = cur.id_curso AND
		cur.id_escuela = esc.id_escuela AND
		tut.id_aula = aula.id_aula)
go
CREATE VIEW [v.REGISTRO]
AS
SELECT	reg.id_registro, reg.nombreTutor, reg.fecha_reg, grp.codigo_grupo, tut.fecha_tutoria, esc.nombre_escuela,
		alum.codigo_alumno, cur.nombre_curso, pc.etiqueta_grupo, tut.aspecto_tratado,
		CONCAT(alum.apellido_alum,', ',alum.nombre_alum) as estudiante
FROM	REGISTRO as reg,
		GRUPO as grp,
		TUTORIA as tut,
		ALUMNO as alum,
		PROFxCURSO as pc,
		PROFESOR as pro,
		CURSO as cur,
		ESCUELA as esc 
WHERE  (reg.id_registro = grp.id_registro AND
		grp.id_tutoria = tut.id_tutoria AND
		grp.id_alumno = alum.id_alumno AND
		tut.codigo_gen = pc.codigo_gen AND
		pc.id_profesor = pro.id_profesor AND
		pc.id_curso = cur.id_curso AND
		cur.id_escuela = esc.id_escuela)
go
go

--CREANDO PROCEDIMIENTOS ALMACENADOS
go
/*V.E: Codigo del alumno, Id. Tutoria, Id. Asistencia*/
CREATE PROCEDURE sp_asistencia
@codigo_alumno int, @id_tutoria int, @id_asistencia int
AS
BEGIN
UPDATE grp SET grp.id_asistencia = @id_asistencia
FROM GRUPO AS grp
INNER JOIN ALUMNO as alum ON(grp.id_alumno = alum.id_alumno)
WHERE grp.id_tutoria = @id_tutoria AND alum.codigo_alumno = @codigo_alumno
/*Cuando relacionas un alumno que no pertenezca a un grupo de tutoria,
  no afectara ni producira ninguna fila.*/
END
go
--exec sp_asistencia 201418566, 1, 3
go

go
/*Inserta a la tabla GRUPO, ademas relacionando con su respectivo id_registro correctamente.
  V.E: Codigo del alumno, Id. Tutoria, Id. Asistencia*/
CREATE PROCEDURE sp_insertaGrupo
@id_tutoria int, @id_alumno int
AS
BEGIN
	DECLARE @nombreTutor varchar(50), @id_registro varchar(6)
	SET @nombreTutor = (Select distinct	CONCAT(prof.apellido_prof,', ',prof.nombre_prof)
						from	TUTORIA as tut,
								PROFxCURSO as pc,
								PROFESOR as prof
						where  (tut.codigo_gen = pc.codigo_gen AND
								pc.id_profesor = prof.id_profesor AND
								tut.id_tutoria = @id_tutoria))
	SET @id_registro = (Select	id_registro
						from	REGISTRO
						where	nombreTutor = @nombreTutor)
	--Relaciona el id_registro de ambas tablas de acuerdo a la tutoria que dicta respectivamente del profesor
	INSERT INTO GRUPO VALUES(@id_tutoria, @id_alumno, null, @id_registro);
END
go
/*exec sp_insertaGrupo 1, 1
exec sp_insertaGrupo 1, 2
exec sp_insertaGrupo 3, 1
exec sp_insertaGrupo 5, 3
exec sp_insertaGrupo 1, 4*/
go
go

--Tabla GRUPO con sp_insertaGrupo
exec sp_insertaGrupo 1, 1
exec sp_insertaGrupo 1, 2
exec sp_insertaGrupo 1, 3
exec sp_insertaGrupo 1, 4
exec sp_insertaGrupo 1, 5
exec sp_insertaGrupo 1, 6
exec sp_insertaGrupo 1, 7
exec sp_insertaGrupo 1, 8
exec sp_insertaGrupo 1, 9
exec sp_insertaGrupo 1, 10
exec sp_insertaGrupo 1, 11
exec sp_insertaGrupo 1, 12
exec sp_insertaGrupo 1, 13
exec sp_insertaGrupo 1, 14
exec sp_insertaGrupo 1, 15
exec sp_insertaGrupo 2, 16
exec sp_insertaGrupo 2, 17
exec sp_insertaGrupo 2, 18
exec sp_insertaGrupo 2, 19
exec sp_insertaGrupo 2, 20
exec sp_insertaGrupo 2, 21
exec sp_insertaGrupo 2, 22
exec sp_insertaGrupo 2, 23
exec sp_insertaGrupo 2, 24
exec sp_insertaGrupo 2, 25
exec sp_insertaGrupo 3, 26
exec sp_insertaGrupo 3, 27
exec sp_insertaGrupo 3, 28
exec sp_insertaGrupo 3, 29
exec sp_insertaGrupo 3, 30
exec sp_insertaGrupo 3, 31
exec sp_insertaGrupo 3, 32
exec sp_insertaGrupo 3, 33
exec sp_insertaGrupo 3, 34
exec sp_insertaGrupo 3, 35
exec sp_insertaGrupo 3, 36
exec sp_insertaGrupo 3, 37
exec sp_insertaGrupo 3, 38
exec sp_insertaGrupo 4, 39
exec sp_insertaGrupo 4, 40
exec sp_insertaGrupo 4, 41
exec sp_insertaGrupo 4, 42
exec sp_insertaGrupo 4, 43
exec sp_insertaGrupo 4, 44
exec sp_insertaGrupo 4, 45
exec sp_insertaGrupo 4, 46
exec sp_insertaGrupo 4, 47
exec sp_insertaGrupo 4, 48
exec sp_insertaGrupo 4, 49
exec sp_insertaGrupo 4, 50
exec sp_insertaGrupo 4, 51
exec sp_insertaGrupo 4, 52
exec sp_insertaGrupo 4, 53
exec sp_insertaGrupo 4, 54
exec sp_insertaGrupo 4, 55
exec sp_insertaGrupo 4, 56
exec sp_insertaGrupo 5, 57
exec sp_insertaGrupo 5, 58
exec sp_insertaGrupo 5, 59
exec sp_insertaGrupo 5, 60
exec sp_insertaGrupo 5, 61
exec sp_insertaGrupo 5, 62
exec sp_insertaGrupo 5, 63
exec sp_insertaGrupo 5, 64
exec sp_insertaGrupo 5, 65
exec sp_insertaGrupo 5, 66
exec sp_insertaGrupo 5, 67
exec sp_insertaGrupo 5, 68
exec sp_insertaGrupo 5, 69
exec sp_insertaGrupo 5, 70
exec sp_insertaGrupo 5, 71
exec sp_insertaGrupo 5, 72
exec sp_insertaGrupo 5, 73
exec sp_insertaGrupo 5, 74
exec sp_insertaGrupo 5, 75
exec sp_insertaGrupo 5, 76
exec sp_insertaGrupo 6, 77
exec sp_insertaGrupo 6, 78
exec sp_insertaGrupo 6, 79
exec sp_insertaGrupo 6, 80
exec sp_insertaGrupo 6, 81
exec sp_insertaGrupo 6, 82
exec sp_insertaGrupo 6, 83
exec sp_insertaGrupo 6, 84
exec sp_insertaGrupo 6, 85
exec sp_insertaGrupo 6, 86
exec sp_insertaGrupo 6, 87
exec sp_insertaGrupo 6, 88
exec sp_insertaGrupo 6, 89
exec sp_insertaGrupo 6, 90
exec sp_insertaGrupo 6, 91
exec sp_insertaGrupo 6, 92
exec sp_insertaGrupo 6, 93
exec sp_insertaGrupo 6, 94
exec sp_insertaGrupo 6, 95
exec sp_insertaGrupo 6, 96
exec sp_insertaGrupo 6, 97
exec sp_insertaGrupo 6, 98
exec sp_insertaGrupo 6, 99
exec sp_insertaGrupo 6, 100
exec sp_insertaGrupo 6, 101
exec sp_insertaGrupo 6, 1
exec sp_insertaGrupo 6, 2
exec sp_insertaGrupo 6, 3
exec sp_insertaGrupo 6, 4
exec sp_insertaGrupo 6, 5
exec sp_insertaGrupo 6, 6
exec sp_insertaGrupo 6, 7
exec sp_insertaGrupo 6, 8
exec sp_insertaGrupo 6, 9
exec sp_insertaGrupo 6, 10
exec sp_insertaGrupo 6, 11
exec sp_insertaGrupo 6, 12
exec sp_insertaGrupo 6, 13
exec sp_insertaGrupo 6, 14
exec sp_insertaGrupo 6, 15
exec sp_insertaGrupo 7, 16
exec sp_insertaGrupo 7, 17
exec sp_insertaGrupo 7, 18
exec sp_insertaGrupo 7, 19
exec sp_insertaGrupo 7, 20
exec sp_insertaGrupo 7, 21
exec sp_insertaGrupo 7, 22
exec sp_insertaGrupo 7, 23
exec sp_insertaGrupo 7, 24
exec sp_insertaGrupo 7, 25
exec sp_insertaGrupo 7, 26
exec sp_insertaGrupo 7, 27
exec sp_insertaGrupo 7, 28
exec sp_insertaGrupo 7, 29
exec sp_insertaGrupo 7, 30
exec sp_insertaGrupo 7, 31
exec sp_insertaGrupo 7, 32
exec sp_insertaGrupo 7, 33
exec sp_insertaGrupo 7, 34
exec sp_insertaGrupo 7, 35
exec sp_insertaGrupo 8, 36
exec sp_insertaGrupo 8, 37
exec sp_insertaGrupo 8, 38
exec sp_insertaGrupo 8, 39
exec sp_insertaGrupo 8, 40
exec sp_insertaGrupo 8, 41
exec sp_insertaGrupo 8, 42
exec sp_insertaGrupo 8, 43
exec sp_insertaGrupo 8, 44
exec sp_insertaGrupo 8, 45
exec sp_insertaGrupo 8, 46
exec sp_insertaGrupo 8, 47
exec sp_insertaGrupo 8, 48
exec sp_insertaGrupo 8, 49
exec sp_insertaGrupo 8, 50
exec sp_insertaGrupo 9, 51
exec sp_insertaGrupo 9, 52
exec sp_insertaGrupo 9, 53
exec sp_insertaGrupo 9, 54
exec sp_insertaGrupo 9, 55
exec sp_insertaGrupo 9, 56
exec sp_insertaGrupo 9, 57
exec sp_insertaGrupo 9, 58
exec sp_insertaGrupo 9, 59
exec sp_insertaGrupo 9, 60
exec sp_insertaGrupo 9, 61
exec sp_insertaGrupo 9, 62
exec sp_insertaGrupo 9, 63
exec sp_insertaGrupo 9, 64
exec sp_insertaGrupo 9, 65
exec sp_insertaGrupo 9, 66
exec sp_insertaGrupo 9, 67
exec sp_insertaGrupo 9, 68
exec sp_insertaGrupo 9, 69
exec sp_insertaGrupo 9, 70
exec sp_insertaGrupo 10, 71
exec sp_insertaGrupo 10, 72
exec sp_insertaGrupo 10, 73
exec sp_insertaGrupo 10, 74
exec sp_insertaGrupo 10, 75
exec sp_insertaGrupo 10, 76
exec sp_insertaGrupo 10, 77
exec sp_insertaGrupo 10, 78
exec sp_insertaGrupo 10, 79
exec sp_insertaGrupo 10, 80
exec sp_insertaGrupo 11, 81
exec sp_insertaGrupo 11, 82
exec sp_insertaGrupo 11, 83
exec sp_insertaGrupo 11, 84
exec sp_insertaGrupo 11, 85
exec sp_insertaGrupo 11, 86
exec sp_insertaGrupo 11, 87
exec sp_insertaGrupo 11, 88
exec sp_insertaGrupo 11, 89
exec sp_insertaGrupo 11, 90
exec sp_insertaGrupo 11, 91
exec sp_insertaGrupo 11, 92
exec sp_insertaGrupo 11, 93
exec sp_insertaGrupo 11, 94
exec sp_insertaGrupo 11, 95
exec sp_insertaGrupo 11, 96
exec sp_insertaGrupo 11, 97
exec sp_insertaGrupo 11, 98
exec sp_insertaGrupo 11, 99
exec sp_insertaGrupo 11, 100
exec sp_insertaGrupo 11, 101
exec sp_insertaGrupo 12, 1
exec sp_insertaGrupo 12, 2
exec sp_insertaGrupo 12, 3
exec sp_insertaGrupo 12, 4
exec sp_insertaGrupo 12, 5
exec sp_insertaGrupo 12, 6
exec sp_insertaGrupo 12, 7
exec sp_insertaGrupo 12, 8
exec sp_insertaGrupo 12, 9
exec sp_insertaGrupo 12, 10
exec sp_insertaGrupo 12, 11
exec sp_insertaGrupo 12, 12
exec sp_insertaGrupo 12, 13
exec sp_insertaGrupo 12, 14
exec sp_insertaGrupo 12, 15
exec sp_insertaGrupo 13, 16
exec sp_insertaGrupo 13, 17
exec sp_insertaGrupo 13, 18
exec sp_insertaGrupo 13, 19
exec sp_insertaGrupo 13, 20
exec sp_insertaGrupo 13, 21
exec sp_insertaGrupo 13, 22
exec sp_insertaGrupo 13, 23
exec sp_insertaGrupo 13, 24
exec sp_insertaGrupo 13, 25
exec sp_insertaGrupo 13, 26
exec sp_insertaGrupo 13, 27
exec sp_insertaGrupo 13, 28
exec sp_insertaGrupo 13, 29
exec sp_insertaGrupo 13, 30
exec sp_insertaGrupo 13, 31
exec sp_insertaGrupo 13, 32
exec sp_insertaGrupo 13, 33
exec sp_insertaGrupo 13, 34
exec sp_insertaGrupo 14, 35
exec sp_insertaGrupo 14, 36
exec sp_insertaGrupo 14, 37
exec sp_insertaGrupo 14, 38
exec sp_insertaGrupo 14, 39
exec sp_insertaGrupo 14, 40
exec sp_insertaGrupo 14, 41
exec sp_insertaGrupo 14, 42
exec sp_insertaGrupo 14, 43
exec sp_insertaGrupo 14, 44
exec sp_insertaGrupo 14, 45
exec sp_insertaGrupo 14, 46
exec sp_insertaGrupo 14, 47
exec sp_insertaGrupo 14, 48
exec sp_insertaGrupo 14, 49
exec sp_insertaGrupo 14, 50
exec sp_insertaGrupo 14, 51
exec sp_insertaGrupo 14, 52
exec sp_insertaGrupo 14, 53
exec sp_insertaGrupo 14, 54
exec sp_insertaGrupo 14, 55
exec sp_insertaGrupo 14, 56
exec sp_insertaGrupo 14, 57
exec sp_insertaGrupo 14, 58
exec sp_insertaGrupo 14, 59
exec sp_insertaGrupo 14, 60
exec sp_insertaGrupo 14, 61
exec sp_insertaGrupo 14, 62
exec sp_insertaGrupo 14, 63
exec sp_insertaGrupo 14, 64
exec sp_insertaGrupo 14, 65
exec sp_insertaGrupo 14, 66
exec sp_insertaGrupo 15, 67
exec sp_insertaGrupo 15, 68
exec sp_insertaGrupo 15, 69
exec sp_insertaGrupo 15, 70
exec sp_insertaGrupo 15, 71
exec sp_insertaGrupo 15, 72
exec sp_insertaGrupo 15, 73
exec sp_insertaGrupo 15, 74
exec sp_insertaGrupo 15, 75
exec sp_insertaGrupo 15, 76
exec sp_insertaGrupo 15, 77
exec sp_insertaGrupo 15, 78
exec sp_insertaGrupo 15, 79
exec sp_insertaGrupo 15, 80
exec sp_insertaGrupo 15, 81
exec sp_insertaGrupo 15, 82
exec sp_insertaGrupo 15, 83
exec sp_insertaGrupo 15, 84
exec sp_insertaGrupo 15, 85
exec sp_insertaGrupo 15, 86
exec sp_insertaGrupo 15, 87
exec sp_insertaGrupo 15, 88
exec sp_insertaGrupo 15, 89
exec sp_insertaGrupo 15, 90
exec sp_insertaGrupo 15, 91
exec sp_insertaGrupo 15, 92
exec sp_insertaGrupo 15, 93
exec sp_insertaGrupo 15, 94
exec sp_insertaGrupo 15, 95
exec sp_insertaGrupo 16, 95
exec sp_insertaGrupo 16, 96
exec sp_insertaGrupo 16, 97
exec sp_insertaGrupo 16, 98
exec sp_insertaGrupo 16, 99
exec sp_insertaGrupo 16, 100
exec sp_insertaGrupo 16, 28
exec sp_insertaGrupo 16, 1
exec sp_insertaGrupo 16, 2
exec sp_insertaGrupo 16, 3
exec sp_insertaGrupo 16, 4
exec sp_insertaGrupo 16, 5
exec sp_insertaGrupo 16, 6
exec sp_insertaGrupo 17, 7
exec sp_insertaGrupo 17, 8
exec sp_insertaGrupo 17, 9
exec sp_insertaGrupo 17, 10
exec sp_insertaGrupo 17, 11
exec sp_insertaGrupo 17, 12
exec sp_insertaGrupo 17, 13
exec sp_insertaGrupo 17, 14
exec sp_insertaGrupo 17, 15
exec sp_insertaGrupo 17, 16
exec sp_insertaGrupo 17, 17
exec sp_insertaGrupo 17, 18
exec sp_insertaGrupo 17, 19
exec sp_insertaGrupo 17, 20
exec sp_insertaGrupo 17, 21
exec sp_insertaGrupo 17, 22
exec sp_insertaGrupo 17, 23
exec sp_insertaGrupo 17, 24
exec sp_insertaGrupo 17, 25
exec sp_insertaGrupo 17, 26
exec sp_insertaGrupo 17, 27
exec sp_insertaGrupo 18, 28
exec sp_insertaGrupo 18, 29
exec sp_insertaGrupo 18, 30
exec sp_insertaGrupo 18, 31
exec sp_insertaGrupo 18, 32
exec sp_insertaGrupo 18, 33
exec sp_insertaGrupo 18, 34
exec sp_insertaGrupo 18, 35
exec sp_insertaGrupo 18, 36
exec sp_insertaGrupo 18, 37
exec sp_insertaGrupo 18, 38
exec sp_insertaGrupo 18, 39
exec sp_insertaGrupo 18, 40
exec sp_insertaGrupo 18, 41
exec sp_insertaGrupo 18, 42
exec sp_insertaGrupo 18, 43
exec sp_insertaGrupo 18, 44
exec sp_insertaGrupo 18, 45
exec sp_insertaGrupo 18, 46
exec sp_insertaGrupo 18, 47
exec sp_insertaGrupo 19, 48
exec sp_insertaGrupo 19, 49
exec sp_insertaGrupo 19, 50
exec sp_insertaGrupo 19, 51
exec sp_insertaGrupo 19, 52
exec sp_insertaGrupo 19, 53
exec sp_insertaGrupo 19, 54
exec sp_insertaGrupo 19, 55
exec sp_insertaGrupo 19, 56
exec sp_insertaGrupo 19, 57
exec sp_insertaGrupo 19, 58
exec sp_insertaGrupo 19, 59
exec sp_insertaGrupo 19, 60
exec sp_insertaGrupo 19, 61
exec sp_insertaGrupo 19, 62
exec sp_insertaGrupo 19, 63
exec sp_insertaGrupo 20, 64
exec sp_insertaGrupo 20, 65
exec sp_insertaGrupo 20, 66
exec sp_insertaGrupo 20, 67
exec sp_insertaGrupo 20, 68
exec sp_insertaGrupo 20, 69
exec sp_insertaGrupo 20, 70
exec sp_insertaGrupo 20, 71
exec sp_insertaGrupo 20, 72
exec sp_insertaGrupo 20, 73
exec sp_insertaGrupo 20, 74
exec sp_insertaGrupo 20, 75
exec sp_insertaGrupo 20, 76
exec sp_insertaGrupo 20, 77
exec sp_insertaGrupo 20, 78
exec sp_insertaGrupo 20, 79
exec sp_insertaGrupo 20, 80
exec sp_insertaGrupo 20, 81
exec sp_insertaGrupo 20, 82
exec sp_insertaGrupo 20, 83
exec sp_insertaGrupo 20, 84
exec sp_insertaGrupo 20, 85
exec sp_insertaGrupo 20, 86
exec sp_insertaGrupo 20, 87
exec sp_insertaGrupo 20, 88
exec sp_insertaGrupo 20, 89
exec sp_insertaGrupo 20, 90
exec sp_insertaGrupo 20, 91
exec sp_insertaGrupo 20, 92
exec sp_insertaGrupo 20, 93
exec sp_insertaGrupo 20, 94
exec sp_insertaGrupo 20, 95
exec sp_insertaGrupo 20, 96
exec sp_insertaGrupo 20, 97
exec sp_insertaGrupo 20, 98
exec sp_insertaGrupo 20, 99
exec sp_insertaGrupo 20, 100
exec sp_insertaGrupo 20, 101
exec sp_insertaGrupo 20, 1
exec sp_insertaGrupo 20, 2
go

--RESULTADO
go
select * from [dbo.GRUPO]
select * from [v.DETALLExGRUPO]
select * from [v.GRUPO]
select * from [v.TUTORIAxPROFESOR]
select * from [v.REGISTRO]
go

--DB COMPLETED