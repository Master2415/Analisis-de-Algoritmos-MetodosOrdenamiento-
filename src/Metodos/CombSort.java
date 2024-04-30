public class CombSort {

    // Método para obtener el siguiente espacio entre elementos
    int getNextGap(int gap) {
        // Reducir el espacio por el factor de reducción
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Función para ordenar arr[] usando Comb Sort
    void sort(int arr[]) {
        int n = arr.length;

        // Inicializar el espacio
        int gap = n;

        // Inicializar swapped como true para asegurar que el bucle se ejecute al menos una vez
        boolean swapped = true;

        // Seguir ejecutando mientras el espacio sea mayor que 1 o la última iteración haya realizado un intercambio
        while (gap != 1 || swapped) {
            // Encontrar el siguiente espacio
            gap = getNextGap(gap);

            // Inicializar swapped como false para comprobar si se realizó algún intercambio
            swapped = false;

            // Comparar todos los elementos con el espacio actual
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Intercambiar arr[i] y arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Establecer swapped como true
                    swapped = true;
                }
            }
        }
    }

    // Método principal
    public static void main(String args[]) {
        CombSort ob = new CombSort();
        int arr[] = {12345678, 80764578, 18076577, 87657878, 78330487};

        System.out.println("Arreglo original:");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Medir el tiempo de ejecución de CombSort
        long startTime = System.nanoTime(); // Tiempo de inicio en nanosegundos

        ob.sort(arr);

        long endTime = System.nanoTime(); // Tiempo de finalización en nanosegundos
        long duration = endTime - startTime; // Duración en nanosegundos
        System.out.println("Tiempo de ejecución de CombSort: " + duration + " nanosegundos");

        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /* Este código es proporcionado por Rajat Mishra */
}
