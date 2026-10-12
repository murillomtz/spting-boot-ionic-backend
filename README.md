# Spring Boot Ionic Backend de Pedidos

API de um sistema de pedidos que reúne catálogo de produtos, clientes, endereços, autenticação e registro de compras. O backend Java fornece os dados e os serviços consumidos pelo aplicativo Ionic da mesma aplicação.

**Categoria:** Backend · API REST · Sistema de pedidos.

## Tecnologias principais

- Java 8
- Spring Boot 2.3.1
- Spring Security com JWT
- Spring Data JPA
- H2 e PostgreSQL
- Amazon S3

## Recursos implementados

- Consulta e manutenção de categorias.
- Pesquisa paginada de produtos por nome e categoria.
- Cadastro de cliente, endereços e consulta por email.
- Consulta de estados e cidades para os formulários.
- Autenticação com JWT, renovação de token e recuperação de senha.
- Criação e consulta dos pedidos do cliente.
- Upload de imagem de perfil e armazenamento em Amazon S3.
- Confirmação de pedido por email, com implementação mock no ambiente de teste.

## Rotas principais

As coleções são expostas em `/categorias`, `/produtos`, `/clientes`, `/estados` e `/pedidos`. As rotas de autenticação incluem `/auth/refresh_token` e `/auth/forgot`; o login é tratado pela configuração de segurança.

DTOs representam os dados de entrada e listagem. Os serviços concentram as regras de domínio e integrações, e os repositórios persistem as entidades. O projeto inclui um serviço de carga inicial de dados para o perfil de teste.

## Frontend correspondente

A interface é [Sistema de Pedidos Ionic](https://github.com/murillomtz/spring-ionic). Configure o aplicativo para o endereço desta API, que utiliza a porta **8081** por padrão. As capturas da interface integrada estão no README do frontend.

## Executar

O manifesto original declara Java 8. A execução local das capturas foi feita com JDK 11. Para iniciar o exemplo, configure os valores exigidos em `application.properties`, incluindo `JWT_SECRET`, `JWT_EXPIRATION` e as propriedades da integração AWS.

A configuração original seleciona o perfil `prod`. Para trabalhar com os dados de demonstração e H2:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=test --spring.datasource.url=jdbc:h2:mem:ionic"
```

No Windows, use `mvnw.cmd` em lugar de `./mvnw`. A integração real de imagens exige um bucket e credenciais próprios; o envio real de email exige configuração SMTP.

## Execução para as capturas

O backend original foi iniciado com perfil `test`, H2 em memória e valores locais para a configuração, sem usar serviços AWS reais. O aplicativo Ionic realizou o login de demonstração, consultou as categorias e listou os produtos da API.

As URLs antigas de imagens não estavam disponíveis. A criação de pedidos, a recuperação de senha e o upload de fotos não foram verificados nessa coleta.


## Histórico

Repositório criado no GitHub em **2020-07-08**. Essa data identifica a criação do repositório; não comprova o início nem a conclusão do desenvolvimento.
