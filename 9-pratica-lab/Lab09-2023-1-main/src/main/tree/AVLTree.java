package tree;

public class AVLTree {
    private node root;

    public AVLTree() {
        this.root = null;
    }

    // Método para inserir um novo nó
    public void insert(int value) {
        this.root = insertRecursive(this.root, value);
    }

    // Método auxiliar recursivo para inserção
    private node insertRecursive(node node, int value) {
        // Caso base: árvore vazia ou encontramos a posição correta para inserir o novo nó
        if (node == null) {
            return new node(value);
        }

        // Inserção recursiva
        if (value < node.getValue()) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecursive(node.getRight(), value));
        } else {
            // Valor já existe na árvore, não fazemos nada
            return node;
        }

        // Atualiza o fator de balanceamento do nó
        updateBalanceFactor(node);

        // Realiza as operações de balanceamento
        return balance(node);
    }

    // Método para calcular o fator de balanceamento de um nó
    private void updateBalanceFactor(node node) {
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        node.setBalanceFactor(rightHeight - leftHeight);
    }

    // Método para calcular a altura de um nó (altura da subárvore)
    private int height(node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    // Método para balancear a árvore
    private node balance(node node) {
        // Se o fator de balanceamento estiver fora do intervalo [-1, 1], a árvore está desbalanceada
        if (node.getBalanceFactor() < -1) {
            // Rotação simples à direita
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                node = rotateRight(node);
            }
            // Rotação dupla: primeiro à esquerda, depois à direita
            else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (node.getBalanceFactor() > 1) {
            // Rotação simples à esquerda
            if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                node = rotateLeft(node);
            }
            // Rotação dupla: primeiro à direita, depois à esquerda
            else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    // Métodos para rotações simples e duplas
    private node rotateLeft(node node) {
        node newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateBalanceFactor(node);
        updateBalanceFactor(newRoot);
        return newRoot;
    }

    private node rotateRight(node node) {
        node newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateBalanceFactor(node);
        updateBalanceFactor(newRoot);
        return newRoot;
    }
}
