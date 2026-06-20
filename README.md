# Conta Bancaria Clean Architecture

Projeto simples de conta bancaria usando Spring Boot e uma organizacao inspirada em Clean Architecture.

O objetivo e separar as regras de negocio da infraestrutura, deixando o dominio e os casos de uso menos acoplados a detalhes como controller, banco de dados e JPA.

## Tecnologias usadas

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- Bean Validation
- H2 Database
- Lombok
- Maven

## Estrutura do projeto

```text
src/main/java/br/com/costa/conta_bancaria_clean_arc
+-- core
|   +-- domain
|   |   +-- entitys
|   |   +-- exceptions
|   +-- gateway
|   +-- usecase
+-- infrastructure
    +-- config
    +-- controller
    +-- dataprovider
    +-- persistence
        +-- entity
        +-- mapper
        +-- repository
```

## Camadas

### Core

Contem a regra principal da aplicacao.

- `domain/entitys`: entidades de dominio, como `AcountEntity`.
- `domain/exceptions`: excecoes de negocio, como `BadRequestException`, `ConflictException` e `NotFoundException`.
- `domain/exceptions/enums`: codigos e mensagens de erro.
- `gateway`: interfaces que o core usa para acessar recursos externos.
- `usecase`: casos de uso da aplicacao, como criar conta e transferir saldo.

### Infrastructure

Contem os detalhes externos da aplicacao.

- `controller`: endpoints REST.
- `dataprovider`: implementacoes dos gateways usando repository e mapper.
- `persistence/entity`: entidades JPA.
- `persistence/repository`: repositories do Spring Data JPA.
- `persistence/entity/mapper`: conversao entre DTOs, entidades de dominio e entidades JPA.
- `config`: configuracao dos beans dos casos de uso e mappers.

## Funcionalidades

- Criar uma conta bancaria.
- Validar duplicidade de `taxNumber`.
- Transferir valor entre contas usando `taxNumber`.
- Validar conta inexistente.
- Validar transferencia entre a mesma conta.
- Validar valores negativos.
- Persistir alteracoes de saldo usando JPA.

## Endpoints

Base path:

```text
/v1/acount
```

### Criar conta

```http
POST /v1/acount
Content-Type: application/json
```

Body:

```json
{
  "name": "Joao",
  "taxNumber": "12345678900",
  "password": "1234",
  "amount": 100.00
}
```

### Transferir entre contas

```http
PATCH /v1/acount/transfer/{txNumberFromAccount}/{txNumberToAccount}
Content-Type: application/json
```

Body:

```json
{
  "amount": 50.00
}
```

Exemplo:

```http
PATCH /v1/acount/transfer/12345678900/98765432100
```

## Regras de negocio

- Nao e permitido criar duas contas com o mesmo `taxNumber`.
- Nao e permitido criar ou movimentar valor negativo.
- Nao e permitido transferir para a mesma conta.
- A transferencia busca as contas pelo `taxNumber`.
- Para atualizar uma conta existente, o mapper preserva o `id` da entidade JPA ao converter para entidade de dominio.

## Como rodar

Pelo Maven Wrapper:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

Para rodar os testes:

```bash
./mvnw test
```

No Windows:

```bash
mvnw.cmd test
```

## Banco de dados

O projeto usa H2 em runtime, por meio da dependencia:

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

## Observacoes

Este projeto esta em evolucao e usa alguns nomes com a grafia atual do codigo, como `Acount` e `Transfair`, para manter consistencia com as classes existentes.
