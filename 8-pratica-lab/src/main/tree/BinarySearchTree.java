package tree;

import java.util.logging.Logger;
import org.w3c.dom.Node;
import estrut.Tree;

public class BinarySearchTree implements Tree{


    private static final Logger logger = Logger.getLogger(BinarySearchTree.class.getName());

    private node root;// ela tem um nó raiz
    
    public BinarySearchTree(){ //ao construir é definido como null a raiz 
        this.root = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
    // Se a árvore estiver vazia, retorna falso
    if (this.root == null) {
        return false;
    }
    // Pega o nó atual como a raiz
    node atual = this.root;

    // Loop para percorrer a árvore
    while (atual != null) {
        // Se o valor da busca for o mesmo do nó atual, retorna verdadeiro
        if (atual.getValue() == valor) {
            return true;
        }
        
        // Se o valor for menor que o valor do nó atual, vai para a esquerda
        if (valor < atual.getValue()) {
            atual = atual.getLeft();
        }
        // Se o valor for maior que o valor do nó atual, vai para a direita
        else {
            atual = atual.getRight();
        }
    }
    
    // Se o valor não for encontrado, retorna falso
    return false;
}


    @Override
    public int minimo() {
        return 0;
    }

    @Override
    public int maximo() {
        return 0;
    }

    @Override
    public void insereElemento(int valor) { //insere um elemento na árvore 
        //se a raiz for nula, o valor é inserido na raiz
        if(this.root == null){
            
            this.root = new node(valor);
            logger.warning("Nova árvore criada com raiz " + valor);
        }
        else{
            // se não for null deve ser verificado se o nó é maior ou menor que a raiz
            node atual = this.root;

            //Vai servir para chegar no nó que é nulo ou no nó que tem o mesmo valor
            while (atual != null && atual.getValue() != valor) {
                
                //caso em que é menor que o atual

                if(valor < atual.getValue()){ //se o valor a ser inserido for menor que o nó atual
                    if(atual.getLeft() == null){ //vai pegar o nó esquerdo e verificar se é nulo 
                        //se for ele vai setar como um novo nó
                        atual.setLeft(new node(valor));
                    }
                    //se não for nulo então o nó atual vai ser o nó esquerdo e refazer a verificação
                    atual = atual.getLeft();
                    logger.warning("atual agora passa ser o nó esquerdo do nó atual");  
                }
                else{// Se o valor a ser inserido for maior que o nó atual
                    if(atual.getRight() == null){//se for nulo ele vai setar como um novo nó
                        atual.setRight(new node(valor));
                        
                    }
                    //se não for nulo ele seta o atual como o direito e volta ao loop
                    atual = atual.getRight();
                    logger.warning("atual agora passa ser o nó direito do nó atual");
                }
                
            }
            //uma vez chegado no nó que tem o mesmo valor ele vai setar o valor como o nó esquerdo
            //!!!
            //se o valor for igual ao no atual, porem existem 10 nos iguais ele precisa percorrer até o null

            //!!!
            //botar dentro do while
            if (atual.getValue() == valor){
                atual.setLeft(new node(valor));
                logger.warning("nó com valor igual encontrado, adicionado nó igual a esquerda");
            }   
            
            
        }
    }

    @Override
    public void remove(int valor) {
        return;
    }

    @Override
    public int[] preOrdem() { //visita, esquerda, direita
        return new int[]{1,2};
    }

    @Override  //esquerda , visita, direita
    public int[] emOrdem() {
        
 
        return new int[]{1,2};
    }

    @Override //esquerda, direita, visita
    public int[] posOrdem() {
        return new int[]{1,2};
    }

}