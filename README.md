## Udemy - Quarkus Framework with REST API's
![Quarkus-Logo](/imgs/Img-0-QuarkusLogo.png)

Udemy's "Quarkus Framework with REST APIs" course project: Product Rest API.

| Technology | Version |
|------------|---------|
| Gradle     | 8.1.1   |
| Java       | 17.0.6  |
| Quarkus    | 3.3.3   |


## Steps
1. Create the project in IntelliJ:
- Language: Java
- Group: com.restapi
- Artifact: products
- JDK: 17 (or other)
- Quarkus: 3.3.3
- Extensions:
    * RestEasy Reactive Jackson
    * Hibernate ORM with Panache
    * JDBC Driver - H2
    * SmallRye OpenAPI
    * SmallRye Health

![Starter-Project](/imgs/Img-1-Starter.jpg)

2. Build the project:

![Build-Project](/imgs/Img-2-Build.jpg)

3. Run the project, without modifying it yet, and check the main url:
- http://localhost:8080/

![Run-Project](/imgs/Img-3-Run.jpg)

4. Configure the database (H2) in `application.properties`.

5. Create the `ProductEntity` class:
- inside the `entities` package;
- annotate with `@Entity`, `@Table`;
- the table name must be "product";
- attributes must be: `id`, `name`, `description`, `category`, `model`, `price`, `creationDate`, `updateDate`.
- The `id` must be annotated with `@Id` and `@GeneratedValue`.
- The `creationDate` must be annotated with `@CreationTimestamp`.
- The `updateDate` must be annotated with `@UpdateTimestamp`.
- See step 8.

![Class-ProductEntity](/imgs/Img-4-Class-ProductEntity-b.jpg)

6. Add Lombok:
- In `build.gradle` add the Lombok dependencies:
```
compileOnly 'org.projectlombok:lombok:1.18.28'
annotationProcessor 'org.projectlombok:lombok:1.18.28'
testCompileOnly 'org.projectlombok:lombok:1.18.28'
testAnnotationProcessor 'org.projectlombok:lombok:1.18.28'
```
- Install the Lombok plugin in IntelliJ.

![IntelliJ-Plugin-Lombok](/imgs/Img-5-IntelliJ-Plugin-Lombok.jpg)

- Rebuild the project.
- Annotate the `ProductEntity` class with `@Data`, `@NoArgsConstructo` and `@AllArgsConstructor`.

7. Create the `ProductDTO` class:
- inside the `dtos` package;
- attributes must be of type `String`: `name`, `description`, `category`, `model`, `price`.
- use `@Data`, `@NoArgsConstructo` and `@AllArgsConstructor` notations.

![Class-ProductDTO](/imgs/Img-6-Class-ProductDTO-b.jpg)

8. Update the `ProductEntity` class:
- annotate the class with `@Builder`;
- the class must extend `PanacheEntity`;
- remove or comment out the explicit declaration of `id`.

9. Create the `ProductMapper` interface:
- In `build.gradle` add the MapStruct dependencies:
```
implementation 'org.mapstruct:mapstruct:1.5.5.Final'
annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
```
- rebuild the project.
- inside the `mappers` package;
- use `@Mapper` annotation;
- declare the methods `ProductDTO toDTO(ProductEntity productEntity)` and `ProductEntity toEntity(ProductDTO productDTO)`;
- declare the methods `List<ProductDTO> toDTOList(List<ProductEntity> productEntities);` and `List<ProductEntity> toEntityList(List<ProductDTO> productDTOs);`
- put attribute `ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);`;

![Interface-ProductMapper](/imgs/Img-7-Interface-ProductMapper.jpg)


## References
Udemy - Quarkus Framework with REST APIs - Vinícius Pereira de Oliveira:
https://www.udemy.com/course/quarkus-rest-api/, accessed on 09/16/2023.

Project Lombok - Setup - Gradle:
https://projectlombok.org/setup/gradle , accessed on 09/16/2023.

MapStruct - Documentation - Installation:
https://mapstruct.org/documentation/installation/ , accessed on 09/16/2023.