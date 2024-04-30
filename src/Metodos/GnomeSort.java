package Metodos;

public class GnomeSort {

    /**
     * Este método implementa el algoritmo Gnome Sort para ordenar un arreglo.
     * @param arr Arreglo de enteros a ordenar
     * @param n Tamaño del arreglo
     */
    public static void gnomeSort(int arr[], int n) {
        int index = 0; // Inicializa el índice de posición en el arreglo

        // Mientras el índice sea menor que el tamaño del arreglo
        while (index < n) {
            if (index == 0) // Si el índice es 0, incrementa para avanzar al siguiente elemento
                index++;
            // Si el elemento actual es mayor o igual al anterior, avanza al siguiente elemento
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                // Si el elemento actual es menor que el anterior, intercámbialos
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--; // Retrocede para revisar el elemento anterior
            }
        }
    }
}


