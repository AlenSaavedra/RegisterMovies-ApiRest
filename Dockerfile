# Usa una imagen base de OpenJDK
FROM openjdk:23-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto a la imagen de Docker
COPY . /app

# Instala Maven (si es necesario)
RUN apt-get update && apt-get install -y maven

# Da permisos a mvnw (si es necesario)
RUN chmod +x ./mvnw

# Ejecuta el comando para construir el proyecto
RUN ./mvnw clean install

# Exponer el puerto de la aplicación Spring Boot
EXPOSE 8080

# Comando para iniciar la aplicación
CMD ["./mvnw", "spring-boot:run"]