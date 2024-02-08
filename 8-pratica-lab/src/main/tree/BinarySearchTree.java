package tree;

import estrut.Tree;

public class BinarySearchTree implements Tree{

    @Override
    public boolean buscaElemento(int valor) {
        return true;
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
    public void insereElemento(int valor) {
        return;
    }

    @Override
    public void remove(int valor) {
        return;
    }

    @Override
    public int[] preOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] emOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] posOrdem() {
        return new int[]{1,2};
    }

}