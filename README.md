# Desafio Android

Como requisitos foram apresentados alguns itens
-------

Kotlin

ConstraintLayout

Android 5.0+

Faça um readme informando particularidades e justificativas para determinadas escolhas

Fonte: OpenSans-Regular.ttf

Escolhas pelo desenvolvedor
-------

Neste desafio proposto, primeiro foi necessário decidir qual ferramentas iriam ser utilizadas para a realização do trabalho.

Dentro deste contexto foi escolhido e utilizado a arquitetura MVVM para melhor organização estrutural do código, e o retrofit como framework para o consumo dos dados da API disponível.

Retrofit foi escolhido devido o serviço ser RESTful e a aplicação receber pacotes leves, dentro deste package o Retrofit apresenta um desempenho excepcional,
além de promover uma integração simples.

Desenvolvimento
-----

As pastas do projeto foram separadas por domain, exceptions, helpers, presentation, repository e viewmodel, isso para garantir uma melhor acessibilidade do código para
interpretação dos erros e outros possíveis desenvolvedores, garantido clareza. 

-----

Por conseguinte foi elaborado a tela sugerida para exibição da lista de exames, a viewmodel, repositório, objeto (Exam), controle de geração de exceptions através
do separamento dos erros apresentados.


