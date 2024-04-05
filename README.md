
<h1 align="center">
    ⚠️ Em andamento ⚠️
</h1>


# 📝 Microsserviço de Pedido

Projeto backend Java que compõe os serviços de uma plataforma e-commerce voltada para a venda de produtos esportivos. Este projeto é responsável registrar e consultar dados a respeito dos dos pedidos.

## ⚙️ Principais tecnologias
- [x]  **Java 17:** Versão LTS do Java.
* [x]  **Git:** Versionamento da aplicação
- [x]  **Spring Framework:** Framework open source desenvolvido para a plataforma Java baseado nos padrões de projetos de inversão de controle e injeção de dependência. Focado em reduzir a complexidade no desenvolvimento.
* [x]  **Spring Boot 3:** Geração automática de configurações.
- [x]  **Spring Data JPA:** Para facilitar a nossa interação com o banco de dados, que a a partir de agora será através de herança de interfaces e declaração de métodos com anotações. 
* [x]  **PostgreSQL:** Para salvarmos os dados referentes à nossa aplicação, nos beneficiaremos do PostgreSQL, um sistema gerenciador de banco de dados objeto relacional.
- [x]  **Swagger OpenAPI:** Criação de uma documentação de API eficaz e fácil de entender.
* [x]  **Kafka:** É um armazenamento de dados distribuído otimizado para ingestão e processamento de dados de streaming em tempo real. Utilizaremos para processarmos os produtos dos pedidos realizados.
- [x]  **Docker:** Software de código aberto usado para implantar aplicativos dentro de containers virtuais. Utilizaremos para subirmos os containers necessários para o funcionamento do Apache Kafka.
* [x]  **Conduktor:** Para quem não conhece o Conduktor, ele é uma ferramenta que nós permite monitorar o nosso Kafka, mostrando os tópicos, partições e os consumers.
- [ ]  **Jenkins:** É um servidor de automação de código aberto. Com ele iremos automatizar a construção, teste e implantação de nosso software, facilitando a integração e a entrega contínuas.
* [ ] **AWS S3:**  É um serviço de armazenamento de objetos que oferece escalabilidade, disponibilidade de dados, segurança e performance. A ideia é usa-lo para salvar logs de erro e arquivos da nossa aplicação.
- [ ] **AWS EC2:** É uma parte central da plataforma de cloud computing da Amazon Web Services. O EC2 permite que os usuários aluguem computadores virtuais nos quais rodam suas próprias aplicações. A ideia é criar uma instância para executarmos nossa aplicação.

## 👨🏻‍🏫 Instruções de execução
Para executar a aplicação, será preciso rodar o Apache Kafka, juntamente com o Schema Registry, no arquivo docker-compose já se encontram todas as dependências necessárias para o seu funcionamento.
Na pasta ***"pedido-api/docker"*** execute o seguinte comando:
```
docker-compose up -d 
```

Você pode monitorar o Kafka usando alguma ferramenta de monitoração, neste projeto está sendo usado o [Conduktor](https://www.conduktor.io/)

