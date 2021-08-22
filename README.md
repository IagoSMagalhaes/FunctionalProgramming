# curso

A Clojure library designed to ... well, that part is up to you.

# RESUMO

Módulo: Introdução a programção funcional

## Aula 1 Primeiras Funções

### Preparando Ambiente

### Funções e vetores def

### Funções e parametros

* Mostrar uma mensagem na tela com o comando println;
  (println "Bem vindo ao sistema de estoque")COPIAR

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


##Aula 3

###
###

##Aula 4
###
###

##Aula 5
###
###

##Aula 6
###
###

##Aula 7
###
###

##Aula 8
###
###

##Aula 9
###
###



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
