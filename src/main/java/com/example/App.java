package com.example;

public class App extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.Key_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.BLACK);

        int width = getWidth();
        int height = getHeight();

        g2d.drawLine(0, height/2, width, height/2);
        g2d.drawLine(width/2, 0, width/2, height);

        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = width / 4; i < width; i += width / 4) {
            g2d.drawLine(i, 0, i, height);
        }
        for (int i = height / 4; i < height; i += height / 4) {
            g2d.drawLine(0, i, width, i);
        }

        g2d.setColor(Color.RED);
        g2d.drawString("I", width / 4, height / 4);
        g2d.drawString("II", width / 4, height - height / 4);
        g2d.drawString("III", width - width / 4, height - height / 4);
        g2d.drawString("IV", width - width / 4, height / 4);

        g2d.drawString("0", width / 2 + 5, height / 2 + 15);
        g2d.drawString("1", width / 2 + 20, height / 2 - 20);
        g2d.drawString("-1", width / 2 - 30, height / 2 - 20);
        g2d.drawString("1", width / 2 + 20, height / 2 - 20);
    }

    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Cartesian Plane");

        CartesianPlane panel = new CartesianPlane();

        frame.setSize(600, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        frame.setVisible(true);
    }
}
