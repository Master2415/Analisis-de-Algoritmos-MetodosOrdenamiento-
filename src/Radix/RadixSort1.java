package Radix;
import java.util.Arrays;
public class RadixSort1 {
        /**
         * Función para obtener el valor máximo en un arreglo.
         *
         * @param arr Arreglo de enteros.
         * @param n   Tamaño del arreglo.
         * @return El valor máximo en el arreglo.
         */
        private static int getMax(int arr[], int n) {
            int mx = arr[0];
            for (int i = 1; i < n; i++)
                if (arr[i] > mx)
                    mx = arr[i];
            return mx;
        }

        /**
         * Función para realizar el counting sort de un arreglo según la posición de los dígitos.
         *
         * @param arr Arreglo de enteros.
         * @param n   Tamaño del arreglo.
         * @param exp Valor de la posición de los dígitos (10^i).
         */
        private static void countSort(int arr[], int n, int exp) {
            int output[] = new int[n]; // Arreglo de salida
            int i;
            int count[] = new int[10];
            Arrays.fill(count, 0);

            // Contar las ocurrencias de cada dígito
            for (i = 0; i < n; i++)
                count[(arr[i] / exp) % 10]++;

            // Actualizar count[i] para que contenga la posición real de cada dígito en output[]
            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Construir el arreglo de salida
            for (i = n - 1; i >= 0; i--) {
                output[count[(arr[i] / exp) % 10] - 1] = arr[i];
                count[(arr[i] / exp) % 10]--;
            }

            // Copiar el arreglo de salida al arreglo original arr[]
            for (i = 0; i < n; i++)
                arr[i] = output[i];
        }

        /**
         * Función principal para realizar Radix Sort en un arreglo.
         *
         * @param arr Arreglo de enteros a ordenar.
         * @param n   Tamaño del arreglo.
         */
        public static void radixsort(int arr[], int n) {
            // Obtener el valor máximo para conocer el número de dígitos
            int m = getMax(arr, n);

            // Realizar counting sort para cada dígito, comenzando por el dígito menos significativo
            for (int exp = 1; m / exp > 0; exp *= 10)
                countSort(arr, n, exp);
        }

    // A utility function to print an array
    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}
