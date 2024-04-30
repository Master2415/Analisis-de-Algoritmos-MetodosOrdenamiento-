public class TreeSort {

    // Clase que contiene el hijo izquierdo y derecho del nodo actual y el valor clave
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Raíz del BST
    Node root;

    // Constructor
    TreeSort() {
        root = null;
    }

    // Este método llama principalmente a insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Función recursiva para insertar una nueva clave en el BST
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Función para realizar un recorrido inorder del BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Método para insertar elementos del arreglo en el árbol
    void treeins(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public static void main(String[] args) {
        TreeSort tree = new TreeSort();
        int arr[] = {12345678, 80764578, 18076577, 87657878, 78330487};

        System.out.println("Arreglo original: ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Medir el tiempo de ejecución de TreeSort
        long startTime = System.nanoTime(); // Tiempo de inicio en nanosegundos

        tree.treeins(arr);
        tree.inorderRec(tree.root);

        long endTime = System.nanoTime(); // Tiempo de finalización en nanosegundos
        long duration = endTime - startTime; // Duración en nanosegundos
        System.out.println("\nTiempo de ejecución de TreeSort: " + duration + " nanosegundos");
    }
}

