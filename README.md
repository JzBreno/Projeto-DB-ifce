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
spring.datasource.url=jdbc:h2:mem:locadora
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=update
management.endpoints.web.exposure.include=*
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

## 🎟️ Funcionalidade de Aluguel de Filmes

Além das operações de cadastro de filmes, o projeto também permite realizar o aluguel de filmes. Essa funcionalidade está disponível por meio da entidade `Aluguel`, que relaciona um conjunto de filmes alugados.

### 📦 Endpoints de Aluguel

| Método | Endpoint           | Descrição                                               |
| ------ | ------------------ | ------------------------------------------------------- |
| GET    | `/alugueis`        | Lista todos os aluguéis cadastrados                     |
| POST   | `/alugueis`        | Cria um novo aluguel com **todos os filmes do sistema** |
| POST   | `/alugueis/filmes` | Cria um novo aluguel com base nos **IDs de filmes**     |
| DELETE | `/alugueis/{id}`   | Remove um aluguel pelo ID                               |

### ✅ Exemplo de POST via Postman (alugar filmes por ID)

**Endpoint**:

```
POST http://localhost:8080/alugueis/filmes
```

**Corpo da Requisição (JSON)**:

```json
{
  "filmeIds": [1, 2, 3]
}
```

> ⚠️ Os filmes referenciados pelos IDs devem já existir no banco.

---

### 🗂️ Modelo da Entidade `Aluguel`

```java
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "aluguel_filme",
        joinColumns = @JoinColumn(name = "aluguel_id"),
        inverseJoinColumns = @JoinColumn(name = "filme_id")
    )
    private List<Filme> filmes;
}
```

---

### 💡 Observações

* O aluguel armazena a relação com os filmes alugados por meio de uma tabela intermediária.
* Você pode alugar todos os filmes cadastrados com um único POST em `/alugueis`.
* Para alugar filmes específicos, envie uma lista de IDs usando o endpoint `/alugueis/filmes`.

---

## 📌 Observações

* O banco de dados utilizado é em memória, portanto, todos os dados serão perdidos ao encerrar a aplicação.
* A estrutura do projeto segue o padrão: **Controller → Service → Repository → Entity** para melhor organização do código.

---

## 👨‍🎓 Autores

Projeto JAVA desenvolvido por **Breno Sousa**, **Marcos Iury**, **Liv**, **Leticia Barreto** como parte da disciplina de Banco de Dados no Instituto Federal do Ceará (IFCE).

---

## 📃 Licença

Uso exclusivo para fins educacionais. Não há licença definida.

Testes de POST, GET, DELETE, PUT
<img width="1916" height="1029" alt="image" src="https://github.com/user-attachments/assets/2d3eb4c8-4d5c-4d6f-8158-20170848c85a" />
