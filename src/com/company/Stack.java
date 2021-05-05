package com.company;

public class Stack {

    // Puntero que indica el inicio de la pila o tambien conocida como el tope de la pila.
    private Node start;
    // Variable para registrar el tamaño de la pila.
    private int length;
    /**
     * Constructor por defecto Stack.
     */
    public void Stack(){
        start = null;
        length = 0;
    }
    /**
     * Consulta si la pila esta vacia.
     * @return true si el primer nodo (start), no apunta a otro nodo.
     */
    public boolean isEmpty(){
        return start == null;
    }
    /**
     * Consulta cuantos elementos (nodos) tiene la pila.
     * @return numero entero entre [0,n] donde n es el numero de elementos que contenga la lista.
     */
    public int getLength(){
        return length;
    }
    /**
     * Agrega un nuevo nodo a la pila.
     * @param value a agregar.
     */
    public void addStack(int value){
        // Define un nuevo nodo.
        Node newNode = new Node();
        // Agrega al valor al nodo.
        newNode.setValue(value);
        // Consulta si la pila esta vacia.
        if (isEmpty()) {
            // Inicializa la pila con el nuevo valor.
            start = newNode;
        }
        // Caso contrario agrega el nuevo nodo al start de la pila.
        else{
            newNode.setNext(start);
            start = newNode;
        }
        // Incrementa el contador del tamaño.
        length++;
    }
    /**
     * Elimina el elemento que se encuentra en el tope de la pila.
     */
    public void removeStack(){
        if (!isEmpty()) {
            // Asigna como primer nodo al siguiente de la pila.
            start = start.getNext();
            // Decrementa el contador del tamaño de la pila
            length--;
        }
    }
    /**
     * Consulta el valor del nodo que se encuentra en la cima de la pila
     * @return valor del nodo.
     * @throws Exception
     */
    public int top() throws Exception{
        if(!isEmpty()){
            return start.getValue();
        } else {
            throw new Exception("La pila se encuentra vacia.");
        }
    }
    /**
     * Busca un elemento en la pila.
     * @param reference valor del nodo a buscar.
     * @return true si el valor de referencia existe en la pila.
     */
    public boolean find(int reference){
        // Crea una copia de la pila.
        Node aux = start;
        // Bandera para verificar si existe el elemento a buscar.
        boolean existe = false;
        // Recorre la pila hasta llegar encontrar el nodo o llegar al final
        // de la pila.
        while(existe != true && aux != null){
            // Compara si el valor del nodo es igual que al de referencia.
            if (reference == aux.getValue()) {
                // Cambia el valor de la bandera.
                existe = true;
            }
            else{
                // Avanza al siguiente nodo.
                aux = aux.getNext();
            }
        }
        // Retorna el valor de la bandera.
        return existe;
    }
    /**
     * Elimina un nodo de la pila ubicado por su valor.
     * @param reference valor de referencia para ubicar el nodo.
     */
    public void remover(int reference){
        // Consulta si el valor existe en la pila.
        if (find(reference)) {
            // Crea una pila auxiliar para guardar los valores que se
            // vayan desapilando de la pila original.
            Node pilaAux = null;
            // Recoore la pila hasta llegar al nodo que tenga el valor
            // igual que el de referencia.
            while(reference != start.getValue()){
                // Crea un nodo temporal para agregarlos a la pila auxiliar.
                Node temp = new Node();
                // Ingresa el valor al nodo temporal.
                temp.setValue(start.getValue());
                // Consulta si la pila auxiliar no a sido inicializada.
                if(pilaAux == null){
                    // Inicializa la pila auxiliar.
                    pilaAux = temp;
                }
                // Caso contrario si la pila auxiliar ya contiene elementos
                // los agrega al start.
                else{
                    temp.setNext(pilaAux);
                    pilaAux = temp;
                }
                // Elimina el nodo del tope de la pila hasta llegar al nodo
                // que se desea eliminar.
                removeStack();
            }
            // Elimina el nodo que coincide con el de referencia.
            removeStack();
            // Regresa los valores de la pila auxiliar a la pila original
            // mientras la pila auxiliar tenga elementos.
            while(pilaAux != null){
                // Utiliza el metodo apilar para regresar los elementos a
                // la pila original.
                addStack(pilaAux.getValue());
                // Avansa al siguiente nodo de la pila auxiliar.
                pilaAux = pilaAux.getNext();
            }
            // Libera la memoria utilizada por la pila auxiliar.
            pilaAux = null;
        }
    }
    /**
     * Actualiza el valor de un nodo en la pila.
     * @param reference valor del nodo para ubicar el que se desea actualizar.
     * @param value por el cual se desea remplazar el valor del nodo.
     */
    public void edit(int reference, int value){
        // Consulta si el nodo existe en la pila
        if (find(reference)) {
            // Crea una pila auxiliar.
            Node pilaAux = null;
            // Recoore la pila hasta llegar al nodo que tenga el valor
            // igual que el de referencia.
            while(reference != start.getValue()){
                // Crea un nodo temporal para agregarlos a la pila auxiliar.
                Node temp = new Node();
                // Ingresa el valor al nodo temporal.
                temp.setValue(start.getValue());
                // Consulta si la pila auxiliar no a sido inicializada.
                if(pilaAux == null){
                    // Inicializa la pila auxiliar.
                    pilaAux = temp;
                }
                // Caso contrario si la pila auxiliar ya contiene elementos
                // los agrega al start.
                else{
                    temp.setNext(pilaAux);
                    pilaAux = temp;
                }
                // Elimina el nodo del tope de la pila hasta llegar al nodo
                // que se desea eliminar.
                removeStack();
            }
            // Actualiza el valor del nodo.
            start.setValue(value);
            // Regresa los valores de la pila auxiliar a la pila original
            // mientras la pila auxiliar tenga elementos.
            while(pilaAux != null){
                // Utiliza el metodo apilar para regresar los elementos a
                // la pila original.
                addStack(pilaAux.getValue());
                // Avansa al siguiente nodo de la pila auxiliar.
                pilaAux = pilaAux.getNext();
            }
            // Libera la memoria utilizada por la pila auxiliar.
            pilaAux = null;
        }
    }
    /**
     * Elimina la pila
     */
    public void delete(){
        // Elimina el valor y la referencia a los demas nodos.
        start = null;
        // Reinicia el contador a 0.
        length = 0;
    }
    /**
     * Despliega en pantalla los elementos de la pìla.
     */
    public void list(){
        // Crea una copia de la pila.
        Node aux = start;
        // Recorre la pila hasta el ultimo nodo.
        while(aux != null){
            System.out.println("|\t" + aux.getValue() + "\t|");
            System.out.println("-----------------");
            aux = aux.getNext();
        }
    }

}
