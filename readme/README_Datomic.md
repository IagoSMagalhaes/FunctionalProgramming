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


# Módulo: Introdução ao Datomic: Um banco cronológico

## Aula 1 Schema e transações

#### - Introdução

O Datomic não armazena os dados da maneira tradicional que comumente aprendemos, os bancos de dados de entidade relacional que formam grandes tabelas com vários campos e várias linhas. Essas não são as únicas maneiras de fazer banco de dados. Existem diversas outras como chave-valor, documento, grafo, entre outras.

O Datomic tem uma abordagem diferente. Há dois grandes pontos que vamos ver a partir deste primeiro curso. Um delas é que tudo que se faz neste banco se acumula, ou seja, fica armazenado num histórico. Ele não vai apagar o passado, então quando apagarmos um produto do sistema, ele não apaga de verdade. Essas informações ficam escondidas, mas ninguém acessa, ninguém percebe que está ali, todo mundo vê o banco na sua última versão.

As informações ficam armazenadas para haver a possibilidade de voltar no tempo e fazer uma auditoria se quisermos, e verificar por quem, quando e por que um dado foi apagado. Tudo isso estará armazenado no banco.

Conseguimos até fazer simulações do futuro, de como estaria o banco se fizéssemos certas transações devido ao armazenamento desse log.

Também por não trabalhar com várias tabelas, temos uma grande mudança na maneira de pensar em que conseguimos aplicar ferramentas genéricas a uma única tabela.

Poderemos criar comportamentos para diversos tipos de entidades de uma vez só de uma maneira mais simples com o Datomic Cloud pois isso será natural para ele.

Passaremos por seis aulas em que vamos acessar o banco, criar dados, esquemas, incluir dados, entender como eles estarão armazenados, fazer queries cada vez mais complexas, isolar nosso código das queries e fazer diversos acessos a medida que desenvolvemos essas queries de maneira mais complexa, conforme entendemos como funciona o Datomic.

#### - Instalação e configuração

Nosso primeiro passo, então, será baixar e instalar o Datomic. Para isso, vamos em datomic.com/get-datomic.html. Baixaremos a versão Starter, que é equivalente a versão Pro, mas gratuita.

Existem duas verões gratuitas do Datomic, a Starter e a Free, que tem outros tipos de restrições. Como a Starter é equivalente a Pro, que talvez você queira adquirir quando for utilizar o Datomic em maior escala, faremos o download dessa.

#### - Schema e transacionando dados

##### * o que são schemas

##### * como transacionar schemas

##### * como transacionar dados

##### * queries simples

##### * o banco e seus snapshots


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 2 Símbolos e condicionais

#### - Simbolos locais versus globais ao namespace e a existencia de bigint e bigdecimal

#### - Let múltiplo e condicionais

##### * Definir uma variável com def ela tem o escopo global, dependendo do namespace;


##### * Algumas boas práticas com Clojure;


##### * Criar uma variável de escopo local com o let;


##### * Utilizar o class para descobrir o tipo da variável;

    (defn imprime-e-15 [valor]
     (println "valor" (class valor) valor)
     15)


##### * Trabalhar com condicionais if;


    (if nil "verdadeiro" "falso")
    (defn valor-descontado
    "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
    [valor-bruto]
    (if (> valor-bruto 100)
        (let [taxa-de-desconto (/ 10 100)
              desconto (* valor-bruto taxa-de-desconto)]
          (println "Calculando desconto de" desconto)
          (- valor-bruto desconto))
         valor-bruto))



##### * Que o nil(Nulo) é considerado false dentro do if.


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 3 Funções anônimas e lambdas

#### - Intellij, Leiningen e atalhos

#### - Predicados, when e binding em tempo de execução

#### - Funções como parametros, funções anonimas e lambdas

##### * Utilizar o plugin Cursive;


##### * O que é o namespace;


##### * Atalhos do Intellij;


##### * Utilizar o ; para comentar a linha;


##### * O que são predicates;


##### * Fazer uma função chamar a outra;


##### * Criar uma função anônima;


##### * Utilizar % para fazer um função lambda.

    (println (valor-descontado #(> % 100) 100))


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 4 Primeiros passos com coleções

#### - Vetores, get e updates

#### - Map e Filter

#### - Reduce e variações

##### * Utilizar o get para evitar exceções;

    (println (get precos 2))


##### * Definir o valor padrão de retorno do get;

    (println "valor padrão 0" (get precos 17 0))


##### * Utilizar a função inc para somar o número atual mais um;  


##### * Utilizar a função update para apenas retornar um vetor com um valor alterado;

    (defn soma-3
       [valor]
    (println "estou somando 3 em" valor)
    (+ valor 3))

    (println (update precos 0 soma-3))
    (println (update-in pedido [:mochila :quantidade] inc))


##### * Utilizar a função map para passar por todos os elementos;

    (println "map" (map valor-descontado precos))


##### * Utilizar a função filter para fazer a filtragem de elementos;

    (defn aplica-desconto?
    [valor-bruto]
    (> valor-bruto 100))

    (println "filter" (filter aplica-desconto? precos))


##### * Utilizar a função reduce para reduzir valores.

    (defn minha-soma
        [valor-1 valor-2]
        (println "somando" valor-1 valor-2)
        (+ valor-1 valor-2))

    (println (reduce minha-soma precos))

xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 5 Conhecendo mapas e threading

#### - Mapas, vals e keys

#### - Mapas aninhados update-in e threading first

    thread first, o parâmetro é lido antes da função a ser executada

##### * Utilizar um Map(HashMap);

    (def estoque {"Mochila" 10 "Camiseta" 5})

    (def pedido {:mochila  {:quantidade 2, :preco 80}
                 :camiseta {:quantidade 3, :preco 40}})


##### * Utilizar a função count;

    (println "Temos" (count estoque) "elementos")


##### * Utilizar a função keys para devolver as chaves que o map possui;

      (println "Chaves são:" (keys estoque))
      (println "Valores são:" (vals estoque))


##### * Utilizar a função assoc para associar um valor ao map;

      (def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

  
##### * O que é threading.

    (println (-> pedido
                   :mochila
                   :quantidade))


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 6 Map Reduce e Filters

#### - Destruct de sequencia, map, reduce em mapas e thread last

    (defn preco-dos-produtos [[_ valor]]
     (* (:quantidade valor) (:preco valor)))

    (println (map preco-dos-produtos pedido))
    (println (reduce + (map preco-dos-produtos pedido)))


    (defn total-do-pedido [pedido]
    (reduce + (map preco-dos-produtos pedido)))
    (println (total-do-pedido pedido))

    (defn total-do-pedido [pedido]
     (-> pedido
         (map preco-dos-produtos)
         (reduce +))
     (reduce + (map preco-dos-produtos pedido)))

    (println (total-do-pedido pedido))

    (defn preco-total-do-produto [produto]
    (* (:quantidade produto) (:preco produto)))


    (defn total-do-pedido
     [pedido]
    (->> pedido
         vals
         (map preco-total-do-produto)
         (reduce +))
    (reduce + (map preco-dos-produtos pedido)))

    (println (total-do-pedido pedido))



#### - Filtrando mapas e criando composições com comp

    (defn gratuito?
      [[_ item]]
      (<= (get item :preco 0) 0))
      (println "Filtrando gratuitos")
      (println (filter gratuito? pedido))

(println (filter gratuito? pedido))

##### * Utilizar o destruct para um dicionário;



##### * Utilizar o Thread last;

    (defn total-do-pedido [pedido]
    (->> pedido
         (map preco-dos-produtos)
         (reduce +))
    (reduce + (map preco-dos-produtos pedido)))


##### * Utilizar o map, reduce e filter em um mapa;

    (def pedido {:mochila  {:quantidade 2, :preco 80}
                 :camiseta {:quantidade 3, :preco 40}
                 :chaveiro {:quantidade 1}})


##### * Criar composição com o comp;



# CONCLUSAO

Começamos falando sobre a sintaxe da linguagem, invocando funções e aprendendo que isso ocorre de maneira um pouco diferente do que estamos acostumados em outras linguagens. Nesse ponto, aprendemos que é possível criar símbolos e atribuir valores a eles, sejam eles números escalares, strings ou mesmo funções - inclusive, é possível passar uma função como parâmetro de outra função, o que chamamos de high order functions.

Prosseguindo, discutimos como definir funções e receber parâmetros, e passamos a utilizar o IntelliJ, que facilitou bastante a construção dos nossos códigos. Além disso, ele nos trouxe o REPL, que, utilizando um projeto criado pelo Leiningen, nos permitiu executar os nossos testes.

Aprendemos também a criar símbolos locais, trabalhar com condicionais, isolar comportamentos e compor funções por meio de outras funções. Ao adentrarmos o mundo das coleções, mais especificamente vetores e mapas, conhecemos a tríade de funções mais importantes para o trabalho com esse tipo de objeto: (map), (reduce) e (filter). Também descobrimos como adicionar, remover ou alterar valores nas nossas coleções, sempre pensando em imutabilidade - ou seja, as funções não alteram os valores referenciados por um símbolo, apenas retorna um novo mapa ou vetor com as mudanças atribuídas.

Mais adiante, trabalhamos não só com mapas simples, de "uma dimensão", como também com mapas mais complexos, cujos valores são outros mapas. Ao longo desse processo, questões de boas práticas, legibilidade e como trabalhar com funções foram aparecendo e sendo discutidas.

Agora que temos uma noção melhor da linguagem, conseguiremos conectar esses aprendizados com os nossos conhecimentos de estrutura de dados, algoritmos e outros conteúdos, de modo a utilizarmos as estruturas corretas no momento adequado para trazer os benefícios desejados. Nos cursos futuros, conheceremos ainda outros benefícios de trabalhar com o Clojure.