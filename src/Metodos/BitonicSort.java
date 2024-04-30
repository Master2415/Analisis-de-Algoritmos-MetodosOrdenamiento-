package punto1;

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
    void sort(int a[], int N, int up) {
        long startTime = System.nanoTime(); // Tiempo de inicio en nanosegundos
        bitonicSort(a, 0, N, up);
        long endTime = System.nanoTime(); // Tiempo de finalización en nanosegundos
        long duration = endTime - startTime; // Duración en nanosegundos
        System.out.println("Tiempo de ejecución de punto1.BitonicSort: " + duration + " nanosegundos");
    }

    /**
     * Este método imprime el contenido de un arreglo.
     * @param arr Arreglo de enteros a imprimir
     */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Método principal
    public static void main(String args[]) {
        // El algoritmo debe recibir una potencia de 2 para que funcione adecuadamente
        int a[] = {12345678, 80764578, 18076577, 87657878};
        int up = 1;

        System.out.println("El arreglo original es:");
        printArray(a);

        BitonicSort ob = new BitonicSort();
        ob.sort(a, a.length, up);

        System.out.println("Arreglo ordenado:");
        printArray(a);
    }
}
