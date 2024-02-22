package tree;

public class node {
    private node left;
    private node right;
    private int value;
    
        
    //criação de um nó
    public node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public node getLeft() {
        return this.left;
    }

    public node getRight() {
        return this.right;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void setLeft(node left) {
        this.left = left;
    }

    public void setRight(node right) {
        this.right = right;
    }


}
