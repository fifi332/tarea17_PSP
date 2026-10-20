# Tarea 17 - Contador de consonantes con hilos

## 1. Clase Contador

´´´
class Contador {
    int valor = 0;

    synchronized void incrementar(int cantidad) {
        valor += cantidad;
    }
}
´´´
