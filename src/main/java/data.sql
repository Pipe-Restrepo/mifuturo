------- Script para asignar y referenciar llave------

alter table Persona add primary key (id);
alter table Usuario add primary key (id);

------- Script para crear tablas y relaciones------

CREATE TABLE Persona (
    id int auto_increment primary key,
    nombre varchar(50),
    apellido varchar(50),
    tipo varchar(20)
);

CREATE TABLE Usuario (
    id int auto_increment primary key,
    prestamos int,
    foreign key (id) references Persona(id)
);

CREATE TABLE Bibliotecario (
    id int,
    foreign key (id) references Persona(id)
);

CREATE TABLE Libro (
    id int auto_increment primary key,
    titulo varchar(100),
    autor varchar(100),
    isbn varchar(13),
    disponible boolean
);

CREATE TABLE Prestamo (
    id INT auto_increment primary key,
    libro_id int,
    usuario_id int,
    fecha_prestamo date,
    fecha_devolucion date,
    foreign key (libro_id) references Libro(id),
    foreign key (usuario_id) references Usuario(id)
);


------- Script para insertar datos en tablas Libro, Usuario y Bibliotecario------

SELECT * FROM biblioteca_db.libro;

insert into Libro (titulo, autor, isbn, disponible) values ('El olvido que seremos', 'Hector Abad', 999888, true);
insert into Libro (titulo, autor, isbn, disponible) values ('La voragine', 'Jose Eustacio Rivera', 999887, true);
insert into Libro (titulo, autor, isbn, disponible) values ('Maria', 'Jose Isacc', 999886, true);
insert into Libro (titulo, autor, isbn, disponible) values ('En Agosto nos vemos', 'Gabriel Garcia', 999885, true);
insert into Libro (titulo, autor, isbn, disponible) values ('Opio en las nubes', 'Rafael Chaparro', 999884, true);



SELECT * FROM biblioteca_db.persona;

insert into Persona (id, nombre, apellido, tipo) values (1,'Julio', 'Perez', 'Usuario');
insert into Persona (id, nombre, apellido, tipo) values (2,'Lilo', 'Suarez', 'Usuario');
insert into Persona (id, nombre, apellido, tipo) values (3,'Jose', 'Rojas', 'Usuario');
insert into Persona (id, nombre, apellido, tipo) values (4,'Nino', 'Peña', 'Usuario');
insert into Persona (id, nombre, apellido, tipo) values (5,'Jorge', 'Castro', 'Usuario');


SELECT * FROM biblioteca_db.usuario;

insert into Usuario (id, prestamos) values (1, 3);
insert into Usuario (id, prestamos) values (2, 10);
insert into Usuario (id, prestamos) values (3, 5);
insert into Usuario (id, prestamos) values (4, 4);
insert into Usuario (id, prestamos) values (5, 9);


SELECT * FROM biblioteca_db.bibliotecario;

insert into bibliotecario (id) values (55);
insert into bibliotecario (id) values (22);
insert into bibliotecario (id) values (78);
insert into bibliotecario (id) values (14);
insert into bibliotecario (id) values (63);