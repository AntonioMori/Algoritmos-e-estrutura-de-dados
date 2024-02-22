package tree;
public class node {
    private int value;
    private node left;
    private node right;
    private int balanceFactor;

    public node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.balanceFactor = 0;
    }

    // Getters e Setters
    // ...

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }
}
