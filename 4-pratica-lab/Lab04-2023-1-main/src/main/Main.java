import list.EstruturaElementar;
import list.FilaAntonio;
import list.ListaLigada;
import list.PilhaAntonio;

public class Main {
    public static void main(String[] args) {
    
        System.out.println("Teste Pilha:\n");
        PilhaAntonio pilhaTeste = new PilhaAntonio(); //pilha vai criar um linked list vazio
        System.out.println("A pilha está vazia? : "+pilhaTeste.isEmpty()); //true

        pilhaTeste.push(98); //adicionar
        System.out.println("Adicionado o elemento - 98");
        System.out.println("A pilha está vazia? : "+pilhaTeste.isEmpty()); //false
        System.out.println("pop ultimo elemento - "+pilhaTeste.pop()); // 98
       
        //FILA
        System.out.println("\n\n Teste FILA\n");

        FilaAntonio filaTeste = new FilaAntonio();
        System.out.println("\nFila Criada");
        System.out.println("O tamanho deveria ser 0, o Tamanho atual é "+filaTeste.size());
        filaTeste.enqueue(55);
        filaTeste.enqueue(67);

        System.out.println("Adicionado a fila:\nPrimeiro: 55\nSegundo: 67");
        
        System.out.println("O primeiro a sair deveria ser 55, foi: "+filaTeste.dequeue());

        System.out.println("");
    }
}
