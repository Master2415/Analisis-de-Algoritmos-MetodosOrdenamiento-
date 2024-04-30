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

    /**
     * Este método imprime el contenido de un arreglo.
     * @param arr Arreglo de enteros a imprimir
     */
    static void printArray(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Código de prueba
    public static void main(String args[]) {
        int arr[] = {12345678, 80764578, 18076577, 87657878, 78330487};
        int N = arr.length;

        System.out.println("El arreglo original es: ");
        printArray(arr);

        // Medir el tiempo de ejecución de HeapSort
        long startTime = System.nanoTime(); // Tiempo de inicio en nanosegundos

        // Llamar al método de ordenamiento
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        long endTime = System.nanoTime(); // Tiempo de finalización en nanosegundos
        long duration = endTime - startTime; // Duración en nanosegundos
        System.out.println("Tiempo de ejecución de HeapSort: " + duration + " nanosegundos");

        System.out.println("El arreglo ordenado es:");
        printArray(arr);
    }
}
