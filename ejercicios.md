# Ejercicios: lambdas, streams y ficheros

## Ejercicio 1. Lambdas básicas

Escribe una lambda para cada caso y pruébala con la entrada indicada.

| Interfaz funcional | Qué hace la lambda | Entrada | Salida esperada |
|---|---|---|---|
| `Predicate<Integer>` | Devuelve `true` si el número es par | `4` | `true` |
| `Predicate<Integer>` | Devuelve `true` si el número es par | `7` | `false` |
| `Function<String, Integer>` | Devuelve la longitud del texto | `"lambda"` | `6` |
| `BiFunction<Integer, Integer, Integer>` | Devuelve el mayor de dos números | `3`, `9` | `9` |
| `Comparator<String>` | Ordena por longitud, de menor a mayor | `"Cádiz"`, `"Sevilla"` | un valor negativo (`"Cádiz"` va antes) |

Escribe la lambda del `Predicate` de tres formas: con el tipo del parámetro, sin el tipo y sin paréntesis.

---

## Ejercicio 2. El contexto de una lambda

Este código no compila:

```java
var ciudades = List.of("Cádiz", "Sevilla", "Cuenca");

int contador = 0;
ciudades.forEach(c -> contador++);
System.out.println(contador);
```

**a)** Haz que cuente cuántas ciudades hay, sin cambiar la lista ni usar un bucle `for`.

| Entrada | Salida esperada |
|---|---|
| `ciudades = ["Cádiz", "Sevilla", "Cuenca"]` | `3` |

**b)** Dada una variable local `int minimo`, cuenta cuántas ciudades tienen **más** letras que `minimo`. La lambda debe leer `minimo`.

| Entrada | Salida esperada |
|---|---|
| `minimo = 5`, `ciudades = ["Cádiz", "Sevilla", "Cuenca"]` | `2` |

**c)** Calcula la suma de las longitudes de todas las ciudades **sin** modificar ninguna variable desde dentro de una lambda.

| Entrada | Salida esperada |
|---|---|
| `["Cádiz", "Sevilla", "Cuenca"]` | `18` |

---

## Ejercicio 3. Filtrar y transformar

Dada una lista de ciudades, obtén otra lista con las ciudades de **más de 6 letras**, en **mayúsculas**.

| Entrada | Salida esperada |
|---|---|
| `["Cádiz", "Barcelona", "Córdoba", "Sevilla", "Castellón", "Madrid", "Cuenca"]` | `[BARCELONA, CÓRDOBA, SEVILLA, CASTELLÓN]` |
| `["Cádiz", "Madrid"]` | `[]` |

---

## Ejercicio 4. Números con streams

Dada una lista de enteros:

**a)** Obtén los **tres mayores valores distintos**, de mayor a menor.

| Entrada | Salida esperada |
|---|---|
| `[4, 8, 15, 16, 23, 42, 8, 15]` | `[42, 23, 16]` |

**b)** Calcula la suma, la media y el máximo de la lista.

| Entrada | Salida esperada |
|---|---|
| `[4, 8, 15, 16, 23, 42, 8, 15]` | `suma = 131`, `media = 16.375`, `máximo = 42` |

---

## Ejercicio 5. Agrupar elementos

Cuenta cuántas ciudades hay por cada letra inicial.

| Entrada | Salida esperada |
|---|---|
| `["Cádiz", "Córdoba", "Sevilla", "Cuenca", "Segovia", "Madrid"]` | `{C=3, S=2, M=1}` |

El orden de las claves en la salida puede variar.

---

## Ejercicio 6. Algoritmia con streams: números primos

Escribe un método `List<Integer> primosHasta(int n)` que devuelva todos los números primos menores o iguales que `n`. Hazlo solo con streams.

| Entrada | Salida esperada |
|---|---|
| `30` | `[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]` |
| `10` | `[2, 3, 5, 7]` |
| `1` | `[]` |

---

## Ejercicio 7. Rutas con `Path`

Dada esta ruta:

```java
Path ruta = Path.of("proyecto/datos/../recursos/./informe.pdf");
```

Muestra por pantalla, en este orden:

| Qué mostrar | Salida esperada |
|---|---|
| La ruta normalizada | `proyecto/recursos/informe.pdf` |
| El nombre del fichero | `informe.pdf` |
| El directorio que lo contiene | `proyecto/recursos` |
| Si la ruta es absoluta | `false` |
| La ruta del mismo fichero pero con extensión `.txt` | `proyecto/recursos/informe.txt` |

Todas las salidas, salvo la cuarta, se calculan a partir de la ruta normalizada.

---

## Ejercicio 8. Operaciones con `Files`

Escribe un programa que haga lo siguiente, en este orden, sobre un directorio `backup/2026`:

1. Crea el directorio `backup/2026` (el directorio `backup` no existe) y muestra si es un directorio.
2. Crea el fichero `backup/2026/notas.txt` con dos líneas: `uno` y `dos`.
3. Lee el fichero y muestra su contenido como una lista de líneas.
4. Copia `notas.txt` a `notas-copia.txt`. Repite la copia sin sobrescribir y captura el error mostrando un mensaje.
5. Mueve `notas-copia.txt` a `notas-final.txt` y muestra si existe cada uno de los dos nombres (primero la copia y después el final).
6. Borra `notas-final.txt` dos veces seguidas y muestra el resultado de cada borrado.

Salida esperada, ejecutando el programa en un directorio donde `backup` no existe:

```
true
[uno, dos]
La copia ya existe
false
true
true
false
```

---

## Ejercicio 9. Anagramas en un fichero

El fichero `datos/palabras.txt` tiene una palabra por línea:

```
amor
sol
perro
roma
caso
los
casa
ramo
saco
nada
mora
```

Dos palabras son anagramas si tienen las mismas letras en distinto orden (`amor` y `roma`). Lee el fichero con `Files.lines` y muestra los **grupos de anagramas formados por dos o más palabras**.

Salida esperada (el orden de los grupos y de las palabras dentro de cada grupo puede variar):

```
[amor, roma, ramo, mora]
[sol, los]
[caso, saco]
```

---

## Ejercicio 10. Procesar un CSV a mano

El fichero `datos/ventas.csv` tiene las ventas de tres tiendas durante el primer cuatrimestre de 2026. Estas son las primeras líneas:

```
id_venta,fecha,tienda,producto,categoria,unidades,precio_unitario
1,2026-01-05,Madrid,Teclado,Perifericos,3,25.50
2,2026-01-12,Sevilla,Monitor,Pantallas,2,189.90
3,2026-01-20,Madrid,Raton,Perifericos,10,12.00
```

El **importe** de una venta es `unidades × precio_unitario`.

Lee y procesa el fichero tú mismo, línea a línea, sin usar ninguna librería de CSV. Calcula y muestra escribiendo en un nuevo fichero llamado `procesamiento.csv`. Si el fichero ya existe se debe avisar al usuario si quiere sobre escribir el fichero:

| # | Dato pedido | Salida esperada |
|---|---|---|
| a | Número de ventas y unidades vendidas en total | `20 ventas`, `90 unidades` |
| b | Ingresos totales | `9039.30` |
| c | Ingresos por tienda | `Madrid = 3483.50`, `Sevilla = 2428.15`, `Valencia = 3127.65` |
| d | Producto más vendido en unidades | `Raton (37 unidades)` |
| e | Venta de mayor importe | `id 8, Madrid, Portatil, 1700.00` |
| f | Ingresos por mes | `01 = 1426.30`, `02 = 2672.45`, `03 = 2488.00`, `04 = 2452.55` |
| g | Categoría con más ingresos | `Ordenadores (5100.00)` |
| h | Ids de las ventas de más de 500 € | `[4, 6, 8, 12, 15, 19]` |
