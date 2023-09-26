<img src="./repobanner.jpg" alt="Banner do Projeto" style="height: 160px; width: 800px;">

# Simple Banking API

Este projeto consiste em uma API simplificada que permite a transferência de dinheiro entre dois tipos de usuários: comuns e lojistas. O sistema gerencia o cadastro de usuários, a validação de CPFs e endereços de e-mail únicos, além de garantir que as transferências sejam feitas somente se o remetente tiver saldo suficiente. Ele também consulta serviços autorizadores externos antes de finalizar as transferências e envia notificações aos destinatários.

## 🚀 Começando

Siga as instruções abaixo para configurar e executar este projeto em sua máquina local para fins de desenvolvimento e teste.
### 📋 Pré-requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados:

- Java SDK
- PostgreSQL (banco de dados)
- Git
- Docker (opcional, caso queira usar contêineres)
- Spring Boot (framework)
- Maven (gerenciador de dependências)

### 🔧 Instalação

1. Clone o repositório para sua máquina local usando o seguinte comando:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Navegue até o diretório do projeto:
```bash
cd seu-repositorio
```
3. Configure as variáveis de ambiente no arquivo .env com as informações necessárias, como as credenciais do banco de dados, as chaves de API externas, etc.


4. Inicie o servidor SpringBoot:

```bash
./mvnw spring-boot:run
```

O servidor estará em execução em http://localhost:8080.

## ⚙️ Executando os testes

Para executar os testes automatizados, use o seguinte comando:

```
./mvnw test
```
Isso executará todos os testes, incluindo testes unitários.

Explicar como executar os testes automatizados para este sistema.

## 🛠️ Construído com

Este projeto foi construído com as seguintes ferramentas:

- Java - Linguagem de programação
- Spring Boot - Framework web para Java
- PostgreSQL - Sistema de gerenciamento de banco de dados relacional
- Docker - Plataforma de contêineres (opcional)

## 🖇️ Colaborando

Por favor, leia o CONTRIBUTING.md para obter detalhes sobre como colaborar neste projeto.

## 📌 Versão

Nós usamos [SemVer](http://semver.org/) para controle de versão. Para as versões disponíveis, observe as [tags neste repositório](https://github.com/suas/tags/do/projeto).

## ✒️ Autores

* **Fred Pinheiro** - *Desenvolvimento Inicial* - [Fred Pinheiro](https://github.com/feuvpi)

## 📄 Licença

Este projeto está sob a Licença MIT.

---
⌨️ com ❤️ por [Fred Pinheiro](https://github.com/feuvpi) 😊