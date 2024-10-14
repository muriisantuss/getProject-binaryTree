package edtree;

public class TreeNode<T> {
    private TreeNode<T> rightNode;
    private TreeNode<T> leftNode;
    private T value;

    public TreeNode() {
        this.rightNode = null;
        this.leftNode = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
