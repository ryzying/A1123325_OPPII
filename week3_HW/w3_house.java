
import java.awt.*;
import javax.swing.*;

public class w3_house extends JPanel {

    public w3_house() {
        setPreferredSize(new Dimension(500, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 500, 300);

        g.setColor(new Color(76, 175, 80));
        g.fillRect(0, 300, 500, 100);

        g.setColor(Color.YELLOW);
        g.fillOval(380, 30, 80, 80);

        g.setColor(Color.YELLOW);
        for (int i = 0; i < 8; i++) {
            double angle = Math.PI * 2 * i / 8;

            int x1 = 420 + (int)(55 * Math.cos(angle));
            int y1 = 70 + (int)(55 * Math.sin(angle));

            int x2 = 420 + (int)(75 * Math.cos(angle));
            int y2 = 70 + (int)(75 * Math.sin(angle));

            g.drawLine(x1, y1, x2, y2);
        }

        g.setColor(Color.WHITE);
        g.fillOval(60, 65, 80, 60);
        g.fillOval(100, 50, 90, 75);
        g.fillOval(145, 65, 80, 60);

    
        g.setColor(new Color(255, 228, 181));
        g.fillRect(150, 180, 200, 150);

        g.setColor(Color.BLACK);
        g.drawRect(150, 180, 200, 150);

       
        g.setColor(Color.RED);
        g.drawLine(130, 180, 250, 90);
        g.drawLine(250, 90, 370, 180);
        g.drawLine(370, 180, 130, 180);

        g.setColor(Color.WHITE);
        g.fillRect(170, 210, 50, 50);

        g.setColor(Color.BLACK);
        g.drawRect(170, 210, 50, 50);
        g.drawLine(195, 210, 195, 260);
        g.drawLine(170, 235, 220, 235);


        g.setColor(Color.WHITE);
        g.fillRect(280, 210, 50, 50);

        g.setColor(Color.BLACK);
        g.drawRect(280, 210, 50, 50);
        g.drawLine(305, 210, 305, 260);
        g.drawLine(280, 235, 330, 235);


        g.setColor(new Color(139, 69, 19));
        g.fillRoundRect(225, 250, 50, 80, 15, 15);

        g.setColor(Color.YELLOW);
        g.fillOval(263, 287, 8, 8);

        g.setColor(Color.BLACK);
        g.drawString("A1123325 阮玉簪英", 10, 390);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("我的小房子");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new w3_house());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
