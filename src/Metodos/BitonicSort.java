package Metodos;

public class BitonicSort {

    /**
     * Este método intercambia dos elementos del arreglo a[] si cumplen con la dirección de ordenamiento.
     * @param a Arreglo de enteros
     * @param i Índice del primer elemento a intercambiar
     * @param j Índice del segundo elemento a intercambiar
     * @param dir Dirección de ordenamiento (1 para ASCENDENTE, 0 para DESCENDENTE)
     */
    void compAndSwap(int a[], int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            // Intercambiar elementos
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * Este método ordena de manera recursiva una secuencia bitónica.
     * @param a Arreglo de enteros
     * @param low Índice de inicio de la secuencia
     * @param cnt Número de elementos a ordenar
     * @param dir Dirección de ordenamiento (1 para ASCENDENTE, 0 para DESCENDENTE)
     */
    void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, dir);
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    /**
     * Este método produce una secuencia bitónica y la ordena.
     * @param a Arreglo de enteros
     * @param low Índice de inicio de la secuencia
     * @param cnt Número de elementos a ordenar
     * @param dir Dirección de ordenamiento (1 para ASCENDENTE, 0 para DESCENDENTE)
     */
    void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            // Ordenar en orden ascendente (dir = 1)
            bitonicSort(a, low, k, 1);

            // Ordenar en orden descendente (dir = 0)
            bitonicSort(a, low + k, k, 0);

            // Fusionar toda la secuencia en orden ascendente (dir = 1)
            bitonicMerge(a, low, cnt, dir);
        }
    }

    /**
     * Este método llama a bitonicSort para ordenar el arreglo completo en orden ASCENDENTE.
     * @param a Arreglo de enteros
     * @param N Longitud del arreglo
     * @param up Dirección de ordenamiento (1 para ASCENDENTE, 0 para DESCENDENTE)
     */
    public void sort(int a[], int N, int up) {
        bitonicSort(a, 0, N, up);
    }
}


