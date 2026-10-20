# Tarea 17 - Contador de consonantes con hilos

## 1. Clase Contador

```java
class Contador {
    int valor = 0;

    synchronized void incrementar(int cantidad) {
        valor += cantidad;
    }
}
```

| Elemento | Función |
|---|---|
| `valor` | Guarda el total. |
| `incrementar()` | Suma las apariciones encontradas. |
| `synchronized` | Evita modificaciones simultáneas del contador. |

### 2. `Hilo`

Cada objeto de esta clase cuenta una consonante concreta.

```java
class Hilo extends Thread
```

Sus atributos principales son:

- `contador`: contador compartido por todos los hilos.
- `consonante`: letra que debe buscar.
- `texto`: frase que debe recorrer.
- `resultado`: número de apariciones encontradas.

El método `run()` contiene el código que ejecuta cada hilo.

```java
for (int i = 0; i < texto.length(); i++) {
    if (Character.toLowerCase(texto.charAt(i)) ==
            Character.toLowerCase(consonante)) {
        resultado++;
    }
}
```

El bucle lee el texto. Cuando encuentra la consonante, aumenta `resultado`. 
Después, el hilo suma su resultado al contador compartido y muestra su recuento.

### 3. Método `main()`

Es el punto de inicio del programa y se encarga de coordinar todo el proceso.

| Instrucción | Función |
|---|---|
| `Scanner` | Lee los datos introducidos por teclado. |
| `char[] consonantes` | Guarda las cinco consonantes. |
| `do-while` | Repite la petición hasta introducir una consonante válida. |
| `Character.isLetter()` | Comprueba que el carácter sea una letra. |
| `indexOf()` | Permite comprobar que no sea una vocal. |
| `start()` | Inicia cada hilo. |
| `join()` | Espera a que termine cada hilo. |
| `sc.close()` | Cierra el lector de teclado. |

### Comprobación de consonantes

```java
esConsonante = Character.isLetter(letra)
        && "aeiouáéíóúü".indexOf(letra) == -1;
```

Esto comprueba dos cosas:

- Que el carácter sea una letra.
- Que no sea una de las vocales indicadas.

Si no cumple ambas condiciones, el programa vuelve a pedir la letra.

---
