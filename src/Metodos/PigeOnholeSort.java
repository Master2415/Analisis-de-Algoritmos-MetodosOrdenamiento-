package Metodos;

import java.util.Arrays;

public class PigeOnholeSort {

    /**
     * Este método implementa el algoritmo Pigeonhole Sort para ordenar un arreglo.
     * @param arr Arreglo de enteros a ordenar
     * @param n Tamaño del arreglo
     */
    public static void pigeonhole_sort(int arr[], int n) {
        int min = arr[0]; // Inicializa el mínimo con el primer elemento del arreglo
        int max = arr[0]; // Inicializa el máximo con el primer elemento del arreglo
        int range, i, j, index;

        // Encontrar el mínimo y máximo del arreglo
        for (int a = 0; a < n; a++) {
            if (arr[a] > max)
                max = arr[a]; // Actualiza el máximo si se encuentra un valor mayor
            if (arr[a] < min)
                min = arr[a]; // Actualiza el mínimo si se encuentra un valor menor
        }

        range = max - min + 1; // Calcula el rango del arreglo
        int[] phole = new int[range]; // Crea un arreglo de tamaño igual al rango
        Arrays.fill(phole, 0); // Inicializa todos los elementos de phole con 0

        // Contar la frecuencia de cada elemento y almacenarla en phole
        for (i = 0; i < n; i++)
            phole[arr[i] - min]++; // Incrementa el contador en la posición correspondiente

        index = 0; // Inicializa el índice para reconstruir el arreglo ordenado

        // Reconstruir el arreglo ordenado utilizando la información en phole
        for (j = 0; j < range; j++)
            while (phole[j]-- > 0)
                arr[index++] = j + min; // Coloca los elementos en el orden correcto en el arreglo original
    }
}

