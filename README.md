# treinamento-rest
Treinamento Rest.

## Aula 1 - Orientação a objetos

## Aula 2, 3, 4, 5 - API REST

## Aula 6 - Configuração de banco de dados na aplicação

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

###Interfaces funcionais
#### Function
Recebe apenas um parâmetro e retorna um valor.

Exemplo: `(valor) -> valorRetorno`

#### BiFunction
Recebe dois parametros e retorna um valor.

Exemplo: `(valor1, valor2)->valorRetorno`

#### Suplier
Não recebe parâmetro e retorno um valor.

Exemplo: `()->valorRetorno`
   
#### Consumer
Recebe um parametro e não retorna nada.

Exemplo:
````
(valor)->{
/*executa código sem retorno*/
}
````

Possui variantes, como o BiConsumer.

#### Predicate
Recebe um parâmetro e retorna um booleano.

Exemplo: `(valor)-> // retorna um valor booleano`

#### Operator
Recebe um parâmetro e retorna um valor do mesmo tipo do parâmetro.

Exemplo:
````
(valor)->{
/* retorna um valor do mesmo tipo passado*/
}
````

 ### Optional
Recurso criado para encapsular retorno de métodos, criado 
basicamente para evitar erros de *NullPointerExcption*.

Principais métodos:
 * empty()
 * of()
 * ofNullable()
 * get()
 * ifPresent()
 * isPresent()

 ### Streams
Criado para facilitar a manipulação de coleções.

Exemplo:
````
List<String> lista = new ArrauList<>();
lista.stream() // transformo a lista em um stream
````

Principais métodos:
 * map()
 * filter()
 * reduce()
 * collect()


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
