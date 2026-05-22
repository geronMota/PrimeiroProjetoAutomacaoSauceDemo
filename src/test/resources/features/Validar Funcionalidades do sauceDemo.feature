Feature: Fluxos principais do SauceDemo

  Background:
    Given que o usuario acessa a pagina de login do SauceDemo

  @login-sucesso
  Scenario: Realizar login com credenciais validas
    When o usuario realiza login com credenciais validas
    Then o sistema deve redirecionar para a pagina de produtos
    And o titulo da pagina deve conter "Products"

  @login-invalido
  Scenario: Realizar login com senha invalida
    When o usuario realiza login com credenciais invalidas
    Then o sistema deve exibir a mensagem de erro de login invalido

  @adicionar-carrinho
  Scenario: Adicionar produto ao carrinho
    Given que o usuario esta logado no sistema
    When o usuario adiciona um produto ao carrinho
    Then o contador do carrinho deve exibir "1"

  @remover-carrinho
  Scenario: Remover produto do carrinho
    Given que o usuario esta logado no sistema
    And possui um produto adicionado ao carrinho
    When o usuario remove o produto do carrinho
    Then o carrinho deve ficar vazio

  @checkout
  Scenario: Finalizar compra com sucesso
    Given que o usuario esta logado no sistema
    And possui um produto adicionado ao carrinho
    When o usuario realiza o checkout da compra
    Then o sistema deve exibir a mensagem "Thank you for your order!"