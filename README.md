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

#### - Preparando Ambiente

#### - Funções e vetores def

#### - Funções e parametros



##### * Mostrar uma mensagem na tela com o comando println;

    (println "Bem vindo ao sistema de estoque")

  Os métodos são sempre encapsulados por parenteses e os espaços funcionam como vetores.
  [0] - println -> Método que será executado
  [1....] - parametros que o método recebe
  (println "Bem vindo ao sistema de estoque" "parametro2" "parametro3")

##### * Que toda invocação de função colocamos parênteses entre ela;


##### * Definir uma variável global com (def sua variavel );

    (def total-de-produtos 15)

  Sempre o primeiro argumento define o que será executado, DEF -> Definir uma variavel

##### * Criar um vetor;

    (def estoque ["Camiseta","Calça"])


##### * Que para o Clojure a vírgula é considerada um espaço;


##### * Contar quantos elementos tem em um vetor com o count;


##### * Adicionar elementos ao vetor com o conj;

    (conj estoque "Cadeira")
    (def estoque (conj estoque "Cadeira"))

  Clojure segue o mesmo conceito de imutabilidade que o Kotlin

##### * Que o Clojure é imutável;


##### * Criar função com defn.


  defn -> Atalho para definir um método/função
  defn imprime-mensagem [] -> Precisa obrigatoriamente incluir o vetor de parametros que a função recebe


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 2 Símbolos e condicionais

#### - Simbolos locais versus globais ao namespace e a existencia de bigint e bigdecimal

#### - Let múltiplo e condicionais

##### * Definir uma variável com def ela tem o escopo global, dependendo do namespace;


##### * Algumas boas práticas com Clojure;

    Criar funções com nomeclaturas no hiperativo, ex:
    Funçõpes simples "puras" como apenas retornar um valor -> A função é pura quando ela tem sempre o msm resultado, o resultado dela é só o RETORNO dela, só retorna 90, não imprime uma mensagem (MATEMATICAMENTE PURA)
    Vantagens: Concorrencia, Paralelismo


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


 (/ 10 100) -> Significa resultado de 10/100

  Por default o ELSE retorna null (Nill)

  Tudo pode ser uma função -> Uma String, um vetor, uma condição, um objeto FUNÇÃO SÃO COISAS

  Símbolos que referenciam funções são chamados : "first class citizens"

  Funções que recebem ou retornam funções são chamadas: "higher order functions"

  Função anonima -> Evite usar funções anonimas, menos caracteres mas mais complexidade na compreenssao


##### * Que o nil(Nulo) é considerado false dentro do if.


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

## Aula 3 Funções anônimas e lambdas

#### - Intellij, Leiningen e atalhos

#### - Predicados, when e binding em tempo de execução

#### - Funções como parametros, funções anonimas e lambdas

##### * Utilizar o plugin Cursive;


##### * O que é o namespace;


##### * Atalhos do Intellij;

      SHIFT + SHIFT -> Find
      CTRL + SHIFT + J -> Expulsa proxima forma
      CTRL + SHIFT + K -> Absorve proxima forma
      CTRL + SHIFT + P -> Executa só a linha selecionada
      CTRL + SHIFT + E -> Executa arquivo
      CTRL + 1  -> Esconde Project
      CTRL + SHIFT +   ->


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

  Apesar do estoque não ser um método, como ele é um vetor, o parametro seguinte tenta acessar o indice igual a .get(0) 


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



# Módulo: Clojure: Coleções no dia a dia

## Aula 1 Recursão e recursão de cauda

#### - Implementando um map na unha com recursão


    (defn meu-mapa
    [funcao sequencia]
    (let [primeiro (first sequencia)]
    (if (not(nil? primeiro))
    (do
    (funcao primeiro)
    (meu-mapa funcao(rest sequencia))))))
    
    (meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
    (meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])

#### - Tail recursion


    (defn meu-mapa
    [funcao sequencia]
    (let [primeiro (first sequencia)]
    (if (not(nil? primeiro))
    (do
    (funcao primeiro)
    (recur funcao (rest sequencia))))))

  (meu-mapa println (range1000))


##### * Como o map funciona;


##### * Utilizar a função first para pegar o primeiro elemento;


##### * Utilizar a função rest para pegar a partir do segundo elemento;



##### * Utilizar a função next para pegar o próximo elemento;



##### * Utilizar a função seq para ver a sequência de elementos;



##### * Utilizar a função do para rodar tudo que está dentro do if;


##### * Fazer recursão;



##### * Utilizar a função recur para dizer que estamos fazendo uma recursão.




## Aula 2 Aridade e loops

#### - Nosso count e múltiplas variações;

    (dfn minha funcao
        ([parametro1] (println "p1" parametro1))
        ([paremetro1 parametro2] (println "p2" parametro1 parametro2)))


#### - Loop e sua desvantagem;


    ; for total-ate-agora 0, elementos-restantes elementos-restantes   ;; 1 next
    
    (defn conta
    [elementos]
    (loop [total-ate-agora 0
    elementos-restantes elementos]
    (if (seq elementos-restantes)
    (recur (omc total-ate-agora) (next elementos-restantes))
    total-ate-agora)))
    
    (println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
    (println (conta []))

##### * Como o reduce funciona;


##### * Implementar o reduce;


##### * Variação de parâmetros na função;


##### * Utilizar o loop;


##### * Fazer recorrência dentro do loop;



## Aula 3 Outras funções com maps

#### - Agrupando e trabalhando em esquemas de mapas mais complexos;

    (println (group-by :usuario (l.db/todos-os-pedidos)))

##### * Simular um banco em memória;

    db.clj

##### * Utilizar o require para fazer a importação de classe;

    (ns clojure.collections.aula3
    (:require [clojure.collections.db :as l.db]))


##### * Utilizar um as para abreviação;

##### * Agrupar dados;


## Aula 3 Outras funções com maps

#### - Agrupando e trabalhando em esquemas de mapas mais complexos;



## Aula 4 Ordem e ordenação

#### - Ordenação, reverse, extraindo lógica

#### - First, second, nth, get em lista, take

