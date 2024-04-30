package Metodos;

public class CombSort {
    /**
     * Método para obtener el siguiente espacio entre elementos.
     * @param gap Espacio actual entre elementos
     * @return Siguiente espacio entre elementos
     */
    public int getNextGap(int gap) {
        // Reducir el espacio por el factor de reducción
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    /**
     * Función para ordenar un arreglo usando Comb Sort.
     * @param arr Arreglo a ordenar
     */
    public void sort(int arr[]) {
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
}

