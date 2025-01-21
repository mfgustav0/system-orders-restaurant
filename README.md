# API de gerenciamento de pedidos

Uma API avançada e escalável para gerenciamento de pedidos, construída com tecnologias e princípios modernos. Este projeto foi projetado para fornecer desempenho robusto e código sustentável.

## Funcionalidades
- **Gerenciamento de pedidos**: Crie, atualize e recupere pedidos com facilidade.
- **Arquitetura Limpa**: Seguindo os princípios da Arquitetura Limpa para melhor organização e manutenção do código.
- **Java moderno**: Desenvolvido com Java 17, utilizando os recursos de linguagem mais recentes.

---

## Tecnologias Utilizadas
- **Java 17**: Recursos Java modernos para um código mais limpo e eficiente.
- **Spring Framework**: Inclui Spring Boot para desenvolvimento rápido e Spring Data para interação com banco de dados.

---

## Arquitetura
O projeto segue os princípios da **Arquitetura Limpa**, garantindo:
- **Separação de Preocupações**: Divisão da aplicação em camadas claras (Domínio, Aplicação, Infraestrutura e Apresentação).
- **Testabilidade**: Alta cobertura de teste e componentes facilmente testáveis.
- **Flexibilidade**: Fácil adaptabilidade para novos recursos e integrações.

### Project Structure
```plaintext
src
├── main
│   ├── java
│   │   └── com.example.ordermanagement
│   │       ├── application  # Lógica de aplicação
│   │       ├── domain       # Regras básicas de negócios
│   │       ├── infrastructure # Integrações externas e banco de dados
│   │       └── presentation  # Controladores e endpoints REST
└── test
    └── java                 # Testes unitários e de integração
```

---

## Começando

### Pré-requisitos
Certifique-se de ter o seguinte instalado:
- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)

---

## API Endpoints

### Orders
- **GET /api/orders**: Recuperar uma lista de pedidos.
- **POST /api/orders**: Crie um novo pedido.
- **GET /api/orders/{id}**: Recuperar um pedido por id.
- **PUT /api/orders/{id}/status/{status}**: Atualize o status de um pedido por ID.
