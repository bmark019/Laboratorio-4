# Reflexión del equipo

**Instrucciones:** respondan **solo las 4 preguntas de su versión** (A o B), con **sus propias palabras** (3–5 líneas cada una)
y **citando nombres de métodos o líneas de SU código**. Las respuestas genéricas o iguales a las de otro grupo se califican en 0.
Escriban debajo de cada pregunta. (Se evalúa después; el autograde no califica este archivo.)

---


## VERSIÓN A

**A1.** `aplicarFactor` modifica el arreglo original, pero `copiaEscalada` no. Expliquen por qué, y qué es lo que
realmente se copia cuando le pasan un arreglo a un método.

> _Respuesta:_ aplicarFactor cambia el arreglo original porque en Java, cuando le pasas un arreglo a un método, no le estás mandando una copia de la lista, sino la dirección de memoria donde está guardada. Al cambiar los datos adentro del método, se cambia la lista original. En cambio, copiaEscalada usa la instrucción new para crear una lista totalmente nueva en otra parte de la memoria, cambia esa lista nueva y te la devuelve, dejando la lista original sin tocar.

**A2.** ¿Por qué Java no permite tener `double calcularCosto(double kwh)` y `int calcularCosto(double kwh)` en la misma clase?
¿Qué versión de `calcularCosto` elige Java para la llamada `calcularCosto(5, 2.5, 0.1)` y por qué?

> _Respuesta:_Java no permite tener esos dos métodos porque para diferenciar dos métodos con el mismo nombre, Java mira los parámetros de entrada (cuántos son y de qué tipo), no lo que devuelven. Como ambos reciben un solo double, el programa no sabría cuál de los dos llamar. Para la llamada calcularCosto(5, 2.5, 0.1), Java elige la versión que recibe tres datos: (int dias, double kWhPorDia, double tarifa), porque es la única que tiene exactamente tres parámetros que coinciden con los números que le enviamos (un número entero y dos decimales).


**A3.** En `Medidor`, ¿para qué sirve `this(id, 0)` en el constructor de un solo parámetro? ¿Qué ventaja tiene frente a copiar y pegar el código del otro constructor?

> _Respuesta:_Sirve para llamar directamente al otro constructor de la misma clase, pasándole el id y poniendo la lectura inicial en 0 por defecto. La ventaja de usar this(id, 0) en vez de copiar y pegar el código es que evitamos repetir las mismas instrucciones. Si en el futuro tenemos que cambiar una validación (como revisar que no nos pongan números negativos), solo tenemos que cambiarla en un solo lugar y no en varios constructores.

**A4.** ¿Por qué los atributos de `Medidor` son `private`? ¿Qué protege `registrarLectura` y qué podría pasar si `lecturaActual` fuera público?

> _Respuesta:_Son private para proteger las variables y evitar que cualquiera las modifique desde afuera sin control. El método registrarLectura protege el sistema asegurándose de que la nueva lectura sea mayor o igual a la actual (es decir, que el medidor no eche para atrás). Si lecturaActual fuera public, cualquier persona o parte del programa podría cambiarle el valor directamente y ponerle números negativos o menores, lo que arruinaría la cuenta del consumo de la luz.

---

## VERSIÓN B

**B1.** Dibujen con texto (cajas y flechas) qué pasa en la memoria —variable `datos`, el arreglo y el parámetro del método—
cuando se ejecuta `aplicarFactor(datos, 2)`. ¿Por qué el arreglo original queda modificado?

> _Respuesta:_

**B2.** `imprimirEncabezado` es `void` y `clasificarConsumo` devuelve `String`. ¿Qué error da el compilador si olvidan un `return`
en alguna rama de `clasificarConsumo`? Expliquen con un caso de su código.

> _Respuesta:_

**B3.** ¿Por qué `sumaRecursiva` necesita un caso base? ¿Qué error aparece en Java si se omite y por qué ocurre?

> _Respuesta:_

**B4.** Si `Medidor` tuviera un atributo `double[] historial` y un getter que lo devolviera directamente, ¿qué riesgo hay para el
encapsulamiento? ¿Cómo se soluciona (idea de *copia defensiva*)?

> _Respuesta:_
