[LICENSE__BADGE]: https://img.shields.io/github/license/PedroRodrigo/educacao-ambiental-api?style=for-the-badge
[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[POSTGRES_BADGE]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[MAVEN_BADGE]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
[POSTMAN_BADGE]: https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white
[PRS_BADGE]: https://img.shields.io/badge/PRs-welcome-green?style=for-the-badge

<h1 align="center" style="font-weight: bold;">Environmental Education API 💻</h1>

![license][LICENSE__BADGE]
![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![postgres][POSTGRES_BADGE]
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