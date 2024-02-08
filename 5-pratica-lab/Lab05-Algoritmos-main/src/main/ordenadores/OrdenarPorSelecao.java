package ordenadores;

public class OrdenarPorSelecao implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        
        //tamanho do array
        int length = array.length;

        //para cada elemento do array
        for (int i = 0; i < length; i++) {
            int indiceMenor = i;  //o apontador do menorIndice/valor vai apontar para o primeiro como padrão
            for (int j = i + 1; j < length; j++) {// então para o restante dos elementos do array,
                //ou seja vai começar pelo segundo elemento

                //se o elemento atual das iterações do for , for menor que o menorIndice/valor
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j; //atualiza o valor do menor
                }
            }
            int aux = array[i]; //se atualizou o valor do menor então troca o valor do menor com o valor do primeiro
            array[i] = array[indiceMenor]; //o valor atual pega o valor do menor
            array[indiceMenor] = aux; //o indiceMenor pega o valor que estava no atual e que não era menor.
        }
        
        return array;
    }
    
    
}
