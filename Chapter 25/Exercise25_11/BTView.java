// author: Evie Welch
// date: 02/29/23
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;



public class BTView extends Pane {

    private BST<Integer> tree = new BST<>();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(), getWidth() / 14, getHeight() / 2, vGap);
        }
    }

	/**
	 * Display a subtree rooted at position (x, y)
	 */
    private void displayTree(BST.TreeNode<Integer> root,
            double x, double y, double hGap) {
        if (root.left != null) {
        	double nx = x + hGap;
        	double ny = y + vGap;
        	Line l = new Line(nx, ny, x, y);
            // Draw a line to the left node
//            getChildren().add(new Line(x - hGap, y + vGap, x, y));
        	getChildren().add(l);
            // Draw the left subtree recursively
            displayTree(root.left, nx, ny, hGap / 2);
        }

        if (root.right != null) {
        	double nx = x + hGap;
        	double ny = y - vGap;
            // Draw a line to the right node
        	Line l = new Line(nx, ny, x, y);
        	getChildren().add(l);
//            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the right subtree recursively
            displayTree(root.right, nx, ny, hGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.element + ""));
    }
}
