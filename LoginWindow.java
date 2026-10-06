import javax.swing.*;

public class LoginWindow extends JFrame {

    public LoginWindow() {

        setTitle("登入");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel l1 = new JLabel("帳號：");
        l1.setBounds(40, 30, 60, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(100, 30, 130, 25);

        JLabel l2 = new JLabel("密碼：");
        l2.setBounds(40, 70, 60, 25);

        JPasswordField t2 = new JPasswordField();
        t2.setBounds(100, 70, 130, 25);

        JButton btn = new JButton("登入");
        btn.setBounds(100, 110, 80, 30);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        btn.addActionListener(e -> {

            String username = t1.getText();
            String password = new String(t2.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "登入成功！");
            } else {
                JOptionPane.showMessageDialog(this, "帳號或密碼錯誤！");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}