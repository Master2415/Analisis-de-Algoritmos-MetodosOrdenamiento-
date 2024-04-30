import java.util.Arrays;

public class PigeOnholeSort {

    /**
     * Este método implementa el algoritmo Pigeonhole Sort para ordenar un arreglo.
     * @param arr Arreglo de enteros a ordenar
     * @param n Tamaño del arreglo
     */
    public static void pigeonhole_sort(int arr[], int n) {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        // Encontrar el mínimo y máximo del arreglo
        for (int a = 0; a < n; a++) {
            if (arr[a] > max)
                max = arr[a];
            if (arr[a] < min)
                min = arr[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        // Contar la frecuencia de cada elemento y almacenarla en phole
        for (i = 0; i < n; i++)
            phole[arr[i] - min]++;

        index = 0;

        // Reconstruir el arreglo ordenado utilizando la información en phole
        for (j = 0; j < range; j++)
            while (phole[j]-- > 0)
                arr[index++] = j + min;
    }

    public static void main(String[] args) {
        PigeOnholeSort sort = new PigeOnholeSort();
        int[] arr = {12345678, 80764578, 18076577, 87657878, 78330487};

        System.out.print("El arreglo original es: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

        // Medir el tiempo de ejecución de Pigeonhole Sort
        long startTime = System.nanoTime(); // Tiempo de inicio en nanosegundos

        sort.pigeonhole_sort(arr, arr.length);

        long endTime = System.nanoTime(); // Tiempo de finalización en nanosegundos
        long duration = endTime - startTime; // Duración en nanosegundos
        System.out.println("Tiempo de ejecución de Pigeonhole Sort: " + duration + " nanosegundos");

        System.out.print("El arreglo ordenado es: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
