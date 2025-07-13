Claro! Aqui está um modelo de `README.md` para seu projeto de **Locadora de Filmes**, com Spring Boot e banco H2:

---

```markdown
# 🎬 Locadora de Filmes - Mini Projeto (Spring Boot + H2)

Este é um projeto simples desenvolvido para a disciplina de Banco de Dados. O objetivo é demonstrar as operações básicas de CRUD em uma aplicação backend feita em Java utilizando Spring Boot e banco de dados em memória H2.

---

## 📁 Estrutura do Projeto

```

locadora-filmes/
├── src/
│   └── main/
│       ├── java/
│       │   └── com.example.locadora/<br>
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

````

---

## ⚙️ Tecnologias Utilizadas

- Java 8 ou superior
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Maven

---

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8+
- Maven

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/locadora-filmes.git
   cd locadora-filmes
````

2. Compile e execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

3. Acesse o H2 Console:

   * URL: `http://localhost:8080/h2-console`
   * JDBC URL: `jdbc:h2:mem:locadoradb`
   * User: `sa`
   * Password: (deixe em branco)

4. Teste os endpoints:

   Use ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para enviar requisições HTTP.

   Exemplos:

   * `GET /filmes` → Listar todos
   * `POST /filmes` → Criar novo
   * `GET /filmes/{id}` → Buscar por ID
   * `PUT /filmes/{id}` → Atualizar
   * `DELETE /filmes/{id}` → Remover

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

    // Getters e Setters...
}
```

---

## 📌 Observações

* A aplicação usa banco de dados em memória, ou seja, os dados somem quando a aplicação é encerrada.
* O projeto segue a estrutura padrão: **Controller → Service → Repository → Entity**.

---

## 👨‍🎓 Autor

Projeto desenvolvido por **Breno Sousa** como parte da disciplina de Banco de Dados no IFCE.

---

## 📃 Licença

Uso educacional. Sem licença definida.

```

---

Se quiser, posso salvar esse conteúdo como um arquivo `.md` e te enviar também. Deseja isso?
```
