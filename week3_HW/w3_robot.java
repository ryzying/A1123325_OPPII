
import java.awt.*;
import javax.swing.*;

public class w3_robot extends JPanel {

    public w3_robot() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(new Color(240, 240, 240));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawLine(150, 60, 120, 20);
        g.drawLine(250, 60, 280, 20);

        g.setColor(Color.RED);
        g.fillOval(110, 10, 20, 20);
        g.fillOval(270, 10, 20, 20);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(100, 60, 200, 180, 20, 20);

        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 60, 200, 180, 20, 20);

        g.setColor(Color.WHITE);
        g.fillOval(130, 100, 50, 40);
        g.fillOval(220, 100, 50, 40);

        g.setColor(Color.BLUE);
        g.fillOval(145, 110, 20, 20);
        g.fillOval(235, 110, 20, 20);


        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < 5; i++) {
            g.fillRect(150 + i * 20, 180, 20, 30);
        }

        g.setColor(Color.YELLOW);
        g.fillRect(130, 250, 140, 120);

        g.setColor(Color.BLACK);
        g.drawRect(130, 250, 140, 120);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("我的機器人");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new w3_robot());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
