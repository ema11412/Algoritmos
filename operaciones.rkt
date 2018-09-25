#lang racket
;suma hasta k
(define (suma-hasta k)
  (if (= k 0)
    0
    (+ k (suma-hasta (- k 1)))))

;factorial
(define (factorial n)
    (cond ((= n 0) 1)
          (else (* n (factorial (- n 1))))))

;veces de un elemento en una lista
(define (veces lista id)
  (cond
    ((null? lista) 0)
    ((equal? (car lista) id) (+ 1 (veces (cdr lista) id)))
    (else (veces (cdr lista) id))))
;(veces '(a B a a b b) 'b)

;suma numeros o cadenas
(define (suma x y)
  (cond 
    ((and (number? x) (number? y)) (+ x y))
    ((and (string? x) (string? y)) (string-append x y))
    (else 'error)))
;
