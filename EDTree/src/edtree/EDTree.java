package edtree;

public class EDTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private long size;

    public EDTree() {
        this.root = null;
        this.size = 0;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public long getSize() {
        return size;
    }

    public void add(TreeNode<T> node) {
        root = addRecursive(root, node);
        size++;
    }

    private TreeNode<T> addRecursive(TreeNode<T> current, TreeNode<T> node) {
        if (current == null) {
            return node;
        }

        if (node.getValue().compareTo(current.getValue()) <= 0) {
            current.setLeftNode(addRecursive(current.getLeftNode(), node));
        } else {
            current.setRightNode(addRecursive(current.getRightNode(), node));
        }
        return current;
    }

    public boolean search(TreeNode<T> node) {
        return searchRecursive(root, node);
    }

    private boolean searchRecursive(TreeNode<T> current, TreeNode<T> node) {
        if (current == null) {
            return false;
        }

        if (node.getValue().equals(current.getValue())) {
            return true;
        }

        return node.getValue().compareTo(current.getValue()) < 0
                ? searchRecursive(current.getLeftNode(), node)
                : searchRecursive(current.getRightNode(), node);
    }

    public void show() {
        showSubTree(root, 1);
    }

    private void showSubTree(TreeNode<T> node, int level) {
        if (node == null) {
            return;
        }

        showSubTree(node.getLeftNode(), level + 1);
        System.out.print(getSpaces(level * 2) + node.getValue() + "\n");
        showSubTree(node.getRightNode(), level + 1);
    }

    private String getSpaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }

    // Additional methods like showToString, showVerticalOrder would go here...
}
