package edtree;

import java.awt.*;
import javax.swing.*;

class BinaryTreeCanvas extends JPanel {
    private final TreeNode<?> root;

    public BinaryTreeCanvas(TreeNode<?> root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 50, getWidth() / 4, 50);
        }
    }

    private void drawTree(Graphics g, TreeNode<?> node, int x, int y, int xOffset, int yOffset) {
        g.setColor(Color.BLUE);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.setColor(new Color(173, 216, 230));
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString(node.toString(), x - 7, y + 5);

        if (node.getLeftNode() != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - xOffset, y + yOffset);
            drawTree(g, node.getLeftNode(), x - xOffset, y + yOffset, xOffset / 2, yOffset);
        }

        if (node.getRightNode() != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + xOffset, y + yOffset);
            drawTree(g, node.getRightNode(), x + xOffset, y + yOffset, xOffset / 2, yOffset);
        }
    }
}
