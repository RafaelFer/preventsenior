# preventsenior
 technical challenge for prevent senior


# FormDog application

## Descrição do projeto
Api capaz de realizar leitura, edição, adição e adição via arquivo de logs


## Guia de configuração e uso para desenvolvedores
<li>Iniciar a aplicação localmente</li>


mvn install

mvnw spring-boot:run

<li>Base de dadaos</li>
Estou usando o h2 que cria o banco em memória... para acessar o banco acesse o link 

http://localhost:8080/h2-console/

jdbc url: jdbc:h2:mem:prevent-senior-db
username: sa
password: 

<li>Testes unitários</li>
mvn test

<li>Como usar</li>

Receber todos os registros:
Método: Get
http://localhost:8080/log/

Receber um unico log via path param:
Método: Get
http://localhost:8080/log/2

Excluir um log:
Método: Delete
http://localhost:8080/log/2

Alterar um log:
Método Put
http://localhost:8080/log/3
```ruby
	{
    "date": "2021-06-06T23:23:01.12327",
    "ip": "192.168.0.1.",
    "request": "NOT OK",
    "userAgent": "USER_AGENTE_ALTERANDO",
    "status": "OK!"
	}
```
Criando um log novo:
Método Post
```ruby
	{
		"date":"2021-06-06T23:23:01.12327",
		"ip":"192.168.0.1.",
		"request":"HTTP",
		"userAgent":"Rafinha",
		"status":"OK!"
	}
```

Enviando um arquivo de logs em massa:
Método post
http://localhost:8080/log/upload










## Quem participou? :busts_in_silhouette:

* **Rafael Ferreira**  - [Email](mailto:rafael22fs@gmail.com)


