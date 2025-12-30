package AddTwoNumbers;

/**
 * Nodo básico para una lista enlazada simple (Singly Linked List).
 * Esta estructura es la base para problemas de secuencias dinámicas.
 */
class ListNode {
    /** * El valor numérico almacenado en el nodo.
     */
    int val;

    /** * Referencia (puntero) al siguiente nodo en la secuencia.
     * Si es null, indica que este es el último nodo (la cola).
     */
    ListNode next;

    /**
     * Constructor vacío.
     * Crea un nodo con valor 0 y sin conexión siguiente.
     * Útil para inicializar "Dummy Nodes" que sirven como anclas en algoritmos.
     */
    ListNode() {}

    /**
     * Constructor con valor.
     * @param val El número entero que almacenará este nodo.
     * El campo 'next' se inicializa automáticamente como null.
     */
    ListNode(int val) {
        this.val = val;
    }

    /**
     * Constructor completo.
     * @param val El número entero que almacenará este nodo.
     * @param next Referencia al nodo que debe seguir a este.
     * Permite conectar nodos al momento de su creación.
     */
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode actual = dummyHead;
        int acarreo = 0;

        while (l1 != null || l2 != null || acarreo != 0) {
            // Extraer valores (si la lista terminó, usamos 0)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sumaTotal = val1 + val2 + acarreo;
            acarreo = sumaTotal / 10;
            int nuevoDigito = sumaTotal % 10;

            actual.next = new ListNode(nuevoDigito);
            actual = actual.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
}