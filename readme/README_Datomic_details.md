# Readme

* [Sobre](#Sobre)
* [Tabela de Conteudo](#tabela-de-conteudo)
* [Instalação](#instalacao)
* [Como usar](#como-usar)
    * [Pre Requisitos](#pre-requisitos)
    * [Local files](#local-files)
    * [Remote files](#remote-files)
    * [Multiple files](#multiple-files)
    * [Combo](#combo)
* [Tests](#testes)
* [Tecnologias](#tecnologias)


# Módulo: Introdução a programação funcional

## Aula 1 Primeiras Funções

#### - Introdução

#### - Preparando Ambiente

#### - Funções e vetores def

Vamos começar o nosso curso! Para instalar o Clojure, siga as intruções da atividade de instalação. Em resumo: no Mac, basta um brew install clojure; no Linux, basta baixar o arquivo TARGZ, descompactá-lo e adicioná-lo ao PATH; e no Windows, basta utilizar o instalador específico.

Após a instalação, executaremos um interpretador do Clojure. Nosso primeiro objetivo é imprimirmos uma mensagem. Para isso, chamaremos a função println, que recebe alguns parâmetros - por exemplo, uma string com a mensagem "Bem vindo ao sistema de estoque". Em Closure, quando invocamos uma função, precisamos informar o nome dela e os seus vários parâmetros - nesse caso, println com um único parâmetro. Além disso, toda a invocação deve ser colocada em parênteses. Sendo assim, teremos:

(println "Bem vindo ao sistema de estoque")
Um pouco diferente de outros tipos de linguagem, nas quais utilizamos os parênteses depois do nome da função, englobando somente os parâmetros. Isso não parece fazer muita diferença por enquanto, mas no futuro, à medida que praticarmos, fará bastante! Assim, aprendemos que a operação que queremos executar será sempre o primeiro "argumento", usando um termo mais genérico, da sequência dentro dos parênteses.

Ao executarmos, a mensagem será impressa na tela, além de um nil, "nulo", que também é devolvido pela função println. Ou seja, além de executar a função, o interpretador do Clojure também devolverá o retorno dela.

Agora queremos imprimir um total de produtos no estoque, por exemplo 15. Para isso, começaremos definindo o símbolo total-de-produtos com esse valor, algo que é feito utilizando o def. Como o valor referenciado pode mudar, costumamos chamar esse símbolo de "variável".

(def total-de-produtos 15)
Como retorno, teremos:

 'user/total-de-produtos

Nesse caso, o user o espaço de memória em que estamos trabalhando - um "namespace", que abordaremos no futuro. Agora que definimos esse valor, se executarmos (println total-de-produtos), teremos como retorno:

15

nil

Como a função println pode receber mais de um parâmetro, podemos chamar (println "Total" total-de-produtos) para imprimirmos a palavra "total" e o valor que está sendo referenciado pelo símbolo total-de-produtos. Como retorno, teremos:

Total 15

nil

Repare que o próprio println adiciona um espaço entre os parâmetros. Agora queremos redefinir o valor de total-de-produtos para 13. Para isso, faremos (def total-de-produtos 13). Em seguida, imprimiremos novamente o valor com (println "Total" total-de-produtos).

Total 13

nil

Parece que, da maneira que definimos esses símbolos, estamos trabalhando com "variáveis globais" - que, em muitas linguagens, é uma má prática. Porém, para explorarmos o Clojure, continuaremos a trabalhar dessa forma por enquanto. Já aprendemos a chamar uma função e a definir um símbolo. Agora queremos, utilizando outra função, somar três produtos ao nosso total original, que é 13, no seguinte modelo:

13 + 3
Porém, como aprendemos anteriormente, a operação/função a ser executada é sempre o primeiro "argumento" a fiturar dentro do parênteses. Sendo assim, deveríamos passar o + no início:

(+ 13 3)
Ou seja, aquilo que vamos executar é sempre o primeiro argumento dentro de uma lista de argumentos contida entre parênteses, e o restante são os parâmetros da função a ser executada - lembrando que estamos utilizando termos genéricos. Se executarmos o código acima, teremos como retorno:

16

Para quem está acostumando com parsing de matemática, essa é a notação "prefix", que primeiro lista a operação a ser feita e depois os parâmetros dela. Pensando nisso, se fizermos (13 + 3), o Clojure tratará 13 como uma função, o que ele não é. Se executarmos dessa forma, teremos:

Execution error (ClassCastException) at user/eval7 (REPL:1). java.base/java.lang.Long cannot be cast to clojure.lang.IFn

Isso significa que um Long não pode ser transformado em uma IFn, que é uma interface de função. Repare também que o Clojure está, em tempo de execução transformando o nosso código, que é uma string, em tipos do próprio Clojure, executando o código em seguida. Ao tentar transformar o 13, que é um Long, em uma função, recebemos um erro.

Se executarmos (- 13 3), a operação será feita corretamente, nos retornando um 10. Note que os operadores (+ e -, por exemplo) também costumam ser funções. Além disso, é possível passar vários valores ao mesmo tempo utilizando um único operador - por exemplo, (+ 13 3 3), que nos retornará 19.

Se quisermos somar o valor 3 ao total-de-produtos, faremos (+ total-de-produtos 3), recebendo como retorno 16 - afinal, definimos total-de-produtos como 13. Mas e se quisermos definir o símbolo total-de-produtos com esse resultado? Para isso, usaremos (def total-de-produtos) passando, como segundo parâmetro, (+ total-de-produtos 3), que é a soma do valor atual de total-de-produtos com o valor 3.

(def total-de-produtos (+ total-de-produtos 3))
Feito isso, o valor da nossa "variável" será redefinido. Se executarmos (println total-de-produtos) para recuperá-lo, teremos como retorno 16. Assim, aprendemos que é possível utilizar o resultado da invocação de uma função como parâmetro para outra função (ou outra coisa que estivermos executando). Com isso, conseguiremos criar programas da maneira que estamos acostumados.

Mas já aprendemos Clojure? Certamente não! Repare, por exemplo, que estamos trabalhando de maneira semelhante a uma variável, alterando seu valor constantemente, e o temos grandes ganhos com o Clojure à medida em que percebemos que as coisas são mais difíceis de mudar.

Para pensarmos nessa questão, vamos trabalhar com um conjunto de elementos bem específico, que é um vetor. Definiremos então o nosso estoque como um vetor contendo uma Mochila e uma Camiseta.

(def estoque ["Mochila", "Camiseta"])
Note que utilizamos os colchetes, símbolos que definem um vetor, nesse caso de apenas dois elementos. Podemos imprimir esse vetor com (println estoque), nos retornando [Mochila Camiseta], sem as aspas da nossa string e sem a vírgula. Isso porque, no Clojure, a vírgula é considerada um espaço, e a separação de elementos em um vetor é feita da mesma forma que em uma lista de argumentos. Ou seja, poderíamos executar (def estoque ["Mochila" "Camiseta"]) e obteríamos o mesmo resultado. Porém, ainda que opcional, é uma boa prática utilizarmos a vírgula quando escrevemos o código na mesma linha, afinal isso melhora a legibilidade.

Podemos fazer várias coisas com um vetor, e começaremos com algo simples. Primeiro, é possível imprimir o estoque diretamente, da mesma que um valor numérico:

estoque`
["Mochila" "Camiseta"]

Repare que, diferente do println, o estoque foi passado para o interpretador do Clojure, que mostrou o nosso vetor na tela. Já se executarmos (estoque), receberemos um erro, afinal estoque não é uma função, mas sim um vetor.

Ainda assim, o estoque pode ser utilizado como uma função. Veja o exemplo:

(estoque 0)
Executando esse código, nosso retorno será "Mochila". Ou seja, estamos chamando o primeiro elemento do vetor estoque. Se utilizarmos (estoque 1), conseguiremos o segundo elemento do vetor, que é "Camiseta"; já se utilizarmos (estoque 2), receberemos uma IndexOutOfBoundsException, uma exceção informando que o valor pedido está além das informações contidas no vetor.

Isso significa que o estoque pode se comportar como uma função, e é até mesmo uma IFn, uma interface de função do Clojure. Em realidade, quase tudo, com exceção de valores numéricos, pode funcionar como uma função, tendo o comportamento esperado daquele tipo - se temos um vetor, é esperado que, ao passarmos um índice, recebamos justamente o valor desse índice, e é justamente isso que acontece.

Se quisermos contar a quantidade de elementos em um vetor, podemos utilizar a função count, passando como parâmetro o que queremos contar - nesse caso, o estoque.

(count estoque)
Como retorno, teremos:

2

Ou seja, chamamos a função count passando como parâmetro o nosso estoque, que tem 2 valores. E se quisermos adicionar um novo valor a esse vetor? Para isso, podemos utilizar a função conj. Nesse caso, adicionaremos o valor "Cadeira".

(conj estoque "Cadeira")
Como retorno, teremos:

["Mochila" "Camiseta" "Cadeira"]

Ou seja, o resultado da função conj é um vetor contendo "Mochila", "Camiseta" e "Cadeira". Porém, se imprimirmos o nosso estoque com (println estoque), teremos:

Mochila Camiseta

Isso significa que o conj não altera o conteúdo do vetor original, e voltamos ao ponto comentado sobre a imutabilidade no Clojure. Quando temos um número, um vetor ou outro tipo de objeto, ele não muda de valor. É possível redefinir um símbolo, que passará a representar outro valor, mas, por exemplo, 15 sempre será 15. Isso é meio óbvio quando estamos falando de um valor numérico, mas não costumamos trabalhar dessa forma em outras linguagem, onde, quando adicionamos um elemento a um vetor, ele passa a representar também esse novo elemento.

Sendo assim, não importa quantas vezes chamarmos a função conj e adicionarmos novos itens ao vetor estoque, ele sempre manterá somente os dois elementos originais, afinal não informarmos que a referência estoque deverá apontar a outro valor. Se quiséssemos redefini-la, poderíamos fazer (def estoque(conj estoque "Cadeira"). Dessa forma, usaríamos o novo vetor com três valores retornado por conj como referência para o símbolo estoque. Se fizermos (println estoque), os três elementos serão retornados.

Quando estamos trabalhando com valores imutáveis, podemos passá-los para qualquer pessoa sem medo que a função invocada vá alterá-lo de alguma forma, nos permitindo um controle maior sobre o nosso código. Essa é uma dentre as muitas vantagens da imutabilidade.

Já que o Clojure sabe que quase tudo será trabalhado com a imutabilidade em mente, as coleções, como o vetor, são implementadas com isso em mente. Sendo assim, a cópia de um vetor para um novo vetor com os mesmos valores e um a mais não irá passar por todos os elementos, sendo feita de maneira otimizada para que o custo seja baixo.

A partir de agora nos aprofundaremos mais nessa linguagem e entenderemos as consequências dos conceitos apresentados.

#### - Funções e parametros


##### * Mostrar uma mensagem na tela com o comando println;

    (println "Bem vindo ao sistema de estoque")


##### * Que toda invocação de função colocamos parênteses entre ela;


##### * Definir uma variável global com (def sua variavel );

    (def total-de-produtos 15)


##### * Criar um vetor;

    (def estoque ["Camiseta","Calça"])


##### * Que para o Clojure a vírgula é considerada um espaço;


##### * Contar quantos elementos tem em um vetor com o count;


##### * Adicionar elementos ao vetor com o conj;

    (conj estoque "Cadeira")


##### * Que o Clojure é imutável;


##### * Criar função com defn.


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
