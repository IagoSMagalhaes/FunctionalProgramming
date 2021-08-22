# curso

A Clojure library designed to ... well, that part is up to you.

# RESUMO

Módulo: Introdução a programção funcional

## Aula 1 Primeiras Funções

### Preparando Ambiente

### Funções e vetores def

### Funções e parametros

* Mostrar uma mensagem na tela com o comando println;

  (println "Bem vindo ao sistema de estoque")

* Que toda invocação de função colocamos parênteses entre ela;
 
* Definir uma variável global com (def sua variavel );

  (def total-de-produtos 15)
 
* Criar um vetor;

  (def estoque ["Camiseta","Calça"])

* Que para o Clojure a vírgula é considerada um espaço;

* Contar quantos elementos tem em um vetor com o count;

* Adicionar elementos ao vetor com o conj;
  (conj estoque "Cadeira")

* Que o Clojure é imutável;

* Criar função com defn.


## Aula 2 Símbolos e condicionais

### Simbolos locais versus globais ao namespace e a existencia de bigint e bigdecimal

### Let múltiplo e condicionais

* Definir uma variável com def ela tem o escopo global, dependendo do namespace;

* Algumas boas práticas com Clojure;

* Criar uma variável de escopo local com o let;

* Utilizar o class para descobrir o tipo da variável;

* Trabalhar com condicionais if;
* 
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

* Que o nil(Nulo) é considerado false dentro do if.


## Aula 3 Funções anônimas e lambdas

### Intellij, Leiningen e atalhos
### Predicados, when e binding em tempo de execução
### Funções como parametros, funções anonimas e lambdas

* Utilizar o plugin Cursive;

* O que é o namespace;

* Atalhos do Intellij;

* Utilizar o ; para comentar a linha;

* O que são predicates;

* Fazer uma função chamar a outra;

* Criar uma função anônima;

* Utilizar % para fazer um função lambda.

    (println (valor-descontado #(> % 100) 100))

## Aula 4 Primeiros passos com coleções

### Vetores, get e updates
### Map e Filter
### Reduce e variações

* Utilizar o get para evitar exceções;

  (println (get precos 2))

* Definir o valor padrão de retorno do get;

  (println "valor padrão 0" (get precos 17 0))

* Utilizar a função inc para somar o número atual mais um;  

* Utilizar a função update para apenas retornar um vetor com um valor alterado;

  (defn soma-3
   [valor]
   (println "estou somando 3 em" valor)
   (+ valor 3))

  (println (update precos 0 soma-3))

* Utilizar a função map para passar por todos os elementos;

  (println "map" (map valor-descontado precos))

* Utilizar a função filter para fazer a filtragem de elementos;

  (defn aplica-desconto?
   [valor-bruto]
   (> valor-bruto 100))

  (println "filter" (filter aplica-desconto? precos))

* Utilizar a função reduce para reduzir valores.

  (println (reduce minha-soma precos))


## Aula 5 Conhecendo mapas e threading

### Mapas, vals e keys
### Mapas aninhados update-in e threading first

* Utilizar um Map(HashMap);

  (def estoque {"Mochila" 10 "Camiseta" 5})

* Utilizar a função count;

  (println "Temos" (count estoque) "elementos")

* Utilizar a função keys para devolver as chaves que o map possui;

  (println "Chaves são:" (keys estoque))
  (println "Valores são:" (vals estoque))

* Utilizar a função assoc para associar um valor ao map;

  (def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
  
* O que é threading.

  (println (-> pedido
               :mochila
               :quantidade))


## Aula 6

### Destruct de sequencia, map, reduce em mapas e thread last
### Filtrando mapas e criando composições com comp
### Map reduce

O que aprendemos nesta aula:

* Utilizar o destruct para um dicionário;

* Utilizar o Thread last;

* Utilizar o map, reduce e filter em um mapa;

* Criar composição com o comp;


## Usage

FIXME

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
