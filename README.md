# 🚀 Test Automation Framework

### Selenium + Cucumber + Maven + Jenkins

Este projeto é um **framework de automação de testes** desenvolvido utilizando **Java**, **Selenium WebDriver**, **Cucumber (BDD)** e **Maven**, com execução automatizada através de **pipeline CI no Jenkins**.

O objetivo do projeto é validar funcionalidades da aplicação **Sauce Demo** utilizando boas práticas de automação como **Page Object Model**, organização de testes BDD e integração contínua.

---

# 🧪 Tecnologias Utilizadas

* Java 21
* Selenium WebDriver
* Cucumber (BDD)
* Maven
* Jenkins (CI/CD)
* WebDriverManager
* Log4j

---

# 📁 Estrutura do Projeto

```
src
 ├── main
 │   └── resources
 │       └── config.properties
 │
 └── test
     ├── java
     │   ├── Actions
     │   ├── Factory
     │   ├── Pages
     │   ├── Runner
     │   ├── Utils
     │   ├── hook
     │   └── stepdefinitions
     │
     └── resources
         └── features
```

---

# 📌 Descrição dos Diretórios

### 📄 Pages

Contém as **Page Objects** da aplicação.
Cada página da aplicação possui uma classe responsável por seus elementos e ações.

Exemplo:

```
LoginPage.java
HomePage.java
```

---

### 📄 stepdefinitions

Implementação dos passos definidos nos arquivos `.feature`.

Exemplo:

```
LoginPageStep.java
```

---

### 📄 Runner

Classe responsável por executar os testes Cucumber.

```
RunnerTest.java
```

---

### 📄 hook

Contém configurações de **setup e teardown** para execução dos testes.

Exemplo:

```
@Before
@After
```

---

### 📄 Utils

Classes utilitárias utilizadas em diferentes partes do projeto.

Exemplo:

```
DriverFactory
ConfigReader
```

---

### 📄 features

Contém os cenários de teste escritos em **Gherkin**.

Exemplo:

```gherkin
Feature: Validar tela de login do Sauce Demo

Scenario: Login válido
  Given eu esteja no tela de login
  When digitar login e senha
  Then a tela sera exibida
```

---

# ⚙️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```
git clone https://github.com/geronMota/jks.git
```

---

## 2️⃣ Entrar na pasta do projeto

```
cd jks
```

---

## 3️⃣ Executar os testes

```
mvn clean test
```

---

# 🔁 Pipeline de Integração Contínua

Este projeto utiliza **pipeline CI com Jenkins**.

Fluxo da pipeline:

```
GitHub
   ↓
Jenkins
   ↓
Build Maven
   ↓
Execução dos Testes
```

Etapas da pipeline:

1️⃣ Checkout do código do repositório
2️⃣ Build do projeto utilizando Maven
3️⃣ Execução dos testes automatizados

---

# 📊 Exemplo de Resultado da Execução

```
Tests run: 1
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de:

* Praticar automação de testes com Selenium
* Implementar testes utilizando Cucumber (BDD)
* Aprender integração contínua com Jenkins
* Organizar testes utilizando Page Object Model
* Criar um framework de automação estruturado

---

# 👨‍💻 Autor

**Jefferson Mota Silva**

QA Automation Engineer (em evolução 🚀)

GitHub:
https://github.com/geronMota
