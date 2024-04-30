package Metodos;

public class TimSort {

    // Longitud mínima para aplicar la mezcla
    static int MIN_MERGE = 32;

    /**
     * Función principal que ejecuta el algoritmo TimSort en el arreglo dado.
     * @param arr Arreglo a ordenar
     * @param n Longitud del arreglo
     */
    public static void timSort(int[] arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        // Aplica el algoritmo de inserción en bloques de tamaño minRun
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Fusiona bloques ordenados para obtener el arreglo final ordenado
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    /**
     * Calcula la longitud mínima de ejecución (minRun) para el algoritmo TimSort.
     * @param n Longitud inicial
     * @return Longitud mínima de ejecución
     */
    public static int minRunLength(int n) {
        assert n >= 0;

        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    /**
     * Implementa el algoritmo de ordenamiento por inserción en un rango específico del arreglo.
     * @param arr Arreglo a ordenar
     * @param left Índice izquierdo del rango
     * @param right Índice derecho del rango
     */
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * Fusiona dos subarreglos ordenados en un arreglo principal.
     * @param arr Arreglo principal
     * @param l Índice izquierdo del primer subarreglo
     * @param m Índice medio (fin del primer subarreglo, inicio del segundo)
     * @param r Índice derecho del segundo subarreglo
     */
    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        // Copia elementos a los subarreglos temporales
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }

        int i = 0, j = 0, k = l;

        // Fusiona los subarreglos en el arreglo principal
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de left[]
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copia los elementos restantes de right[]
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
}
