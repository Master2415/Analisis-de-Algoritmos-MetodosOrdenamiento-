package Radix;

public class RadixSortClassroom {

    public static class nodoEntero {
        public int valor;
        public nodoEntero siguiente;

        nodoEntero(int a) {
            valor = a;
            siguiente = null;
        }

        nodoEntero() {
            siguiente = null;
            valor = 0;
        }
    }

    public static class ColaEnlazada {
        private nodoEntero inicio;
        private nodoEntero fin;
        private int tamano;

        ColaEnlazada() {
            inicio = null;
            fin = null;
            tamano = 0;
        }

        public void encolar(int num) {
            tamano++;
            nodoEntero temp = new nodoEntero(num);
            if (inicio == null) {
                inicio = temp;
                fin = inicio;
            } else {
                fin.siguiente = temp;
                fin = temp;
            }
            temp = null;
        }

        public int decolar() {
            tamano--;
            int temp = inicio.valor;
            nodoEntero nodoTemp;
            nodoTemp = inicio;
            inicio = inicio.siguiente;
            nodoTemp = null;
            return temp;
        }

        public boolean estaVacia() {
            return (tamano == 0);
        }
    }

    public static class RadixSortClass {
        private ColaEnlazada[] Q = {
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada(),
                new ColaEnlazada()
        };

        public void sort(int[] a, int numeroDigitos) {
            int posArreglo;
            for (int i = 1; i < numeroDigitos; i++) {
                posArreglo = 0;
                for (int j = 0; j < a.length; j++) {
                    Q[obtenerRadical(a[j], i)].encolar(a[j]);
                }
                for (int j = 0; j < Q.length; j++) {
                    while (!Q[j].estaVacia()) {
                        a[posArreglo] = Q[j].decolar();
                        posArreglo++;
                    }
                }
            }
        }

        public void sort(int[] a) {
            int max = 0, maxIndex = 0;
            for (int i = 0; i < a.length; i++) {
                if (max < a[i]) {
                    max = a[i];
                    maxIndex = i;
                }
            }
            Integer maximo = Integer.valueOf(max);
            String cadena = String.valueOf(maximo);
            int numeroDigitos = cadena.length();
            sort(a, numeroDigitos);
        }

        public int obtenerRadical(int numero, int radical) {
            return (int) (numero / Math.pow(10, radical - 1)) % 10;
        }
    }
}
