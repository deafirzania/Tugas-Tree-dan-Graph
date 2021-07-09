package AVLTREE;

public class AvlTreeNode{
    private int num;
    private int height;

    private AvlTreeNode left;
    private AvlTreeNode right;

    //this is the constructor!
    public AvlTreeNode(int value, AvlTreeNode left, AvlTreeNode right){
        this.num = value;
        this.left = left;
        this.right = right;
        this.height = 1;

        if (left != null && left.height() >= height){
            height = left.height() + 1;
        }
        if (right != null && right.height() >= height){
            height = right.height() + 1;
        }
    }

    public AvlTreeNode left(){
        return this.left;
    }

    public AvlTreeNode right(){
        return this.right;
    }

    public int value(){
        return this.num;
    }

    public int height(){
        return height;
    }
}

