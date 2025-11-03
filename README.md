# FastWorkshop API

##  Tecnologias Utilizadas

| Tecnologia | 
|-------------|
|  **Java 21** |
|  **Spring Boot 3** |
|  **Spring Web** |
|  **Spring Data JPA** ||
|  **MySQL** |
|  **H2 Database** |
|  **Lombok** |
|  **Spring Security (desativado)** |
|  **Swagger / OpenAPI** |


##  Como Rodar o Projeto

###  Rodando com Maven:

1. Clone o repositório:
```bash
git clone https://github.com/joaogabriel87/ApiJava--FASTWorkshop.git
cd fastworkshop
```

2️. Configure o banco no `application.properties`.

3️. Rode o projeto:
```bash
mvn spring-boot:run
```

4️. O servidor iniciará em:
```
http://localhost:8080
```

---

## Endpoints Principais

| Método | Endpoint | Descrição |
|---------|-----------|-----------|
| `POST` | `/api/workshops` | Cadastrar novo workshop |
| `GET` | `/api/workshops` | Listar workshops |
| `GET` | `/api/workshops/search?nome=Java` | Buscar workshops por nome |
| `GET` | `/api/workshops/data?data=2025-11-02` | Buscar workshops por data |
| `POST` | `/api/colaboradores` | Cadastrar colaborador |
| `GET` | `/api/colaboradores` | Listar colaboradores |
| `POST` | `/api/atas` | Criar ata de presença |
| `PUT` | `/api/workshops/{id}/atas/{id}` | Adicionar colaborador à ata |
| `DELETE` | `/api/atas/{id}/colaboradores/{id}` | Remover colaborador da ata |
| `GET` | `/api/atas` | Listar atas e colaboradores presentes |

---

##  Documentação Swagger

Acesse após rodar o projeto:

 **Swagger UI:**  
http://localhost:8080/swagger-ui/index.html



##  Scripts úteis Maven

```bash
# Rodar o projeto
mvn spring-boot:run

# Compilar o código
mvn clean compile

# Rodar testes (usando H2)
mvn test

# Gerar pacote .jar
mvn clean package
```

