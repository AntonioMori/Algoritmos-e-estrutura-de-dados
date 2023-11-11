package array;

import list.EstruturaElementar;
import java.util.logging.Logger;

public class ListaArray implements EstruturaElementar{

    private static final Logger logger = Logger.getLogger(ListaArray.class.getName());

    private int[] array; //criação do arrey, vazio
    private int indice_fim; //indice do fim, ou seja tamanho


    public ListaArray() {
        int indiceFim = 0;
        array = new int[indiceFim];
        

    }

    @Override
    public boolean buscaElemento(int valor) { //parãmetro é o valor
        //casos excepcionais, valor nao encontrado, array vazio,valor no indice 0,
        if (array == null || array.length == 0) {
            // array vazio
            logger.warning("empty arrayList");
            return false;
        }
        boolean resultado = false;
        for (int i = 0; i < array.length; i++) {
            if (valor==array[i]) {
                resultado=true;
            }                
        }
        return resultado;
    }


    
    

    @Override
    public int buscaIndice(int valor) { //vai receber um indice e vai retornar o valor desse indice
        //casos excepcionais, indice 0, indice maior q o tamanho do array, ou que o array é nulo

        if (array == null || array.length == 0) {
            // array vazio
            logger.warning("empty arrayList");
            return -1;
            
        }

        int resultado = -1;

        for (int indice : array) {//enhanced for para arrays, esse indice vai ser o indice verificado a cada loop
            if(valor==indice) { // se o indice passado(valor) for igual ao indice verificado , ent retorna o seu valor
                resultado = array[indice];
            }
        }
        if (resultado==-1) {
            logger.warning("index out of bound");
            
        }
        return resultado; //nesse caso se o indice nao for encontrado tmb vai retornar -1

            
    }

    @Override
    public int minimo() {
        if(array==null && array.length==0){
            logger.warning("empty arraylist");
            return -1;
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]<min){
                min = array[i];

            }
        }
        return min;
    }

    @Override
    public int maximo() {
        if(array==null && array.length==0){
            logger.warning("empty arraylist");
            return -1;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max) {
                max = array[i];
                
            }
        }
        return max;
    }

    @Override
    public int predecessor(int valor) {//leva um valor como parâmetro e retorna o valor anterior
        //se a lista só tiver 1 elemento entao o anterior é null
        if (array.length == 1) {
            return -1;
            
        }
        int indice=0;
        int anterior=-1;
        while (array[indice] != valor && indice < array.length) {
            anterior += indice;
            indice +=1;//vai parar se achar o valor no array, ou se chegar no tamanho do array

        }
        if(array[indice]==valor){

            return array[anterior];
        }
        return -1;
    }

    @Override
    public int sucessor(int valor) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == valor) {
                return array[i + 1]; // Retorna o sucessor se encontrado
            }
        }
        return -1; // Retorna -1 se o valor não for encontrado ou não tiver sucessor
    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) { //valor a ser add, e indice desejado
       if(array.length ==1){ //se o array tiver só o inicio
            array[0] = valor;
        }
        
        int indice = 0;
        int[] novoArray = new int[array.length+1];
        
        for (int i = 0; i < array.length; i++) { //percorrer o array
            
            if (indice == buscaIndice) { //se achar o indice desejado, só sera true uma unica vez
                
                //vai copiar do array antigo para o novo array,do início até o valor do indice atual
                System.arraycopy(array, 0, novoArray, 0, indice); //indice11 vao ser 12 elementos a serem copiados
                novoArray[indice] = valor;
                System.arraycopy(array, indice, novoArray, indice+1, array.length-indice);
                array = novoArray;
            }
            indice+= 1;
            

        }
            
        
        if (buscaIndice>indice) {
            logger.warning("index out of bound");
            
        }
    }

    
    @Override
    public void insereInicio(int valor) {//ele atualemnte está substituindo o valor do array,
        //queremos aumentar, copiar e depois colocar no indice 0
        //começa no 19, enquanto nao chegar em 1
       
        //criando um novo array maior que o anterior
        int[] novoArray = new int[array.length+1]; //array =10, NovoArray=11
        indice_fim = novoArray.length;
        
        for (int i = 0; i < array.length; i++){ 
            novoArray[i+1] = array[i];
        }
        
        novoArray[0] = valor;
        array = novoArray;
    }


    @Override
    public void insereFim(int valor) {
        
        
        int[] novoArray = new int[array.length+1];
        indice_fim= novoArray.length;
        System.arraycopy(array, 0, novoArray, 0, array.length);
        novoArray[array.length]= valor;
        array = novoArray;
        
        
        


        
    }

    @Override
    public void remove(int valor) { //leva como parâmetro o valor a ser removido

        for (int i = 0; i < array.length; i++) {
            if (array[i]==valor) {
                array[i] = 0;
                
            }
        }
    }

    @Override
    public void removeIndice(int indice) { //é passado um indice a ser removido
        
        int index = 0;
        int[] novoArray = new int[array.length-1]; //cria um array menor sem aquele indice
        



        for (int i = 0; i < array.length; i++) { //percorrer o array
            
            if (index == indice ) { //se achar o indice desejado, só sera true uma unica vez
                
                //vai copiar do array antigo para o novo array,do início até o valor do indice anterior
                System.arraycopy(array, 0, novoArray, 0, index) ; //indice11 vao ser 12 elementos a serem copiados
                System.arraycopy(array, index+1, novoArray, index, array.length-index-1);
                array = novoArray;
            }
            indice+= 1;
            

        }
            
        
        if (index>indice) {
            logger.warning("index out of bound");
            
        }

    }

    @Override
    public void removeInicio() {
        if(indice_fim==0){
            logger.warning("empty array");
        }else{

            
            int[] novoArray = new int[array.length-1];
            
            for (int i = 0; i < novoArray.length; i++) {
                novoArray[i] = array[i+1];
            }
            array =novoArray;
            
        }
    }

    @Override
    public void removeFim() {
       if(indice_fim==0){
            logger.warning("empty array");
        }else{
            int[] novoArray= new int[array.length-1];
            System.arraycopy(array,0, novoArray, 0, array.length-1);
            array= novoArray;

        }
    }
    
}
