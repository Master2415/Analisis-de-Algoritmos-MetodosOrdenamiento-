import java.util.Arrays;


public class GnomeSort {

    static void gnomeSort(int arr[], int n) {
        long startTime = System.nanoTime(); // Registro del tiempo de inicio

        int index = 0;
        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }

        long endTime = System.nanoTime(); // Registro del tiempo de finalización
        long totalTime = endTime - startTime; // Calculo del tiempo total en milisegundos
        System.out.println("\nTiempo de ejecución en nanosegundos: " + totalTime);
    }

    public static void main(String[] args) {
        int arr[] = {12345678, 80764578, 18076577, 87657878, 78330487};

        System.out.println("El arreglo original es:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        gnomeSort(arr, arr.length);

        System.out.print("\nArreglo ordenado después de aplicar el método de ordenamiento GnomeSort:");
        System.out.println(Arrays.toString(arr));
    }
}
