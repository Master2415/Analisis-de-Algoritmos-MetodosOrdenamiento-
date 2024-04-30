package Metodos;

public class HeapSort {

    /**
     * Este método ordena un arreglo utilizando el algoritmo Heap Sort.
     * @param arr Arreglo de enteros a ordenar
     */
    public void sort(int arr[]) {
        int N = arr.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // Extraer uno por uno un elemento del montículo
        for (int i = N - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(arr, i, 0);
        }
    }

    /**
     * Este método convierte un árbol en un montículo, donde el nodo i es un índice en arr[].
     * @param arr Arreglo de enteros
     * @param N Tamaño del montículo
     * @param i Índice del nodo raíz del subárbol
     */
    void heapify(int arr[], int N, int i) {
        int largest = i; // Inicializar el nodo más grande como la raíz
        int l = 2 * i + 1; // Izquierda = 2*i + 1
        int r = 2 * i + 2; // Derecha = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // Si el hijo derecho es más grande que el más grande hasta ahora
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // Si el más grande no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapify el subárbol afectado
            heapify(arr, N, largest);
        }
    }
}

