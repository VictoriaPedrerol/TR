
package shapes;

import java.awt.Graphics;
import main.Drawable;
import main.Shape;
import main.Main;

public class FractalWavecopy implements Shape, Drawable {
    private Main main;

    public FractalWavecopy(Main main) {
        this.main = main;
    }

    @Override
    public void draw(Graphics g) {
        // Implement drawing logic for the fractal tree
        drawTinyWave2(g, main.getFrame().getWidth() / 2 + 300, main.getFrame().getHeight()+10 , 0, -90, 12);
    }

    private void drawTinyWave2(Graphics g, int centerX, int centerY, double angle, double rotationAngle, int depth) {
        if (depth == 0) return;
    
        // Longitud de las ramas
        int waveLengthX = depth * 8; // Componente X
        int waveLengthY = depth * 8;  // Componente Y
    
        // Calcular las coordenadas relativas al centro
        int relativeX = (int) (Math.cos(Math.toRadians(angle)) * waveLengthX);
        int relativeY = (int) (Math.sin(Math.toRadians(angle)) * waveLengthY);
    
        // Aplicar rotación sobre el centro
        double radians = Math.toRadians(rotationAngle);
        int rotatedX = (int) (relativeX * Math.cos(radians) - relativeY * Math.sin(radians));
        int rotatedY = (int) (relativeX * Math.sin(radians) + relativeY * Math.cos(radians));
    
        // Coordenadas finales en el sistema global
        int x2 = centerX + rotatedX;
        int y2 = centerY + rotatedY;
    
        // Dibujar la línea
        g.drawLine(centerX, centerY, x2, y2);
    
        // Llamadas recursivas
        drawTinyWave2(g, x2, y2, angle - 10, rotationAngle, depth - 1);
        drawTinyWave2(g, x2, y2, angle + 10, rotationAngle, depth - 1);
    }
    

    @Override
    public String getName() {
        return "Fractal Wave";
    }

    @Override
    public double area() {
        // Calculate the area if necessary; otherwise, return a placeholder value
        return 0.0;
    }
}
