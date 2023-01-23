
## API Restful cotrole de clientes

### Funcionalidades

- [Cadastro de Cliente](#Cadastro-de-Cliente)
- [Consulta de cliente](#Consulta-de-cliente)
- [Lista de Clientes](#Lista-de-Clientes)
- [Alteração de Cliente](#Alteração-de-Cliente)
- [Deletar Cliente](#Deletar-Cliente)
- [ Pesquisar cliente por nome](#Pesquisar-cliente-por-nome)


### Tecnologias 👨‍💻:
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)



## Cadastro de Cliente

```
  POST /v1/cadastroCliente 
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | Nome do cliente |
| `contato` | `Object` | contato do cliente|
| `contato.tipo` | `String` |Tipo do contato |
| `contato.texto` | `String` | contato do cliente |

- Body:

            {
                "nome" : "{nome}",
                "contato" : {
                    "tipo" : "{tipo}",
                    "texto": "{texto}"
                }
            }

- Responses:
      
    * `201` : Cliente Cadastrado.
    * `500` : Parâmetros invalidos.
    * `400` : Json incorreto.
  

## Consulta de cliente

```
  GET /v1/cliente/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do Cliente que você quer consultar |

- Response body:

        {
          "id": 1,
          "nome": "nomeTeste",
          "dataCadastro": "2023-01-21",
          "contato": {
           "tipo": "email",
          "texto": "teste@teste.com"
          }
        }

- Responses:
      
    * `200` : Cliente encontrado.
    * `404` : Cliente não encontrado.
    * `400` : ID inválido.


## Lista de Clientes

```
  GET /v1/clientes
```
- Response body:

          [
              {
                "id" : "1",
                "nome" : "cliente 1",
                "dataCadastro" : "2023-01-22",
                "contato" : {
                    "tipo" : "telefone",
                    "texto": "111111111"
                }
              },
              {
                "id" : "2",
                "nome" : "cliente 2",
                "dataCadastro" : "2023-01-22",
                "contato" : {
                    "tipo" : "telefone",
                    "texto": "22222222"
                }
              },
              {
                "id" : "3",
                "nome" : "cliente 3",
                "dataCadastro" : "2023-01-22",
                "contato" : {
                    "tipo" : "email",
                    "texto": "cliente3@clientes.com"
                }
              },
              ...
          ]
         

- Response:
      
    * `200` : Lista consultada com sucesso.
 

## Alteração de Cliente

```
  PUT /v1/alterarCliente/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do Cliente que você quer Alterar |
| `nome` | `string` | Nome do cliente |
| `contato` | `Object` | contato do cliente|
| `contato.tipo` | `String` |Tipo do contato |
| `contato.texto` | `String` | contato do cliente |

- body:

        {
          "nome":"{nome}",
          "contato":{
             "tipo":"{tipo}",
             "texto":"{texto}"
          }
        }

- Responses:
      
    * `200` : Cliente Alterado com sucesso.
    * `404` : Cliente não encontrado.
    * `400` : ID inválido.
    * `500` : Não foi possivel alterar o cliente. Parâmetros invalidos.

     

## Deletar Cliente

```
  DELETE /v1/deletarCliente/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do Cliente que você quer Deletar |

- Responses:
      
    * `200` : Cliente Deletado.
    * `500` : Não foi possivel deletar o cliente. Cliente não encontrado.
    * `400` : ID inválido.


  ## Pesquisar cliente por nome

```
  GET /v1/clienteNome/{nome}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. O nome do Cliente que você quer Pesquisar |

- Response body:

        {
          "id": 1,
          "nome": "nomeTeste",
          "dataCadastro": "2023-01-21",
          "contato": {
           "tipo": "email",
          "texto": "teste@teste.com"
          }
        }

- Response body nenhum cliente encontrado:

        []

- Responses:
  
    * `200` : Pesquisa realizada com sucesso.
    * `400` : Nome inválido.
    * `404` : Nenhum nome passado como Parâmetro

  


  

  

