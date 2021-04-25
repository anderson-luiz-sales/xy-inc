# Xy Inc API

API responsável por gerenciar pontos de interesse

### Pré-requisitos
O que você precisa instalar para rodar o projeto?

* [Gradle](https://gradle.org/)
* [JDK-8](https://www.oracle.com/technetwork/pt/java/javase/downloadsjdk8-downloads-2133151.html)
* [JRE-8](https://www.oracle.com/technetwork/pt/java/javase/downloadsjre8-downloads-2133155.html)
* [MongoDB](https://www.mongodb.com/)
* [Docker](https://docs.docker.com/docker-for-windows/install/)

### Instalação

git clone https://github.com/anderson-luiz-sales/xy-inc.git

### Como rodar a API

#### Docker Compose Build and Run (Caso ocorra problemas com Terminal Wuindows)
```
find . -type f -print0 | xargs -0 dos2unix
```

#### Docker Compose Build and Run
```
sh docker-compose-dev.sh
```

### Para validar se foi instalado corretamente:
```
http://localhost:8080/healthcheck
```
### Para acessar a documentação do Swagger:
```
http://localhost:8080/swagger-ui.html#/
```

## Tecnologias utilizadas

* [Gradle](https://gradle.org/) - De aplicativos móveis a microsserviços, de pequenas empresas a grandes empresas, a Gradle ajuda as equipes a construir, automatizar e fornecer software melhor, mais rapidamente.
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) - Starter para construção de web, incluindo aplicativos RESTful, usando o Spring MVC. Usa o Tomcat como o contêiner incorporado padrão
* [Lombok](https://projectlombok.org/) - O Projeto Lombok é uma biblioteca java que se conecta automaticamente ao seu editor e cria ferramentas, apimentando seu java. Nunca escreva outro método getter ou equals novamente, com uma anotação sua classe tem um construtor com todos os recursos, Automatize suas variáveis ​​de registro e muito mais.
* [Spring Boot Test Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test) - Starter para testar aplicativos Spring Boot com bibliotecas, incluindo JUnit, Hamcrest e Mockito.
* [Model Mapper](http://modelmapper.org/) - Os aplicativos geralmente consistem em modelos de objetos semelhantes, mas diferentes, em que os dados em dois modelos podem ser semelhantes, mas a estrutura e as preocupações dos modelos são diferentes. O mapeamento de objetos facilita a conversão de um modelo em outro, permitindo que modelos separados permaneçam segregados.
* [Swagger](https://swagger.io/) - Simplifique o desenvolvimento de API para usuários, equipes e empresas com o conjunto de ferramentas open source e profissional Swagger.

### Contrato da aplicação:
```
  {
    "id": "60858e0de781bf781eb19381",
    "name": "Lanchonete",
    "coordinateX": 27,
    "coordinateY": 12
  }

  {
    "id": "60858e2ce781bf781eb19382",
    "name": "Posto",
    "coordinateX": 31,
    "coordinateY": 18
  }

  {
    "id": "60858e46e781bf781eb19383",
    "name": "Joalheria",
    "coordinateX": 15,
    "coordinateY": 12
  }

  {
    "id": "60858e55e781bf781eb19384",
    "name": "Floricultura",
    "coordinateX": 19,
    "coordinateY": 21
  }

  {
    "id": "60858e87e781bf781eb19385",
    "name": "Pub",
    "coordinateX": 12,
    "coordinateY": 8
  }

  {
    "id": "60858ea0e781bf781eb19386",
    "name": "Supermercado",
    "coordinateX": 23,
    "coordinateY": 6
  }

  {
    "id": "60859934a4020d30238ea0db",
    "name": "Churrascaria",
    "coordinateX": null,
    "coordinateY": 2
  }
```

