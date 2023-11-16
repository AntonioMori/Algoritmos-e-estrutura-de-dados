package list;

public class FilaAntonio implements Fila {

    public ListaLigada fila = new ListaLigada();


    @Override
    public void enqueue(int item) { //entrada no final
        fila.insereFim(item); //adiciona no final do nó
    }

    @Override
    public int dequeue() { //primeiro sai
        if (isEmpty()==true) {
            return -1;
        }
        int primeiro = fila.buscaIndice(0);
        fila.removeInicio();
        return primeiro;

    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
        
    }

    @Override
    public int size() {
       if (isEmpty()==true) {
            return 0;
        }
        return fila.tamanho();
            
    }
}
    




