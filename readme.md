# API de Clubes con Swagger

Este proyecto es una práctica para aprender a configurar Swagger en una aplicación Spring Boot.

## 📌 Descripción
La API de Clubes permite obtener una lista de equipos de fútbol y explorar su información de manera estructurada. Como parte del aprendizaje, se configuró Swagger para documentar y probar la API de manera interactiva.

## 🚀 Tecnologías Utilizadas
- **Spring Boot**: Framework para la creación de aplicaciones Java.
- **Springdoc OpenAPI**: Generador automático de documentación para API RESTful.
- **Swagger UI**: Interfaz gráfica para explorar y probar la API.

## 🛠️ Configuración de Swagger
Durante la implementación de Swagger en este proyecto, se configuraron los siguientes elementos:

### 📄 Información de la API
Se definieron detalles como el título, descripción, versión, términos de servicio y contacto del desarrollador.

### 🌍 Servidores
Se añadieron dos entornos:
- **Servidor de Desarrollo**: `http://localhost:8080`
- **Servidor de Producción**: `https://prod-enviroment.com:8080`

### 🔒 Seguridad
Se implementó la autenticación con **JWT (JSON Web Token)** utilizando el esquema **Bearer Token**.

## 📂 Endpoints de la API
Algunos de los endpoints disponibles en la API incluyen:
- `GET /clubs` - Obtiene la lista de clubes.
- `GET /clubs/{id}` - Obtiene los detalles de un club específico.
- `POST /clubs` - Agrega un nuevo club.
- `PUT /clubs/{id}` - Actualiza un club existente.
- `DELETE /clubs/{id}` - Elimina un club.

## 📖 Acceso a Swagger UI
Para visualizar y probar la API de manera interactiva, accede a **Swagger UI** en:
- **Local:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Producción:** [https://prod-enviroment.com:8080/swagger-ui.html](https://prod-enviroment.com:8080/swagger-ui.html)

## 📌 Instalación y Ejecución
1. Clona el repositorio:
   ```sh
   git clone https://github.com/DiegoOrtiz27/SpringBoot-Swagger.git
   ```
2. Ingresa al directorio del proyecto:
   ```sh
   cd SpringBoot-Swagger
   ```
3. Ejecuta la aplicación con Maven:
   ```sh
   mvn spring-boot:run
   ```

## ✨ Contribuciones
Este proyecto es solo una práctica, pero si deseas contribuir, ¡eres bienvenido! Puedes realizar un **fork**, crear una nueva rama y enviar un **pull request**.

## 📧 Contacto
- **Desarrollador:** Diego Ortiz  
- **GitHub:** [DiegoOrtiz27](https://github.com/DiegoOrtiz27)  
- **Página personal:** [Mi Portafolio](https://diegoortiz27.github.io/MyRepository-Client-/)  
- **Email:** example@gmail.com  

---
📝 *Este README es parte de un ejercicio para aprender a documentar APIs con Swagger.*

