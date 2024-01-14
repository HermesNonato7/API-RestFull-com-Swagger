Projeto modelo utilizando Spring boot com JPA

## Observação: O conteúdo README baixo é o do professor, não fiz o código apenas aprendi os conseitos básicos do Swagger e mantive o código do professor intacto.
## Preciso avançar no curso e aprender sobre o Docker e implantar o código em ouro serviço Cloud. Após isso, trabalharei na melhoria deste código e adicionarei meu README com a configuração correta.

Trambém preciso implementar a lógica de somar os preços das pizzas na saída, no 'price' 'request'.
Farei isso após as aulas do Docker e após aprender sobre a nuvem da AWS.
Atualizarei as dependências também.

Grato.

### Abaixo README modelo da aula do professor:

É utilizado os bancos H2 para testes e PostgreSQL para produção com deploy automático no Heroku pelo GitHub

https://meuapp-spring.herokuapp.com/

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
