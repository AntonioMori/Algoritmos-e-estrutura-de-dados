package list;

public class FilaComPilhaAntonio implements FilaComPilha {

    PilhaAntonio pilhaEnqueue = new PilhaAntonio(); //pilha de entrada
    PilhaAntonio pilhaDequeue = new PilhaAntonio(); // pilha de saida

    //construtor
    @Override
    public void enqueue(int item) {
        pilhaEnqueue.push(item);

    }

    @Override
    public int dequeue() {
        if (pilhaDequeue.isEmpty()==true) {//se a pilha do final estiver vazia
            while (pilhaEnqueue.isEmpty()==false) {//enquanto a pilha de entrada tiver pacientes
                int paciente = pilhaEnqueue.pop(); //o paciente da fila de entrada vai ir para a saida
                pilhaDequeue.push(paciente);// indo para a saida, ou seja sendo atendido
            }
        }
        return pilhaDequeue.pop();

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }
    
}
