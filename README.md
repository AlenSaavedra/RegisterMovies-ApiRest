# API REST para la Gestión de Películas

Esta API REST permite crear, actualizar, eliminar y visualizar registros de películas. Puedes agregar tus películas favoritas, visualizarlas en una tabla y administrarlas como si fuera una agenda de películas.

## Funcionalidades

- **Crear Películas**: Agrega una nueva película a la base de datos.
- **Listar Películas**: Muestra todas las películas registradas en una tabla.
- **Editar Películas**: Actualiza los datos de una película existente.
- **Eliminar Películas**: Elimina una película del registro.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework utilizado para construir la API REST.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **MySQL** (o cualquier base de datos compatible): Para almacenar los registros de películas.
- **Thymeleaf** (opcional): Para la interfaz de usuario.
- **HTML, CSS, JavaScript**: Para la visualización de los datos y la interacción de usuario en el front-end.

## Estructura de la API

La API incluye los siguientes endpoints:

- `POST /api/peliculas`: Crea una nueva película.
- `GET /api/peliculas`: Lista todas las películas.
- `GET /api/peliculas/{id}`: Muestra los detalles de una película específica.
- `PUT /api/peliculas/{id}`: Actualiza los datos de una película.
- `DELETE /api/peliculas/{id}`: Elimina una película.

## Instalación y Ejecución

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/AlenSaavedra/RegisterMovies-ApiRest.git
   cd RegisterMovies-ApiRest
   ```

2. **Configura la base de datos**:

   Asegúrate de tener una base de datos MySQL configurada y crea una nueva base de datos llamada `peliculas_db`. Actualiza el archivo `application.properties` con tus credenciales de MySQL:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/peliculas_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Ejecuta la aplicación**:

   Ejecuta el proyecto de Spring Boot en tu entorno de desarrollo o desde la línea de comandos:

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Accede a la aplicación**:

   Una vez que la aplicación esté en ejecución, accede a los endpoints en `http://localhost:8080/api/peliculas`.

## Uso de la API

### Crear una nueva película

Para agregar una nueva película, realiza una solicitud `POST` al endpoint `/api/peliculas` con el siguiente cuerpo de solicitud en formato JSON:

```json
{
  "titulo": "Inception",
  "director": "Christopher Nolan",
  "año": 2010,
  "genero": "Ciencia Ficción"
}
```

### Listar todas las películas

Realiza una solicitud `GET` a `/api/peliculas` para obtener una lista de todas las películas registradas.

### Editar una película

Para actualizar una película, realiza una solicitud `PUT` a `/api/peliculas/{id}`, donde `{id}` es el ID de la película, con el siguiente cuerpo de solicitud:

```json
{
  "titulo": "Inception",
  "director": "Christopher Nolan",
  "año": 2010,
  "genero": "Ciencia Ficción"
}
```

### Eliminar una película

Para eliminar una película, realiza una solicitud `DELETE` a `/api/peliculas/{id}`.

## Interfaz de Usuario (Opcional)

La aplicación también incluye una interfaz en HTML donde puedes ver, agregar, editar y eliminar películas desde una tabla interactiva.

### Registro de Películas

Aquí puedes ver cómo se presenta el formulario para registrar una nueva película:


![RegisterMovie](https://github.com/user-attachments/assets/26d080eb-668b-4404-9a22-4a849b0f570f)

### Tabla de Películas

En esta sección, puedes visualizar la tabla con todas las películas registradas, donde también puedes editar y eliminar las entradas:

![TablaMovies](https://github.com/user-attachments/assets/295ea371-002d-4857-be66-db0eb6f1934e)


## Contribución

Si deseas contribuir al proyecto, siéntete libre de hacer un fork y enviar tus propuestas a través de un Pull Request. Cualquier ayuda para mejorar la API es bienvenida.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para obtener más detalles.
```

### Pasos para agregar las imágenes:

1. **Sube las imágenes a tu repositorio**: 
   Coloca las imágenes (por ejemplo, `registro_pelicula.png` y `tabla_peliculas.png`) en la carpeta del proyecto, por ejemplo, en una carpeta `images` o directamente en la raíz del repositorio.

2. **Actualiza las rutas de las imágenes**: 
   En los apartados de las imágenes, cambia `ruta/a/tu/imagen/registro_pelicula.png` y `ruta/a/tu/imagen/tabla_peliculas.png` por las rutas reales donde hayas subido las imágenes en tu repositorio.
