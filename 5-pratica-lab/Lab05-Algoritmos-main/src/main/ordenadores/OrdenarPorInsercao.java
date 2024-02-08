package ordenadores;
public class OrdenarPorInsercao implements Ordenador{

    @Override
    public int[] ordene(int[] array) {
        //variável para o tamanho do array
        int length = array.length;
        
        if (length <= 1 || array == null) {
            return array;
        }

        //tendo em vista que o 0 é o primeiro e ele em teoria já está "ordenado"
        for (int j = 1; j < length; j++) {//percorre o tamanho do array começando pelo segundo
            
            int valorAtual = array[j]; //o valor atual a ser verificado  
            int indice = j - 1; //indice anterior 

            //enquanto o indice anterior for maior ou igual a 0 e o valor anterior for maior que o atual
            while (indice >= 0 && array[indice] > valorAtual) { //array[indice] é o valor anterior
                array[indice + 1] = array[indice]; //trocamos o valor atual pelo valor anterior de lugar
                indice--; //diminuimos o indice
            }
            //quando o indice for menor que 0 ou o valor anterior ao atual for menor ou igual ao atual
            array[indice + 1] = valorAtual; //o valor atual é colocado no indice + 1
        }
        return array;
    }
    
}
