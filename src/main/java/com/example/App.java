package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

public class App extends JPanel {
    private static final int SCALE = 100; //pixels per unit

    private int screenX(double x) {
        return (int)(getWidth()/2 + x * SCALE);
    }

    private int screenY(double y) {
        return (int)(getHeight()/2 - y * SCALE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        

        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(0, height/2, width, height/2); //x
        g2d.drawLine(width/2, 0, width/2, height); //y

        //g2d.setColor(Color.LIGHT_GRAY);
        //for (int i = width / 4; i < width; i += width / 4) {
        //    g2d.drawLine(i, 0, i, height);
        //}
        //for (int i = height / 4; i < height; i += height / 4) {
        //    g2d.drawLine(0, i, width, i);
        //}

        int diameter = 2 * SCALE;
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(1.5f));
        g2d.drawOval(width/2 - SCALE, height/2 - SCALE, diameter, diameter);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        for (int i = -3; i <= 3; i++) {
            if (i != 0) {
                int x = screenX(i);
                int tickTop = height/2 - 5;
                int tickBottom = height/2 + 5;
                g2d.drawLine(x, tickTop, x, tickBottom);
                g2d.drawString(String.valueOf(i), x - 5, height/2 + 20);
            }
        }

        for (int i = -3; i <= 3; i++) {
            if (i != 0) {
                int y = screenY(i);
                int tickLeft = width/2 - 5;
                int tickRight = width/2 + 5;
                g2d.drawLine(tickLeft, y, tickRight, y);
                g2d.drawString(String.valueOf(i), width/2 + 10, y + 5);
            }
        }

        g2d.setColor(Color.RED);
        g2d.drawString("I", width / 4, height / 4);
        g2d.drawString("II", width / 4, height - height / 4);
        g2d.drawString("III", width - width / 4, height - height / 4);
        g2d.drawString("IV", width - width / 4, height / 4);

        g2d.drawString("0", width / 2 + 5, height / 2 + 15);
        //g2d.drawString("1", width / 2 + 20, height / 2 - 20);
        //g2d.drawString("-1", width / 2 - 30, height / 2 - 20);
    }

    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Cartesian Plane");
        App panel = new App();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
}
