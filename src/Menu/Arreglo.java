package Menu;
import java.util.Random;

public class Arreglo {

        public static void main(String[] args) {
            // Crear el arreglo con 10 mil elementos
            int[] arr = generarArreglo(1_000);

            // Mostrar los primeros 10 elementos para verificar
            for (int i = 0; i < 10; i++) {
                System.out.println(" "+arr[i]);
            }
        }

        public static int[] generarArreglo(int n) {
            int[] arr = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                // Generar un número aleatorio de 8 dígitos
                int numero = rand.nextInt(90000000) + 10000000;
                arr[i] = numero;
            }
            return arr;
        }


}
