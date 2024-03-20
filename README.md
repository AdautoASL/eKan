# API REST Java.

Api backend desenvolvida em Java com padrão de designer MVC, utilizando métodos HTTP GET, PUT, DELETE e POST. 
O objetivo foi criar um CRUD (Create, Read, Update e Delete) com as anotações do Spring gerando um arquivo JAR.

Foram usados os frameworks Spring Boot e Swagger para documentação.
Foi também usado a biblioteca Spring Security para implementar autenticação Stateless usando tokens JWT, com autorização através do controle de ROLES do usuário.



### Requisitos: 
- Java 17
- Banco de Dados H2
- IDE Spring Tool Suite S4 Version: 4.15.2.RELEASE
- Ferramenta de requisições Postman.

### Documentação:

- Na compilação da API são geradas as tabelas: USERS, BENEFICIARIO e DOCUMENTO.

- Interface de conexão com banco:
  url:            http://localhost:8080/h2-console/login.jsp
  
  Saved Settings: Generic H2 (Embedded
  
  Setting Name:   Generic H2 (Embedded
  
  Driver Class:   org.h2.Driver
  
  JDBC URL:       jdbc:h2:file:./data/exemplo  (Banco preserva os dados)
  
  Usewr Name:     sa
  
  Password:

  
  
- Criar Usuário:
 
    header: content-type: application/json
  
    method: post
  
    url:    **localhost:8080/auth/registro**
  
    body:            
  
            {
               "login": "nome usuario",
  
               "password": "senha usuario",
  
               "role": "USER" ou "ADMIN"
  
            }
  

- Login:

    header: content-type: application/json

    method: post

    url:    **localhost:8080/auth/login**

    body:

            {

              "login": "nome usuario",

              "password": "password"

            }

    Bearer Token:

                  {

                    "token": "xxxxxxxxxxxxx.xxxxxxxxxx.xxxxxxxx"

                  }

- Criar Beneficiário:

    header: content-type: application/json

    method: post

    url:    **localhost:8080/beneficiarios**

    body:

            {

              "nome": "nome usuario",

              "telefone": "telefone",

              "dataNascimento" : "data de nascimento"

            }

- Criar Documento:

    header: content-type: application/json

    method: post

    url:    **localhost:8080/beneficiarios/"id beneficiario"/documento**

    body:

            {

              "descricao": "descricao",

              "tipoDocumento": "tipo documento"

            }

- Listar Beneficiarios/Documento(s):

    header:

    content-type: application/json

    method: get

    url:    **localhost:8080/beneficiarios**


- Alterar Beneficiários:

    header:

      content-type: application/json

      method: put


  url:  **localhost:8080/beneficiarios/"id beneficiario**

      body:

            {

              "nome": "nome",

              "telefone": "telefone",

              "dataNascimento": "data de nascimento

      }


- Excluir Beneficiário/Documento(s):

  header:

    content-type: application/json

    method: delete

    url:  **localhost:8080/beneficiarios/"Id Beneficiário"**

  
