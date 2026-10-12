# Backend Spring Boot para Ionic

API de e-commerce desenvolvida em Java e Spring Boot. O domínio inclui categorias, produtos, clientes, endereços, pedidos, pagamentos e itens de pedido, com repositórios e configurações de segurança e armazenamento de imagens.

## Tecnologias principais

- Java
- Spring Boot
- Spring Data JPA
- Maven
- AWS S3 (configuração de armazenamento de imagens presente no projeto)

## Relação com o frontend

Este é o backend indicado para ser consumido pelo aplicativo Ionic [Spring Ionic](https://github.com/murillomtz/spring-ionic). O frontend declara a API local na porta `8081`; ajuste as configurações de execução para que os dois projetos usem o mesmo endereço.

## Executar

Com JDK e Maven instalados:

```bash
./mvnw spring-boot:run
```

No Windows, use `mvnw.cmd spring-boot:run`. Consulte `src/main/resources` para as propriedades de banco, porta e serviços externos antes de iniciar.
