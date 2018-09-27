#lang racket
;suma hasta k---------------------------------------------------
(define (suma-hasta k)
  (if (= k 0)
    0
    (+ k (suma-hasta (- k 1)))))

;factorial-----------------------------------------------------
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

;suma numeros o cadenas----------------------------------------
(define (suma x y)
  (cond 
    ((and (number? x) (number? y)) (+ x y))
    ((and (string? x) (string? y)) (string-append x y))
    (else 'error)))
    
;fib recursivo
(define (fib n)  
  (cond ((= n 0) 0)  
        ((= n 1) 1)  
        (else (+ (fib (- n 1))  
                 (fib (- n 2))))))

      
;Miembro----------------------------------------------------
(define (miembro x Lista1) 
  (if (null? Lista1) #f 
  (if (eq? x (car Lista1)) #t 
    (miembro x (cdr Lista1)))))
    
;Eliminar apariciones--------------------------------------
(define (elimina x Lista1)
    (if (null? Lista1)
    '() (if (eq? x (car Lista1)) 
      (elimina x (cdr Lista1)) 
        (cons (car Lista1) (elimina x (cdr Lista1))))))

;-
