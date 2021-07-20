# treinamento-rest
Treinamento Rest

## Aula 7 - *Swagger*
  * Configuração inicial
  * Customização geral - nome e descrição da API
  * Customização dos *controllers* e operações

## Aulas 8, 9 e 10 - Pesquisa no banco de dados

Utilizando mapeamento *JPA* e *Repositories* do Spring.

 * Tipos de relacionamento
 * Mapeando entidades
 * Usando o *Repositories*

## Aula 11 - Java funcional

## Aula 12 - Testes unitários com Mockito

Notações @Mock, @Spy, @InjectMocks, @Captor.
Operações Assert e Verify.

## Aula 13 - Integração com API externa

Aqui foi criada uma classe *service* para consumir a API de filmes da omdb. Para esta 
aula, é necessário se cadastrar em https://omdbapi.com/apikey.aspx para receber uma 
*apiKey* necessária para o consumo da API.

 * Foi utilizado o *restTemplate.getForEntity* para enviar uma requisição http GET para 
   a API externa;
 * Foram utilizadas notações *com.fasterxml.jackson.annotation* para mapear a *response* 
   da API externa. Vide classe *ContarOmdbApiResponse*;

## Aula 14 - Integração com API externa

Refinamento da aula 13.
