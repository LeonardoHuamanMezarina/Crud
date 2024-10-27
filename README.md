# **CRUD de Alumnos con Java y MySQL**

Este proyecto es una aplicación de escritorio en Java que permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una base de datos MySQL, gestionando un registro de alumnos.

**Requisitos**

- **Java JDK 11+**
- **NetBeans**
- **MySQL** (v8.0 o superior)
- **Conexión con MySQL** configurada en `conexion.java`


```bash
usuario = "root";
contraseña = "logan695";
bd = "crud";
ip = "127.0.0.1";
puerto = "3306";
```

## Funcionalidades CRUD

**1. Crear (Insertar Alumnos)**

Permite registrar un nuevo alumno en la base de datos.

* **Formulario:** Se ingresan el nombre y apellido del alumno.
* **Botón:** Guardar
* **Método:** InsertarAlumno()
* **Query SQL:**
```bash
INSERT INTO Alumnos (nombres, apellidos) VALUES (?, ?);
```
* **Mensaje de éxito:** "Se insertó correctamente el alumno".


**2. Leer (Mostrar Alumnos)**

Muestra en una tabla todos los alumnos registrados en la base de datos.

* **Tabla:** tbTotalAlumnos
* **Método:** MostrarAlumnos()
* **Query SQL**
```bash
SELECT * FROM Alumnos;
```
* **Si ocurre un error, se muestra un mensaje:** "No se pudo mostrar el registro".


**3. Actualizar (Modificar Alumnos)**

Permite modificar los datos de un alumno seleccionado.
* **Proceso:**
    -  1.0 Seleccionar un alumno de la tabla con un clic.
    -  2.0 Los datos se cargan en los campos de texto.
    -  3.0 Modificar los campos y presionar el botón `Modificar`.
* **Método:** `ModificarAlumnos()`
* **Método:** MostrarAlumnos()
* **Query SQL**
```bash
UPDATE Alumnos SET nombres = ?, apellidos = ? WHERE id = ?;

```
* **Mensaje de éxito:** "Modificación exitosa".

**4. Eliminar (Borrar Alumnos)**

Elimina un alumno seleccionado por su ID.
* **Proceso:**
    -  1.0 Seleccionar un alumno en la tabla.
    -  2.0 Presionar el botón `Eliminar`.
* **Método:** `EliminarAlumnos()`
* **Query SQL**
```bash
DELETE FROM Alumnos WHERE id = ?;

```
* **Mensaje de éxito:** "Se eliminó correctamente el alumno".


## Autor

- Por [Leonardo HM](https://github.com/LeonardoHuamanMezarina)
