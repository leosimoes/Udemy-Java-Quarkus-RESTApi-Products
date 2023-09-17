## Udemy - Quarkus Framework com API's REST
![Quarkus-Logo](/imgs/Img-0-QuarkusLogo.png)

Projeto do curso "Quarkus Framework com API's REST" da Udemy: API Rest de Produtos.

| Tecnologia | Versão |
|------------|--------|
| Gradle     | 8.1.1  |
| Java       | 17.0.6 |
| Quarkus    | 3.3.3  |


## Passos
1. Criar o projeto no IntelliJ:
- Language: Java
- Group: com.restapi
- Artifact: produtos
- JDK: 17 (ou outra)
- Quarkus: 3.3.3
- Extensions:
    * RestEasy Reactive Jackson
    * Hibernate ORM with Panache
    * JDBC Driver - H2
    * SmallRye OpenAPI
    * SmallRye Health

![Starter-Project](/imgs/Img-1-Starter.jpg)

2. Buildar o projeto:

![Build-Project](/imgs/Img-2-Build.jpg)

3. Executar o projeto, sem modificá-lo ainda, e verificar a url principal:
- http://localhost:8080/

![Run-Project](/imgs/Img-3-Run.jpg)

4. Configure o banco de dados (H2) em `application.properties`
````
# H2 Database Configuration
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.driver=org.h2.Driver
quarkus.datasource.username=usuario
quarkus.datasource.password=senha
quarkus.datasource.jdbc.url=jdbc:h2:mem:default
quarkus.hibernate-orm.database.generation=drop-and-create
````

5. Criar a classe `ProductEntity`:
- dentro do pacote `entities`;
- anotar com `@Entity`, `@Table`;
- o nome da tabela deve ser "product";
- os atributos devem ser: `id`, `name`, `description`, `category`, `model`, `price`, `creationDate`, `updateDate`.
- O `id` deve ser anotado com `@Id` e `@GeneratedValue`.
- O `creationDate` deve ser anotado com `@CreationTimestamp`.
- O `updateDate` deve ser anotado com `@UpdateTimestamp`.
- ver passo 8.

![Class-ProductEntity](/imgs/Img-4-Class-ProductEntity-b.jpg)

6. Adicionar Lombok:
- Em `build.gradle` adicione as dependências do Lombok:
```
compileOnly 'org.projectlombok:lombok:1.18.28'
annotationProcessor 'org.projectlombok:lombok:1.18.28'
testCompileOnly 'org.projectlombok:lombok:1.18.28'
testAnnotationProcessor 'org.projectlombok:lombok:1.18.28'
```
- Instale o plugin do Lombok no IntelliJ.

![IntelliJ-Plugin-Lombok](/imgs/Img-5-IntelliJ-Plugin-Lombok.jpg)

- Rebuild o projeto.
- Anote a classe `ProductEntity` com `@Data`,`@NoArgsConstructo` e `@AllArgsConstructor`.

7. Criar a classe `ProductDTO`:
- dentro do pacote `dtos`;
- os atributos devem ser do tipo `String`: `name`, `description`, `category`, `model`, `price`.
- usar anotações `@Data`,`@NoArgsConstructo` e `@AllArgsConstructor`.

![Class-ProductDTO](/imgs/Img-6-Class-ProductDTO-b.jpg)

8. Atualize a classe `ProductEntity`:
- anote a classe com `@Builder`;
- a classe deve extender `PanacheEntity`;
- remove ou comente a declaração explícita de `id`.

9. Criar a interface `ProductMapper`:
- Em `build.gradle` adicione as dependências do MapStruct:
```
implementation 'org.mapstruct:mapstruct:1.5.5.Final'
annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
```
- rebuild o projeto.
- dentro do pacote `mappers`;
- usar anotação `@Mapper`;
- declarar os métodos `ProductDTO toDTO(ProductEntity productEntity)` e `ProductEntity toEntity(ProductDTO productDTO)`;
- declarar os métodos `List<ProductDTO> toDTOList(List<ProductEntity> productEntities);` e `List<ProductEntity> toEntityList(List<ProductDTO> productDTOs);`
- colocar atributo `ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);`;

![Interface-ProductMapper](/imgs/Img-7-Interface-ProductMapper.jpg)

10. Criar a interface `ProductRepository`:
- dentro do pacote `repositories`;
- extende `PanacheRepository<ProductEntity>`;
- ver passo 4;
- ver passo 11.

11. (Alternativa ao passo 10) Criar a classe `ProductRepository`:
- anotar com `@ApplicationScoped`;
- `public class ProductRepository implements PanacheRepository<ProductEntity> {}`;
- pode ser usado para consultas personalizadas implementando métodos;
- ver passo 4.


## Referências
Udemy - Quarkus Framework com API's REST - Vinícius Pereira de Oliveira:
https://www.udemy.com/course/quarkus-rest-api/ , acessado em 16/09/2023.

Project Lombok - Setup - Gradle:
https://projectlombok.org/setup/gradle , acessado em 16/09/2023.

MapStruct - Documentation - Installation:
https://mapstruct.org/documentation/installation/ , acessado em 16/09/2023.