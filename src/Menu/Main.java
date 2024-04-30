package Metodos;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //int[] arr = generarArreglo();
        int[] arr = {12345678, 80764578, 18076577, 87657878, 78330487};
        int n = arr.length;

        // Ordenamiento utilizando TimSort
        executeTimSort(arr, n);

        // Ordenamiento utilizando CombSort
        executeCombSort(arr);

        // Ordenamiento utilizando TreeSort
        executeTreeSort(arr, n);

        // Ordenamiento utilizando Pigeonhole Sort
        executePigeonholeSort(arr, n);

        // Ordenamiento utilizando HeapSort
        executeHeapSort(arr);

        // Ordenamiento utilizando BitonicSort
        executeBitonicSort(arr, n);

        // Ordenamiento utilizando GnomeSort
        executeGnomeSort(arr, n);

    }

    // Método para imprimir un arreglo
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Método para ejecutar TimSort
    public static void executeTimSort(int[] arr, int n) {
        TimSort timSort = new TimSort();
        long startTime = System.nanoTime();
        timSort.timSort(arr, n);
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por TimSort es:");
        //printArray(arr, n);
        System.out.println("Tiempo de ejecución de TimSort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para ejecutar CombSort
    public static void executeCombSort(int[] arr) {
        CombSort combSort = new CombSort();
        long startTime = System.nanoTime();
        combSort.sort(arr);
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por CombSort es:");
        //printArray(arr, arr.length);
        System.out.println("Tiempo de ejecución de CombSort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para ejecutar TreeSort
    public static void executeTreeSort(int[] arr, int n) {
        TreeSort treeSort = new TreeSort();
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeSort.insert(arr[i]);
        }
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por TreeSort es:");
        //treeSort.inorder();
        System.out.println("Tiempo de ejecución de TreeSort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para ejecutar Pigeonhole Sort
    public static void executePigeonholeSort(int[] arr, int n) {
        PigeOnholeSort pigeonholeSort = new PigeOnholeSort();
        long startTime = System.nanoTime();
        pigeonholeSort.pigeonhole_sort(arr, n);
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por Pigeonhole Sort es:");
        //printArray(arr, n);
        System.out.println("Tiempo de ejecución de Pigeonhole Sort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para ejecutar HeapSort
    public static void executeHeapSort(int[] arr) {
        HeapSort heapSort = new HeapSort();
        long startTime = System.nanoTime();
        heapSort.sort(arr);
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por HeapSort es:");
        //printArray(arr, arr.length);
        System.out.println("Tiempo de ejecución de HeapSort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para ejecutar BitonicSort
    public static void executeBitonicSort(int[] arr, int n) {
        BitonicSort bitonicSort = new BitonicSort();
        long startTime = System.nanoTime();
        bitonicSort.sort(arr, n, 1);
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por BitonicSort es:");
        //printArray(arr, n);
        System.out.println("Tiempo de ejecución de BitonicSort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para ejecutar GnomeSort
    public static void executeGnomeSort(int[] arr, int n) {
        GnomeSort gnomeSort = new GnomeSort();
        long startTime = System.nanoTime();
        gnomeSort.gnomeSort(arr, n);
        long endTime = System.nanoTime();

        // Mostrar el arreglo ordenado y el tiempo de ejecución
        // System.out.println("El arreglo ordenado por GnomeSort es:");
        //printArray(arr, n);
        System.out.println("Tiempo de ejecución de GnomeSort: " + (endTime - startTime) + " nanosegundos");
    }
}





