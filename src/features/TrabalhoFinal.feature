#language:pt

@acessar_varios_compoentes_html
Funcionalidade: Acessar vários componentes html

  Contexto:
    Dado que o usuário acessou o arquivo Campo de Treinamento

  @validar_campos_obrigatorios
  Esquema do Cenario: Validar que os campos obrigatórios
    Quando o usuário clicar no botão <cadastrar> com algum campo obrigatório em branco
    Então deve aparecer um JOptionPane com a mensagem que <campo> é obrigatorio
    Exemplos:
      | campo     | cadastrar   |
      | nome      | cdNome      |
      | sobrenome | cdSobrenome |
      | sexo      | cdSexo      |

  @validar_campo_nome_sobrenome_sexo
  Esquema do Cenário: Validar o campo nome, sobrenome e sexo
    Quando o usuário digitar seu <nome> no campo <campo1>, o <sobrenome> no campo <campo2> e marcar seu <sexo> no campo <radio button>
    Então o resultado no campo <campo1> de ser Marcelo, no campo <campo2> deve ser Nascimento e no campo <radio button> deve ser Masculino
    Exemplos:
      | nome    | sobrenome  | campo1    | campo2    | sexo         |
      | Marcelo | Nascimento | textfield | textfield | radio button |

  @validar_todos_campos
  Esquema do Cenário: Validar todos os campos
    Quando o usuário preencher os campos <Nome>, <Sobrenome>, <Sexo>, <ComidaFavorita>, <Escolaridade>, <PraticaEsportes>, <Sugestoes> e clicar no botão Cadastrar
    Então o resultado deve ser apresentado no campo Cadastro!
    Exemplos:
      | Nome    | Sobrenome  | Sexo      | ComidaFavorita | Escolaridade     | PraticaEsportes   | Sugestoes        |
      | Marcelo | Nascimento | Masculino | Pizza          | 2o grau completo | O que eh esporte? | Nenhuma Sugestão |