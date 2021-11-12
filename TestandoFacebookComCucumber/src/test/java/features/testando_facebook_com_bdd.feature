#language: pt

Funcionalidade: Testar cadastro do facebook

  Cenário: Testando cadastro de nova conta no facebook válidos

  Esquema do Cenário:
    Dado que o usuario está na tela inicial do facebook
    Quando clica em criar nova conta
    E preenche os campos <nome> <sobrenome> <email> <senha>
    E preenche os campos restantes <dia> <mes> <ano> <genero>
    Então o titulo obtido deve ter o titulo <esperado>

    Exemplos:
      | nome          | sobrenome    | email                    |  senha         | dia    | mes   | ano    | esperado    | genero      |
      | "Leandro"     |  "Silva"     | "hored27699@gyn5.com"    | "1a2b3c4d5w"   | "17"   | "Jun" | "1998" |  "Facebook" | "masculino" |
      | "Larissa"     |  "Feitosa"   | "emilysilvast@gmail.com" | "GhostGamer00" | "11"   | "Jan" | "1995" |  "Facebook" | "feminino"  |