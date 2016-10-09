package by.it.savelyeva.jd_01_02;

/**
 * Created by nato on 10/9/16.
 */
public class Tree {
    private Tree left;
    private Tree right;
    private double key;

    public Tree(double key) {
        this.key = key;
    }

    /** Method adds new subtree by comparison of subtree's key (K) to the root node's key (X).
    * If K>=X, then we recursively add a subtree to the right subtree;
    * else (K<X), then we recursively add a subtree to the left subtree.
    * If we have no subtree then insert current subtree here.
    */
    public void insert(Tree tree) {
        if (tree.key < this.key) {
            if (this.left != null) { this.left.insert(tree); }
            else { this.left = tree; }
        } else {
            if (this.right != null) { this.right.insert(tree); }
            else { this.right = tree; }
        }
    }

    /** Method traverses the left and then the right tree recursively
     * and prints the key of the root node.
    */
    public void traverseAndPrint() {
        if (this.left != null) {
            this.left.traverseAndPrint();
        }
        System.out.printf("%.0f ", this.key);
        if (this.right != null ) {
            this.right.traverseAndPrint();
        }
    }
}
