package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import shapes.FractalWave;
import shapes.FractalTree;

public class Main {
    private Frame frame;
    private Drawable currentShape;


    public Main() {
        currentShape = new FractalWave(this);

        frame = new Frame(currentShape.getName());

        BufferStrategy bs = frame.getBufferStrategy();

        if (bs == null) {
            frame.createBufferStrategy(2);
            bs = frame.getBufferStrategy();
        }

        while (true) {
            Graphics g = bs.getDrawGraphics();

            g.setColor(new Color(223, 242, 255));
            g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
            g.fillRect(0, 0, frame.getWidth(), frame.getHeight());

            g.setColor(new Color(37, 96, 210));
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
