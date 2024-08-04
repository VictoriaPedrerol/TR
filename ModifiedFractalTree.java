
package shapes;

import java.awt.Graphics;
import main.Drawable;
import main.Shape;
import main.Main;

public class ModifiedFractalTree implements Shape, Drawable {
    private Main main;

    public ModifiedFractalTree(Main main) {
        this.main = main;
    }

    @Override
    public void draw(Graphics g) {
        // Implement drawing logic for the fractal tree
        drawTree(g, main.getFrame().getWidth() / 2, main.getFrame().getHeight(), -90, 9);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    @Override
    public String getName() {
        return "Modified Fractal Tree";
    }

    @Override
    public double area() {
        // Calculate the area if necessary; otherwise, return a placeholder value
        return 0.0;
    }
}
