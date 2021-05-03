@cenario03
Feature: Pesquisar Acao pela busca principal
  @valorAcao
  Scenario: Buscar preco atual de um ativo listado na bolsa

    Given o usuario acessou a aplicacao
    * aceitou os termos e politicas
    When o usuario realiza a pesquisa por "TAEE11"
    * valida o resultado apresentado
    * seleciona o ativo resultante
    Then a tela  da acao eh carregada exibindo o preco do ativo