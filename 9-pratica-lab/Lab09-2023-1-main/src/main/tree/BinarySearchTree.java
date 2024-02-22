package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BinarySearchTree {

    private static final Logger logger = Logger.getLogger(BinarySearchTree.class.getName());

    private node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean buscaElemento(int valor) {
        if (this.root == null) {
            return false;
        }
        node atual = this.root;
        while (atual != null) {
            if (atual.getValue() == valor) {
                return true;
            }
            if (valor < atual.getValue()) {
                atual = atual.getLeft();
            } else {
                atual = atual.getRight();
            }
        }
        return false;
    }

    public int minimo() {
        if (root == null) {
            logger.warning("Árvore vazia");
            return 0;
        } else {
            node atual = this.root;
            while (atual.getLeft() != null) {
                atual = atual.getLeft();
            }
            return atual.getValue();
        }
    }

    public int maximo() {
        if (this.root == null) {
            logger.warning("Árvore vazia");
            return 0;
        } else {
            node atual = this.root;
            while (atual.getRight() != null) {
                atual = atual.getRight();
            }
            return atual.getValue();
        }
    }

    public void insereElemento(int valor) {
        this.root = insereRecursivo(this.root, valor);
    }

    private node insereRecursivo(node node, int valor) {
        if (node == null) {
            return new node(valor);
        }

        if (valor < node.getValue()) {
            node.setLeft(insereRecursivo(node.getLeft(), valor));
        } else if (valor > node.getValue()) {
            node.setRight(insereRecursivo(node.getRight(), valor));
        } else {
            return node;
        }

        node.setBalanceFactor(calculaBalanceFactor(node));

        return balancear(node);
    }

    private int calculaBalanceFactor(node node) {
        int alturaEsquerda = altura(node.getLeft());
        int alturaDireita = altura(node.getRight());
        return alturaDireita - alturaEsquerda;
    }

    private int altura(node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(altura(node.getLeft()), altura(node.getRight()));
    }

    private node balancear(node node) {
        if (node.getBalanceFactor() < -1) {
            if (altura(node.getLeft().getLeft()) >= altura(node.getLeft().getRight())) {
                node = rotacaoDireita(node);
            } else {
                node.setLeft(rotacaoEsquerda(node.getLeft()));
                node = rotacaoDireita(node);
            }
        } else if (node.getBalanceFactor() > 1) {
            if (altura(node.getRight().getRight()) >= altura(node.getRight().getLeft())) {
                node = rotacaoEsquerda(node);
            } else {
                node.setRight(rotacaoDireita(node.getRight()));
                node = rotacaoEsquerda(node);
            }
        }
        return node;
    }

    private node rotacaoEsquerda(node node) {
        node novaRaiz = node.getRight();
        node.setRight(novaRaiz.getLeft());
        novaRaiz.setLeft(node);
        node.setBalanceFactor(calculaBalanceFactor(node));
        novaRaiz.setBalanceFactor(calculaBalanceFactor(novaRaiz));
        return novaRaiz;
    }

    private node rotacaoDireita(node node) {
        node novaRaiz = node.getLeft();
        node.setLeft(novaRaiz.getRight());
        novaRaiz.setRight(node);
        node.setBalanceFactor(calculaBalanceFactor(node));
        novaRaiz.setBalanceFactor(calculaBalanceFactor(novaRaiz));
        return novaRaiz;
    }

    public void remove(int valor) {
        root = removeRecursivo(root, valor);
    }

    private node removeRecursivo(node atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor == atual.getValue()) {
            if (atual.getLeft() == null && atual.getRight() == null) {
                return null;
            }
            if (atual.getLeft() == null) {
                return atual.getRight();
            }
            if (atual.getRight() == null) {
                return atual.getLeft();
            }

            int menorValor = encontraMenorValor(atual.getRight());
            atual.setValue(menorValor);
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

    private int encontraMenorValor(node root) {
        return root.getLeft() == null ? root.getValue() : encontraMenorValor(root.getLeft());
    }

    public int[] preOrdem() {
        List<Integer> lista = new ArrayList<>();
        preOrdemRecursivo(root, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrdemRecursivo(node atual, List<Integer> lista) {
        if (atual != null) {
            lista.add(atual.getValue());
            preOrdemRecursivo(atual.getLeft(), lista);
            preOrdemRecursivo(atual.getRight(), lista);
        }
    }

    public int[] emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdemRecursivo(root, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void emOrdemRecursivo(node atual, List<Integer> lista) {
        if (atual != null) {
            emOrdemRecursivo(atual.getLeft(), lista);
            lista.add(atual.getValue());
            emOrdemRecursivo(atual.getRight(), lista);
        }
    }

    public int[] posOrdem() {
        List<Integer> lista = new ArrayList<>();
        posOrdemRecursivo(root, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void posOrdemRecursivo(node atual, List<Integer> lista) {
        if (atual != null) {
            posOrdemRecursivo(atual.getLeft(), lista);
            posOrdemRecursivo(atual.getRight(), lista);
            lista.add(atual.getValue());
        }
    }

}