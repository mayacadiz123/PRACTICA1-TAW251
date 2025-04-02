# PRACTICA1-TAW251 - API de Estudiantes

## Descripción

Este es un proyecto desarrollado con **Spring Boot** para gestionar una API RESTful de estudiantes. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los datos de los estudiantes.

### Funcionalidades:

- **GET** /estudiantes: Listar todos los estudiantes.
- **GET** /estudiantes/{id}: Obtener un estudiante por su ID.
- **POST** /estudiantes: Crear un nuevo estudiante.
- **PUT** /estudiantes/{id}: Actualizar los datos de un estudiante existente.
- **DELETE** /estudiantes/{id}: Eliminar un estudiante por su ID.

## Tecnologías utilizadas

- **Spring Boot** para el backend.
- **Maven** para la gestión de dependencias.
- **Postman** para probar las operaciones de la API.
- **Git** para el control de versiones y subida del código a GitHub.

## Instalación

1. Clona este repositorio en tu máquina local:
git clone https://github.com/mayacadiz123/PRACTICA1-TAW251.git

2. Navega al directorio del proyecto:
cd PRACTICA1-TAW251
3. Ejecuta el proyecto con Maven:
./mvnw spring-boot:run

4. Accede a la API en http://localhost:8080/estudiantes.

## Pruebas con Postman

Para probar los diferentes métodos de la API, se utilizó **Postman**.

- **GET** /estudiantes: Devuelve todos los estudiantes.
- **GET** /estudiantes/{id}: Devuelve el estudiante con el ID especificado.
- **POST** /estudiantes: Crea un nuevo estudiante. Se debe enviar un JSON con los campos nombre, edad, y email.
- **PUT** /estudiantes/{id}: Actualiza un estudiante existente. Se debe enviar un JSON con los campos nombre, edad, y email.
- **DELETE** /estudiantes/{id}: Elimina un estudiante por su ID.

## Enlace al repositorio

Puedes acceder al repositorio en GitHub haciendo clic en el siguiente enlace:

[https://github.com/mayacadiz123/PRACTICA1-TAW251.git](https://github.com/mayacadiz123/PRACTICA1-TAW251.git) 