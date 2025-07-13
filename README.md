# 🎬 Locadora de Filmes - Mini Projeto (Spring Boot + H2)

Este projeto foi desenvolvido para a disciplina de Banco de Dados e tem como objetivo demonstrar as operações básicas de CRUD em uma aplicação backend feita em Java, utilizando Spring Boot e banco de dados em memória H2.

---

## 📁 Estrutura do Projeto

```
locadora-filmes/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/locadora/
│       │       ├── LocadoraApplication.java
│       │       ├── controller/
│       │       │   └── FilmeController.java
│       │       ├── entity/
│       │       │   └── Filme.java
│       │       ├── repository/
│       │       │   └── FilmeRepository.java
│       │       └── service/
│       │           └── FilmeService.java
│       └── resources/
│           ├── application.properties
│           └── data.sql (opcional)
└── pom.xml
```

---

## ⚙️ Tecnologias Utilizadas

* Java 8 ou superior
* Spring Boot
* Spring Data JPA
* Banco de Dados H2 (em memória)
* Maven

---

## 🚀 Como Executar

### Pré-requisitos

* Java JDK 8 ou superior
* Maven instalado

### Passos para rodar a aplicação

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/locadora-filmes.git
   cd locadora-filmes
   ```

2. Compile e inicie o projeto:

   ```bash
   mvn spring-boot:run
   ```

3. Acesse o console do banco H2 pelo navegador:

   * URL: `http://localhost:8080/h2-console`
   * JDBC URL: `jdbc:h2:mem:locadoradb`
   * Usuário: `sa`
   * Senha: (deixe em branco)

4. Teste os endpoints REST usando ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/):

   | Método | Endpoint       | Descrição                   |
   | ------ | -------------- | --------------------------- |
   | GET    | `/filmes`      | Lista todos os filmes       |
   | POST   | `/filmes`      | Cria um novo filme          |
   | GET    | `/filmes/{id}` | Busca filme pelo ID         |
   | PUT    | `/filmes/{id}` | Atualiza um filme existente |
   | DELETE | `/filmes/{id}` | Remove um filme             |

---

## 🗃️ Configuração do `application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:locadoradb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

---

## 🧱 Entidade Principal

```java
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int anoLancamento;

    // Getters e Setters
}
```

---

## 📌 Observações

* O banco de dados utilizado é em memória, portanto, todos os dados serão perdidos ao encerrar a aplicação.
* A estrutura do projeto segue o padrão: **Controller → Service → Repository → Entity** para melhor organização do código.

---

## 👨‍🎓 Autor

Projeto desenvolvido por **Breno Sousa** como parte da disciplina de Banco de Dados no Instituto Federal do Ceará (IFCE).

---

## 📃 Licença

Uso exclusivo para fins educacionais. Não há licença definida.

