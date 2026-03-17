[LICENSE__BADGE]: https://img.shields.io/github/license/PedroRodrigo/educacao-ambiental-api?style=for-the-badge
[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[POSTGRES_BADGE]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[DOCKER_BADGE]: https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white
[MAVEN_BADGE]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[POSTMAN_BADGE]: https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white
[PRS_BADGE]: https://img.shields.io/badge/PRs-welcome-green?style=for-the-badge

<h1 align="center" style="font-weight: bold;">Environmental Education API 💻</h1>

![license][LICENSE__BADGE]
![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![postgres][POSTGRES_BADGE]
![docker][DOCKER_BADGE]
![maven][MAVEN_BADGE]
![postman][POSTMAN_BADGE]
![prs][PRS_BADGE]

<details open="open">
<summary>Table of Contents</summary>

- [🚀 Getting Started](#started)
- [Prerequisites](#prerequisites)
- [Cloning](#cloning)
- [Starting](#starting)
- [📍 API Endpoints](#routes)
- [GET /users](#get-users)
- [POST /users](#post-users)
- [🏗 Project Architecture](#Project Architecture)
- [⚠️ Error Handling](#Error Handling)
- [📚 Best Practices Applied](#Best Practices Applied)
- [🤝 Collaborators](#colab)

</details>

<p align="center">
<b>REST API developed with Spring Boot for user management in an environmental education system.</b>
</p>

---

# 🚀 Getting Started

Here you will find instructions to run the project locally.

---

# Prerequisites

To run this project you need to have the following installed:

- Java 17+
- Maven
- PostgreSQL
- Git

---

# Cloning

Clone the repository:

```bash
git clone https://github.com/your-username/educacao-ambiental-api.git
```

---

<h2 id="routes">📍 API Endpoints</h2>

Aqui estão algumas das principais rotas da API e exemplos de requisição e resposta.

| route | description |
|------|-------------|
| <kbd>GET /usuarios</kbd> | Lists all registered users |
| <kbd>POST /usuarios</kbd> | Creates a new user |
| <kbd>GET /usuarios/{id}</kbd> | Retrieves a user by ID |
| <kbd>PUT /usuarios/{id}</kbd> | Updates a users data |
| <kbd>DELETE /usuarios/{id}</kbd> | Removes a user |

<h3 id="get-users">GET /usuarios</h3>

**RESPONSE**
```json
[
  {
    "id": 1,
    "nome": "Pedro Silva",
    "email": "pedro@email.com"
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "email": "maria@email.com"
  }
]
```

---

# 🐳 Database Configuration with Docker

---
## 🔗 Create Network

```bash
docker network create educacao-network

Run PostgreSQL
docker run --name educacaodb \
-p 5432:5432 \
-e POSTGRES_PASSWORD=admin \
-e POSTGRES_USER=admin \
-e POSTGRES_DB=educacao_db \
--network educacao-network \
-d postgres:15


Run PgAdmin
docker run --name pgadmin4 \
-e PGADMIN_DEFAULT_EMAIL=admin@educacao.com \
-e PGADMIN_DEFAULT_PASSWORD=admin \
-p 15432:80 \
--network educacao-network \
-d dpage/pgadmin4:8.9
```

---
### 🌐 Access PgAdmin
```bash
http://localhost:5050
```
🔐 Login

Email: admin@admin.com <br>
Password: admin123

---

▶️ Running the Application

After starting the containers, run the application:

```bash
mvn spring-boot:run
```
---

🌐 API Access

```bash
http://localhost:8080
```

---
🧠 Notes

Make sure your application.properties is configured correctly:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/educacao_db
spring.datasource.username=admin
spring.datasource.password=admin123
```

---

# 🏗 Project Architecture
---

This project follows the **Layered Architecture Pattern**, which promotes separation of concerns and better organization of the codebase.

### 📁 Project Structure
```bash
src/main/java

controller    → Handles HTTP requests and responses
service       → Contains business logic
repository    → Responsible for database access
model         → Represents the system entities
dto           → Data Transfer Objects for communication between layers
exception     → Custom exceptions
handler       → Global exception handling
```

# ⚠️ Error Handling
---

The API uses a **global exception handling strategy** to ensure consistent and clear error responses.

### 📌 Example Error Response

```json
{
  "status": 404,
  "message": "User not found",
  "timestamp": "2026-03-17T14:00:00"
}
```

# 📚 Best Practices Applied
---

This project follows several software engineering best practices:

✔️ Layered Architecture <br>
✔️ Use of DTOs (Data Transfer Objects) <br>
✔️ Containerization with Docker <br>
✔️ Custom Exceptions <br>
✔️ Separation of Responsibilities <br>
✔️ Global Exception Handling <br>
✔️ Business Rules implemented in the Service layer <br>
✔️ RESTful API design principles <br>

<h2 id="colab">🤝 Collaborators</h2>

Special thank you for the developer who built this project.

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/pedrorodrigomartins">
        <img src="https://avatars.githubusercontent.com/u/9919?s=200&v=4" width="100px;" alt="Pedro Rodrigo Profile Picture"/><br>
        <sub>
          <b>Pedro Rodrigo Martins da Silva</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

> ⚠️ Note: The credentials used in this project are for development purposes only.
> In production, use environment variables to store sensitive data.