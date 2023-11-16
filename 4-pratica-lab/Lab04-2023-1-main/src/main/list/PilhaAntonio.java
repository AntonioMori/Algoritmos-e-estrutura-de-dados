package list;

public class PilhaAntonio implements Pilha {

    
    public ListaLigada pilha = new ListaLigada();

    

    @Override
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public void push(int item) {
       
        pilha.insereInicio(item);
        

    }

    @Override
    public int pop() { // retorna o valor 
        int valorExtraido = this.pilha.buscaIndice(0);
        pilha.removeInicio();
        return valorExtraido;
    }
    
}
