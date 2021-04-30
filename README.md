# DIED - GUIA 5 López, Hernán H.
Resolución de la guía entregable Nº5 para DIED (1-2021)

## Aclaraciones

### Punto 4.a

> En los servicios estándares se cobra un monto fijo, definido por ReparaFix para ese servicio más el plus que cobre el profesional seleccionado.

Debido a lo planteado el enunciado, y que la implementación tal cual estaba dada "complicaba" en parte la implementación de la misma, se definió junto a los docentes modificar esta restricción, en base a lo siguiente

> En los servicios estándares se cobra un monto fijo, definido por ReparaFix para ese servicio más un plus pre-acordado con los profesionales del oficio correspondiente al servicio en cuestión.

Además implementé el método de manera que ese plus para el profesional pueda ser porcentual o en base a un monto fijo. 

### Punto 4.c

Para la resolución del punto 4.c:

> Además, todos los tipos de servicios pueden ser solicitados como URGENTES por lo que se le cobra un 50% más del precio.

Se modeló de manera que la definición de la urgencia para prestar un servicio (el cual puede ser contratado por múltiples clientes, y llevado a cabo por múltiples profesionales), se defina a la hora de "contratar" dicho servicio. Razón por la cual el cálculo del porcentaje extra (en caso de corresponder) se realiza en la clase "Trabajo"
