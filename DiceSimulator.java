import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class DiceSimulator extends JFrame {

    private JLabel diceLabel;
    private JLabel resultLabel;
    private JButton rollButton;

    private int count = 0;   
    private int sum = 0;     

    private Random random = new Random();

    public DiceSimulator() {

        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        resultLabel = new JLabel("已擲 0 次，總和 0，平均 0.00",SwingConstants.CENTER);
        resultLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));

        diceLabel = new JLabel("0", SwingConstants.CENTER);
        diceLabel.setFont(new Font("Arial", Font.BOLD, 60));
        diceLabel.setForeground(Color.BLACK);

        rollButton = new JButton("擲骰子");
        rollButton.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));

        rollButton.addActionListener(e -> rollDice());

        add(resultLabel, BorderLayout.NORTH);
        add(diceLabel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void rollDice() {

        int dice = random.nextInt(6) + 1;
        count++;
        sum += dice;
        diceLabel.setText(String.valueOf(dice));

        if (dice == 6) {
            diceLabel.setForeground(Color.GREEN);
        } else if (dice == 1) {
            diceLabel.setForeground(Color.RED);
        } else {
            diceLabel.setForeground(Color.BLACK);
        }

        double average = (double) sum / count;

        resultLabel.setText(String.format("已擲 %d 次，總和 %d，平均 %.2f",count, sum, average));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new DiceSimulator();
        });
    }
}