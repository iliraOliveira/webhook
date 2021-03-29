# Webhook

Este aplicativo, tem por objetivo, simular um WEBHOOK.

![WebHook](https://user-images.githubusercontent.com/12238427/112841699-2c14ca00-9077-11eb-9783-639c056e6519.png)


# Tecnologias utilizadas

- Maven
- Java 11
- Spring Boot
- ActiveMQ (Mensage Broker)
- Apache Camel (Roteamento)

# Executar o projeto

- Baixar o projeto
- Utilizar Eclipse ou Spring Tools Suite para subir a aplicação

# Simulação

- Cadastrar Rotas
  Faça um POST:
  http://localhost:8081/system/client/add
 
  {
   "name":"Cliente 1",
   "url":"http://localhost:8081/system/client1"
  }

- Notificar
  Faça um POST
  http://localhost:8081/people/save

  {
    "name":"Teste"
  }

- Remover
  Faça um POST:
  http://localhost:8081/system/client/remove
  
  {
    "name":"Cliente 1",
    "url":"http://localhost:8081/system/client1"
  }
  
