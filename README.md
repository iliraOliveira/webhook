# Webhook

Este aplicativo, tem por objetivo, simular um WEBHOOK.

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
  
