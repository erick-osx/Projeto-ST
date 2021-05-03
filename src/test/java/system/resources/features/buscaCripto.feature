  @cenario02
  Feature: Buscar criptomoeda
    @buscarCripto
    Scenario: Realizar busca de criptomoeda listada

      Given o usuario acessou a aplicacao
      * aceitou os termos e politicas
      * acessou a tela de principais criptomoedas
      When o usuario realiza a busca por "Bitcoin"
      Then o primeiro item da tabela deve exibir Bitcoin