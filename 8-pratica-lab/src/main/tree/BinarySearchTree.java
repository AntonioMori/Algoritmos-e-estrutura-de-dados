package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;    
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
        if (root == null) {
            logger.warning("Árvore vazia");
            return 0;
        }
        else{
            node atual = this.root;
            while (atual.getLeft() != null) {
                atual = atual.getLeft();
            }
            return atual.getValue();
        }
    }


    @Override
    public int maximo() {
        if (this.root == null) {
            logger.warning("Árvore vazia");
            return 0;
        }
        else{
            node atual = this.root;
            while (atual.getRight() != null) {
                atual = atual.getRight();
            }
            return atual.getValue();
        }
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
            while (atual.getValue() != valor) { //enquanto o atual tiver valor diferente do valor que queremos
                
                if (valor < atual.getValue()) {// se o valor for menor que o atual  
                    if (atual.getLeft() == null) { //se o da esquerda for null
                        atual.setLeft(new node(valor)); //seta um novo nó na esquerda
                        logger.warning("valor era menor que a raiz, adicionado no lugar do null a esquerda");
                        break;
                    }
                    else{
                        atual = atual.getLeft();  //atual passa a ser o da esquerda e então é verificado o while again

                    }
                }else{//então vai ser maior que o atual
                    if (atual.getRight() == null) {
                        atual.setRight(new node(valor));
                        logger.warning("valor era maior que a raiz, adicionado no lugar do null a direita");
                        break;
                        
                    }else{
                        atual = atual.getRight();
                    }
                }

            }
            if (atual.getValue() == valor) {
                atual.setLeft(new node(valor));
                logger.warning("passou no while e era igual ");   
                
            }   
            
            
        }
            
    }
    

    @Override
    public void remove(int valor) {
        //caso1 filho unico e o proximo é null
        //caso2 remover a raiz
        //caso3 o filho 1 tem outro filho a esquerda ou a direita
        //caso4 o filho 1 tem dois filhos um a esquerda e um a direita
      
        root = removeRecursivo(this.root, valor);
    
    }
    private node removeRecursivo(node atual, int valor){
        
        if (atual == null) { //caso em que a raiz é nula
            return null;
        }

        if (valor == atual.getValue()) { //se o valor a ser removido for o nó atual
            //caso1 Nó sem filhos
            if (atual.getLeft() == null && atual.getRight()== null) {
                return null;
            }
            //caso2 nó com um filho
            if(atual.getLeft()==null){
                return atual.getRight();
            }
            if (atual.getRight()== null) {
                return atual.getLeft();
            }
        
            //caso3 Nó com dois filhos

            int menorValor = findSmallestValue(atual.getRight()); //encontra o menor valor da subarvore a direita
            atual.setValue(menorValor);//seta o valor do nó atual para o menor valor da subarvore a direita
            
            //remove o menor valor da subarvore a direita
            atual.setRight(removeRecursivo(atual.getRight(), menorValor));
            return atual;
        
        }

        if (valor < atual.getValue()) {
            atual.setLeft(removeRecursivo(atual.getLeft(), valor));
            return atual;
        }
        atual.setRight(removeRecursivo(atual.getRight(), valor));
        return atual;

    }

    private int findSmallestValue(node root) {
        return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
    }

//dica usar recursividade  (prof)


    @Override
    public int[] preOrdem() { //visita, esquerda, direita
        List<Integer> lista = new ArrayList<>();
        preOrdemRecursivo(root, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrdemRecursivo(node atual, List<Integer> lista) {
        if (atual != null) {
            lista.add(atual.getValue()); // Visita o nó atual
            preOrdemRecursivo(atual.getLeft(), lista); // Visita a subárvore esquerda recursivamente
            preOrdemRecursivo(atual.getRight(), lista); // Visita a subárvore direita recursivamente
        }
    }

    @Override  //esquerda , visita, direita
    public int[] emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdemRecursivo(root, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void emOrdemRecursivo(node atual, List<Integer> lista) {
        if (atual != null) {
            emOrdemRecursivo(atual.getLeft(), lista); // Visita a subárvore esquerda recursivamente
            lista.add(atual.getValue()); // Visita o nó atual
            emOrdemRecursivo(atual.getRight(), lista); // Visita a subárvore direita recursivamente
        }
    }

    @Override //esquerda, direita, visita
    public int[] posOrdem() {
        List<Integer> lista = new ArrayList<>();
        posOrdemRecursivo(root, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void posOrdemRecursivo(node atual, List<Integer> lista) {
        if (atual != null) {
            posOrdemRecursivo(atual.getLeft(), lista); // Visita a subárvore esquerda recursivamente
            posOrdemRecursivo(atual.getRight(), lista); // Visita a subárvore direita recursivamente
            lista.add(atual.getValue()); // Visita o nó atual
        }
    }


}