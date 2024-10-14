package edtree;

import javax.swing.*;

public class MainTree {
    public static void main(String[] args) {
        EDTree<Double> tree = new EDTree<>();
        double[] values = {35, 29, 40, 51, 14, 11, 22, 567, 34, 37, 80, 90, 113};

        for (double v : values) {
            TreeNode<Double> node = new TreeNode<>();
            node.setValue(v);
            tree.add(node);
        }

        System.out.println("Size: " + tree.getSize());
        tree.show();

        JFrame frame = new JFrame("Binary Tree Visualization");
        BinaryTreeCanvas canvas = new BinaryTreeCanvas(tree.getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(canvas);
        frame.setVisible(true);

        TreeNode<Double> searchNode = new TreeNode<>();
        searchNode.setValue(100.0);
        System.out.println("Exists " + searchNode + ": " + tree.search(searchNode));
        searchNode.setValue(22.0);
        System.out.println("Exists " + searchNode + ": " + tree.search(searchNode));
    }
}
