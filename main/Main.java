package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import shapes.FractalTree;

public class Main {
    private Frame frame;
    private Drawable currentShape;


    public Main() {
        currentShape = new FractalTree(this);

        frame = new Frame(currentShape.getName());

        BufferStrategy bs = frame.getBufferStrategy();

        if (bs == null) {
            frame.createBufferStrategy(2);
            bs = frame.getBufferStrategy();
        }

        while (true) {
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.BLACK);
            g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
            g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

            g.setColor(Color.WHITE);
            currentShape.draw(g);

            g.dispose();
            bs.show();

            // Control the frame rate
            try {
                Thread.sleep(16); // Approximately 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new Main();
    }
}
