# 🚀 Atividade: Implementação de Conta Bancária com Clean Architecture

Este guia detalha a construção de um sistema de gerenciamento de contas bancárias seguindo os princípios da **Arquitetura Limpa (Clean Architecture)**. O foco principal é o isolamento total das regras de negócio em relação a frameworks e detalhes de infraestrutura.

---

## 🏛️ 1. Visão Geral da Arquitetura

O objetivo é que o **Core (regras de negócio)** seja o coração do sistema. Ele deve ser independente de bancos de dados, interfaces de usuário ou frameworks como o Spring Boot.

- **Independência de Framework:** O Core não conhece o Spring.
- **Testabilidade:** As regras de negócio podem ser testadas sem o banco de dados ou servidor web.
- **Independência de Banco de Dados:** A lógica de negócio não sabe se os dados são salvos em um SQL, NoSQL ou em memória.

---

## 📊 2. Requisitos do Projeto

### 2.1 Requisitos Funcionais
- **Criar Conta:** Permitir abertura de conta com nome do titular e depósito inicial opcional.
- **Realizar Depósito:** Adicionar fundos a uma conta existente.
- **Realizar Saque:** Retirar fundos de uma conta existente.
- **Consultar Saldo/Extrato:** Retornar o saldo atual e a lista de transações (histórico).

### 2.2 Regras de Negócio (Onde a mágica acontece)
1. **Validação de Saque:**
    - Proibido sacar valores negativos ou zerados.
    - O saldo não pode ficar negativo (sem limite de cheque especial).
2. **Validação de Depósito:**
    - Proibido depositar valores negativos ou zerados.
3. **Histórico Imutável:**
    - Toda transação bem-sucedida deve gerar um registro de `Transação`.
    - Atributos obrigatórios: Tipo (SAQUE/DEPÓSITO), Valor e Timestamp.
    - **Regra de Ouro:** Uma transação nunca pode ser alterada ou excluída após sua criação.

---

## 🛠️ 3. Stack Tecnológica

- **Linguagem:** Java 17+
- **Framework Base:** Spring Boot 3.x
- **Persistência:** Spring Data JPA com Banco H2 (Em memória)
- **Testes:** JUnit 5 e AssertJ
- **Build Tool:** Maven ou Gradle

---

## 📂 4. Estrutura de Pastas Sugerida

Para respeitar as barreiras arquiteturais, organize seu código assim:

```text
src/main/java/br/com/costa/conta_bancaria_clean_arc/
├── core/
│   ├── domain/           # Entidades puras (POJOs)
│   ├── usecase/         # Casos de uso (Lógica de negócio)
│   └── gateway/         # Interfaces (Portas de saída)
├── infra/
│   ├── config/          # Configurações do Spring (Beans, etc)
│   ├── controller/      # Adapters de Entrada (API REST)
│   ├── persistence/     # Adapters de Saída (JPA, Repositories)
│   └── dataprovider/    # Implementações dos gateways
```

---

## 📑 5. O Desafio: Implementação em Camadas

### Camada 1: Domínio (Core)
- **Entidades:** Crie `Conta` e `Transacao` como classes Java puras. **NÃO use** `@Entity`, `@Id`, ou qualquer anotação do Jakarta Persistence aqui.
- **Gateways (Portas):** Crie interfaces como `ContaGateway` para definir métodos de busca e persistência que os casos de uso utilizarão.

### Camada 2: Casos de Uso (Use Cases)
- Implemente classes como `RealizarSaqueUseCase`.
- **Regra Restrita:** Estas classes **NÃO podem** usar `@Service` ou `@Autowired`. A injeção de dependência deve ser feita via construtor manual.
- Eles orquestram o fluxo de dados entre as entidades e os gateways.

### Camada 3: Infraestrutura (Spring & JPA)
- **Adapters de Banco:** Crie entidades JPA (ex: `ContaEntity`) com as anotações `@Entity`.
- **Mapeadores:** Crie classes para converter `Conta` (Domínio) para `ContaEntity` (Infra) e vice-versa.
- **Controllers:** Exponha os endpoints REST. Eles recebem DTOs, invocam os Casos de Uso e retornam DTOs de resposta.

---

## ✅ 6. Critérios de Aceite

1. O projeto compila e o banco H2 inicia corretamente.
2. É possível criar uma conta e realizar operações via Postman/Insomnia.
3. **Teste de Pureza:** Se você remover a dependência do Spring Boot do `pom.xml`, as pastas dentro de `core/` devem continuar compilando (exceto talvez por imports de annotations de validação, se usadas, mas prefira não usá-las no core).
4. Existem testes unitários cobrindo as Regras de Negócio (Saque e Depósito).

---

> **Dica de Especialista:** Comece sempre pelo Domínio. Defina o que é uma Conta e como ela se comporta antes de pensar em como ela será salva no banco de dados.
