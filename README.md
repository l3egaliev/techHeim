# �������� ����������

������� ����������� Tech Heim.

## ����������

* Java 21
* Maven 3+
* Spring Boot 3+

## ���������

1. ���������� �����������:

    ```bash
    git clone https://github.com/l3egaliev/techheim.git
    ```

2. ��������� � ���������� �������:

    ```bash
    cd techheim
    ```

3. �������� ������:

    ```bash
    mvn clean install
    ```

## ������������

���������� ����������� ������������ � ����� `application.properties`.

```properties
# ������ ��������
server.port=8082

# Data source
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/techheim
spring.datasource.username=postgres
spring.datasource.password=postgres

# ������ ���������
```

## �����������:

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
* Slick-carousel (��� �������� � ������� ��������)
* Popper-js (����� �������� Dropdown-menu)
* Js


##  ������

1. **� ������� Maven:** 
   * mvn spring-boot:run


2. **��� ������������� JAR-���� � ��������� ���:**
   * mvn clean install
   * java -jar target/���-����.jar

���������� ����� �������� �� ������ http://localhost:8082.