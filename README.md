# Название Приложения

Магазин электроники Tech Heim.

## Требования

* Java 21
* Maven 3+
* Spring Boot 3+


## Конфигурация

Обеспечьте необходимую конфигурацию в файле `application.properties`.

```properties
# пример настроек
server.port=8082

# Data source
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/techheim
spring.datasource.username=postgres
spring.datasource.password=postgres

# Другие настройки
```

## Зависимости:

## 1. Backend

* Spring Boot Starter Security
* Spring Boot Starter Data Jpa
* Spring Boot Starter Web
* Spring Boot Starter Validation
* Spring Boot Devtools
* Project Lombok
* Thymeleaf Extras spring security6
* Spring Boot Starter Thymeleaf
* Postgre SQL
* ModelMapper



## 2. Frontend

* Bootstrap
* Jquery 
* Slick-carousel (для карусели в главной странице)
* Popper-js (чтобы работали Dropdown-menu)
* Js


##  Запуск

1. **С помощью Maven:** 
   * mvn spring-boot:run


2. **Или скомпилируйте JAR-файл и запустите его:**
   * mvn clean install
   * java -jar target/ваш-файл.jar
                                            



## Роли

| Роли      | Доступы                                          |
|-----------|--------------------------------------------------|
| ROLE_USER | Может заказать товары, управлять своими данными. |

