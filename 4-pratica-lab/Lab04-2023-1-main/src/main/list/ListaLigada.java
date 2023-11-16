package list;

import java.util.logging.Logger;
import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

private static final Logger logger = Logger.getLogger(ListaLigada.class.getName());

    private No cabeca;

    public ListaLigada() {
        cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {//valor a ser buscado
        No atual = cabeca; //cabeça sempre aponta para o primeiro elemento (indice(0))

        while (atual!=null) {//enquanto não chegar no final, quando chegar no final vai verificar o ultimo e no proximo vai ser null ent ele para
            if (valor == atual.getValor()) {
                return true;
            }else{
                atual = atual.getProximo();
            }

        }
        
        return false;
       
    }

    @Override
    public int buscaIndice(int valor) {//valor = indice a ser buscado
        //passar o indice e retornar o valor
        //o primeiro nó a ser procurado 
        
        No atual = cabeca; //"inicio"
        int indice = 0; //indice do início vai ser o 0

        while (atual!=null) { //enquanto não chegar no ultimo nó que tem apontamento para proximo= null
            if (valor==indice) { //verifica se é o índice que queremos
                return atual.getValor(); //retorna o valor do indice se for o que queremos
                
            }
            else{ //se não for o nosso índice, o atual agora vai ser o próximo do que o nó que acabamos de verificar
                atual = atual.getProximo(); // 
                indice += 1; //aumenta o valor do índice, o primieor foi 0, o segundo 1 e assim vai
            }

        }
        return -1; // se não tiver o índice que queremos achar então retorna -1
            
       
    }

    @Override
    public int minimo() {
        No atual = cabeca; //O Nó atual vai ser = a cabeça, no qual aponta para o primeiro nó
        int minimo = atual.getValor(); //o mínimo vai ser definido como o valor do primeiro nó
        
        while(atual!=null){ //percorrer todos os nós até chegar no ultimo o proximo será null onde ele para.
            if(atual.getValor()<minimo){ //se o valor atual for menor que o mínimo definido no primeiro nó
                minimo = atual.getValor(); //ele atualiza o valor do mínimo para o valor encontrado que é menor
                atual = atual.getProximo();// atualiza o atual para fazer a verificação de novo

            }else{ // se o atual não tiver um valor para ser considerado mínimo ele passa para o próximo nó
                atual = atual.getProximo();
            }

        }
        return minimo; // retorna o mínimo encontrado ao percorrer essa lista orndenada
    }

    @Override
    public int maximo() { // mesma coisa do mínimo só que muda o operador
        No atual = cabeca; //O Nó atual vai ser = a cabeça, no qual aponta para o primeiro nó
        int max = atual.getValor(); //o máximo vai ser definido como o valor do primeiro nó
        
        while(atual!=null){ //percorrer todos os nós até chegar no ultimo o proximo será null onde ele para.
            if(atual.getValor()>max){ //se o valor atual for maior que o máx já definido no primeiro nó
                max = atual.getValor(); //ele atualiza o valor do max para o valor encontrado (que é maior)
                atual = atual.getProximo();// atualiza a variable atual para fazer a verificação de novo

            }else{ // se o atual não tiver um valor para ser considerado máximo ele passa para o próximo nó
                atual = atual.getProximo();
            }

        }
        return max; // retorna o máximo encontrado ao percorrer essa lista orndenada
    }
    

    @Override
    public int predecessor(int valor) {
        if (cabeca == null || cabeca.getValor() == valor) {
            return -1; 
        }
        

            No anterior = null;
            No atual = cabeca;
        
            while (atual != null && atual.getValor() != valor) { //vai parar no final ou se achar o valor que desejamos
                anterior = atual; //a variavel anterior vai apontar para o atual
                atual = atual.getProximo(); //vamos ir para o proximo nó
            
            }
                
            if (atual != null) { //ele parou no atual.getValor == valor (true)
                //entao encontramos o valor que desejavamos
                // O nó com o valor foi encontrado, retorna o valor do predecessor.
                return anterior.getValor();
            
            } 
            else{
                //O valor atual não foi encontrado na lista entao return -1.
                return -1; 
            }
        
    }
    

    @Override
    //return o valor do proximo?
    public int sucessor(int valor) { //parametro o valor será o .getValor 

        No atual = cabeca; //define onde começar
        
        //enquanto o valor atual for diferente de null ou seja nao for uma lista vazia ou a lista nao tiver acabado, ou o valor atual for diferente do que queremos achar
        while (atual != null && atual.getValor() != valor) {
            atual = atual.getProximo(); // atualiza o atual
        }

        //se o while achar o atual.getValor != false entao teremos encontrado o valor atual, agora precisamos verificar
        //se o proximo vai ser null 
        if (atual.getProximo() != null) {

            return atual.getProximo().getValor();
        }

        return -1;

    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
        
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if(this.cabeca==null){ // se a lista estiver vazia vai add no inicio
            this.cabeca = new No(valor);
            logger.warning("empty list, added on the start[0]");
        }
        else{
             
            No atual = cabeca; // vai começar pelo primeiro Nó, para percorrer até o indice desejado
            int indice = 0; //primeiro Nó tem indice 0

            while (atual.getProximo()!=null) { //enquanto não chegar no ultimo Nó que tem apontamento para proximo= null
                    
                
                    if (buscaIndice==indice + 1) {  //verifica se é o Nó anterior ao indice que queremos
                        //exemplo: queremos mudar o indice 40 entao se estivermos no 39 ent podemos mudar o proximo

                        No novoNo = new No(valor); //cria um novoNo que será o nó a ser inserido
                        No proximo = atual.getProximo();//pegando o nó indice[40] originalmente


                        atual.setProximo(novoNo);// o proximo do 39 agora vai ser o novoNó
                        novoNo.setProximo(proximo); //o novo nó agora vai ter como proximo o proximo nó que é o 40 original
                        
                        atual = atual.getProximo(); 
                        indice += 1;
                    }
                    else{ 
                        if(buscaIndice==0 && indice == 0){ //se o indice que queremos inserir um elemento for o 0, significa que é no inicio
                            No novoNo = new No(valor);
                            novoNo.setProximo(cabeca);
                            this.cabeca = novoNo;
                        }
                        // se o index que queremos procurar é 40 estamos no 39 e o proximo for null, significa que não existe index 40
                        
                            atual = atual.getProximo(); 
                            indice += 1; //aumenta o valor do índice, o primieor foi 0, o segundo 1 e assim vai
                            //se não for o nosso índice, o atual agora vai ser o próximo do que o nó que acabamos de verificar
                        
                    }
            }
           if (buscaIndice>indice){ // se o index passado for maior do que o tamanho da lista, será adicionado no final
            No novoNo = new No(valor);
            atual.setProximo(novoNo); //o atual neste caso é o ultimo pois já passou por todo while
            
            logger.warning("index out of bound, added at end");
            }     
        }
        

    }

    @Override
    public void insereInicio(int valor) {
        if(this.cabeca == null){ // se a cabeça apontar para null então
            this.cabeca = new No(valor); //cria um nó, agora cabeça aponta para esse nó que o proximo é null
        }
        else{
            No n = new No(valor); //como a cabeça já aponta para um nó, cria um novo nó com o valor desejado
            n.setProximo(cabeca); // agora o nó vai apontar para onde a cabeça inicialmente estava apontando , (do qual o proximo e null portanto ele vai ser o ultimo)
            this.cabeca = n;  //o apontamento da cabeça agora vai ser o novo nó criado, então temos a cabeça apontando para n, que aponta para outro nó que aponta para null
 
        }
    }

    @Override
    public void insereFim(int valor) {
        No novoNo = new No(valor); // Cria o novo nó com o valor fornecido

        if (this.cabeca == null) {
            // Se a lista estiver vazia, o novo nó se torna a cabeça da lista
            this.cabeca = novoNo;
        } else {
            No atual = cabeca;

            // Percorre a lista até encontrar o último nó
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }

            // Define o próximo do último nó como o novo nó
            atual.setProximo(novoNo);
        }
    }

    @Override
    public void remove(int valor) { //vai remover o valor a partir de .getValor
        No atual = cabeca;//começando pelo  primeiro nó
        No anterior = null; //anterior == null no primeiro
        boolean condition = true;
        if (atual.getValor()== valor) { //se o valor atual  == valor que desejamos achar ent, é o primeiro elemento
            cabeca = cabeca.getProximo();// basta mudar cabeça
            condition = false;
        }

        while (atual.getProximo()!=null && condition) { // enquanto não chegar no ultimo e se nao for o primeiro Nó
            if (atual.getValor()==valor) { // se acharmos o valor então
                No novoNo = atual.getProximo();
                anterior.setProximo(novoNo);
                break;
            }
            else{

                anterior = atual;
                atual = atual.getProximo();

            }

            
        }
        if (atual.getProximo()==null && atual.getValor()!= valor) { // se chegar no final e o ultimo Nó nao tiver o valor desejado entao.
            logger.warning("value not found");
            
        }
        
    }

    @Override
    public void removeIndice(int indice) {
        No atual = cabeca; //começando do primeiro
        int indexCounter = 0; //indice 0 no primeiro
        
        //se counter = 0 e indice = 0
        if (indexCounter == 0 && indexCounter == indice) {
            removeInicio();
        }
        else{
            
            No anterior = null; //anterior == null
            
            while (indexCounter != indice) {//até achar o indice //se counder = 3 e indice = 3
                
                indexCounter += 1; 
                anterior = atual;
                
                if (atual.getProximo()==null){
                    logger.warning("index out of bound.");
                    break;
                }
                else{
                    atual = atual.getProximo();
                    
                }
            }

            //chegou até o indice desejado 
            if(atual.getProximo()==null){
                removeFim();
            }
            else{
                //atual é o indice procurado, exemplo counter = 2 , indice = 2
                No novoNo = atual.getProximo();//pega o proximo nó
                anterior.setProximo(novoNo);//atrela ao proximo do anterior "rsrs"

            }
            
        }
            
            
    }

    

    @Override
    public void removeInicio() {
        //se o inicio já for vazio?
        if(cabeca== null){
            cabeca = null;
        }
        else{

            No segundo = cabeca.getProximo();
            cabeca = segundo;
        }

    }

    @Override
    public void removeFim() {
        No atual = cabeca;
        No anterior = null;
    
        if (atual == null) {
            // Lista vazia
            logger.warning("error, empty list");
        } 
        else{
            //
            while (atual.getProximo() != null) {
                anterior = atual;
                atual = atual.getProximo();
            }
    
            if (anterior == null) {
                // Havia apenas um nó na lista
                cabeca = null;
            } else {
                // Remove o último nó
                anterior.setProximo(null);
            }
        }
    }

    public boolean isEmpty(){
        if (cabeca==null) { // lista ligada vazia
            return true; //retorna true se for vazia
            
        }
        return false;
    }
    public int tamanho(){
        if (isEmpty()==true) {
            return 0;
        }

        No atual = cabeca;
        int size = 0;
        while (atual!=null) {
            size+=1;
            atual = atual.getProximo();

        }
        return size;
    }

}
