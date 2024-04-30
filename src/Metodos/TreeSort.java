package Metodos;

public class TreeSort {

    // Clase que contiene el hijo izquierdo y derecho del nodo actual y el valor clave
    private static class Node {
        int key;
        Node left, right;

        // Constructor para inicializar un nodo con una clave dada
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Raíz del BST
    private Node root;

    // Constructor de la clase TreeSort
    public TreeSort() {
        root = null; // Inicializa la raíz como nula al crear un nuevo objeto TreeSort
    }

    // Método público para insertar una clave en el árbol
    public void insert(int key) {
        Node newNode = new Node(key); // Crea un nuevo nodo con la clave a insertar

        if (root == null) {
            root = newNode; // Si el árbol está vacío, el nuevo nodo se convierte en la raíz
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }


    // Función recursiva para insertar una nueva clave en el BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key); // Crea un nuevo nodo si el árbol está vacío
            return root;
        }

        // Inserta la clave en el subárbol izquierdo o derecho según corresponda
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Método público para realizar un recorrido inorder del BST (ordenado)
    public void inorder() {
        inorderRec(root); // Llama a la función privada inorderRec para realizar el recorrido inorder
    }

    // Función privada para realizar un recorrido inorder del BST recursivamente
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Recorre el subárbol izquierdo
            System.out.print(root.key + " "); // Imprime el valor clave del nodo actual
            inorderRec(root.right); // Recorre el subárbol derecho
        }
    }
}

