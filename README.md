# API RestFull com JPA, H2, PostgreSQL, Swagger, consome uma API pública

É utilizado os bancos H2 para testes e PostgreSQL para produção com deploy automático no Heroku pelo GitHub

https://meuapp-spring.herokuapp.com/

## Observaçao: O Heroku foi descontinuado para contas Free, etão repcisarei migrar o código para o AWS.

O projeto contém o arquivo SpringcomJPA.postman_collection.json para ser importado no Postman já apontando para o Heroku.

Para gerar o executável spring-0.0.1-SNAPSHOT-boot.jar, execute no terminal (de preferência no modo administrador) o comando: gradlew build

O arquivo será gerado no caminho ./build/libs/

Para gerar a imagem execute no terminal: docker build -t spring-app .

Para executar o docker execute no terminal: docker run -p 8080:8080 spring-app

Obs: Este projeto está utilizando a dependência spring-boot-devtools para poder fazer as atualizações diretas na imagem do Docker

Para o projeto utilizar o ambiente dockerizado em vez do local vá no IntelliJ e adicione em configuration uma nova configuração 
clicando no sinal de "+" e selecionando "application", depois no parâmetro "main class" selecione 
org.springframework.boot.devtools.RemoteSpringApplication e no parâmetro "program arguments" 
coloque http://localhost:8080 que é o caminho liberado no docker.

Opcionalmente renomeie o nome da aplicação para "Remote Application".

Mais detalhes de como utilizar spring no Docker: https://spring.io/guides/gs/spring-boot-docker/

Documentação swagger disponível https://meuapp-spring.herokuapp.com/restful/swagger-ui/index.html
