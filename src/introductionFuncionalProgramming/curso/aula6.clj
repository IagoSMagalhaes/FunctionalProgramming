(ns curso.aula6)


(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor)
  15)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println (map imprime-e-15 pedido))


(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  valor)

(println (map imprime-e-15 pedido))


;Somando valores

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

; Usando reduce para somar
(println (reduce + (map preco-dos-produtos pedido)))


(defn total-do-pedido [pedido]
  (->> pedido
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




(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})


(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter gratuito? (vals pedido)))


(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))
  (println "Filtrando gratuitos")
  (println (filter gratuito? pedido))

(println (filter gratuito? pedido))



(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos")
(println (filter (fn [[_ item]] (gratuito? item)) pedido))




(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))



