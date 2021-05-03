
  @cenario01
  Feature: Calcular Lucro
  @calcularLucro
    Scenario: Verificar se o calculo de lucro eh diferente de nulo

     Given o usuario acessou a aplicacao
     * aceitou os termos e politicas
     * acessou a ferramenta de calculo de lucro
     When o usuario realiza o calculo informando o par de moeda "USD/BRL", moeda da conta "BRL",tamanho da negociacao "90",preco de abertura "6.25", preco de fechamento "6.87"
     Then o resultado do calculo eh exibido

