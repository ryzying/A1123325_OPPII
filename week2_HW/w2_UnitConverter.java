import java.awt.*;
import javax.swing.*;

public class UnitConverter extends JFrame {

    private JComboBox<String> typeComboBox;

    private JTextField inputField;
    private JTextField resultField;

    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;

    private final String[] lengthUnits = {"公尺", "公分", "英吋", "英尺"};
    private final String[] weightUnits = {"公斤", "公克", "磅", "盎司"};
    private final String[] temperatureUnits = {"攝氏", "華氏", "克氏"};

    public UnitConverter() {

        setTitle("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel northPanel = new JPanel();

        northPanel.add(new JLabel("換算類型："));

        typeComboBox = new JComboBox<>(new String[]{"長度", "重量", "溫度"});

        northPanel.add(typeComboBox);

        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 5, 10));

        JPanel row1 = new JPanel();

        inputField = new JTextField(10);

        fromComboBox = new JComboBox<>(lengthUnits);

        row1.add(new JLabel("輸入："));
        row1.add(inputField);
        row1.add(fromComboBox);


        JPanel row2 = new JPanel();

        resultField = new JTextField(10);
        resultField.setEditable(false);

        toComboBox = new JComboBox<>(lengthUnits);

        row2.add(new JLabel("結果："));
        row2.add(resultField);
        row2.add(toComboBox);

        centerPanel.add(row1);
        centerPanel.add(row2);

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();

        JButton convertButton = new JButton("換算");

        southPanel.add(convertButton);

        add(southPanel, BorderLayout.SOUTH);

        typeComboBox.addActionListener(e -> {

            String type = (String) typeComboBox.getSelectedItem();

            if (type.equals("長度")) {

                updateUnits(lengthUnits);

            } else if (type.equals("重量")) {

                updateUnits(weightUnits);

            } else if (type.equals("溫度")) {

                updateUnits(temperatureUnits);
            }
        });

        convertButton.addActionListener(e -> convert());


        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateUnits(String[] units) {

        fromComboBox.removeAllItems();
        toComboBox.removeAllItems();

        for (String unit : units) {

            fromComboBox.addItem(unit);
            toComboBox.addItem(unit);
        }

        if (units.length > 1) {

            toComboBox.setSelectedIndex(1);
        }
    }


    private void convert() {

        try {

            double value = Double.parseDouble(inputField.getText());

            String type = (String) typeComboBox.getSelectedItem();

            String fromUnit = (String) fromComboBox.getSelectedItem();

            String toUnit = (String) toComboBox.getSelectedItem();

            double result = 0;

            if (type.equals("長度")) {

                double meter = 0;

                switch (fromUnit) {

                    case "公尺":
                        meter = value;
                        break;

                    case "公分":
                        meter = value / 100;
                        break;

                    case "英吋":
                        meter = value * 0.0254;
                        break;

                    case "英尺":
                        meter = value * 0.3048;
                        break;
                }

                switch (toUnit) {

                    case "公尺":
                        result = meter;
                        break;

                    case "公分":
                        result = meter * 100;
                        break;

                    case "英吋":
                        result = meter / 0.0254;
                        break;

                    case "英尺":
                        result = meter / 0.3048;
                        break;
                }
            }

            else if (type.equals("重量")) {

                double kg = 0;

                switch (fromUnit) {

                    case "公斤":
                        kg = value;
                        break;

                    case "公克":
                        kg = value / 1000;
                        break;

                    case "磅":
                        kg = value * 0.45359237;
                        break;

                    case "盎司":
                        kg = value * 0.0283495231;
                        break;
                }

                switch (toUnit) {

                    case "公斤":
                        result = kg;
                        break;

                    case "公克":
                        result = kg * 1000;
                        break;

                    case "磅":
                        result = kg / 0.45359237;
                        break;

                    case "盎司":
                        result = kg / 0.0283495231;
                        break;
                }
            }

            else if (type.equals("溫度")) {

                double celsius = 0;

                switch (fromUnit) {

                    case "攝氏":
                        celsius = value;
                        break;

                    case "華氏":
                        celsius = (value - 32) * 5 / 9;
                        break;

                    case "克氏":
                        celsius = value - 273.15;
                        break;
                }


                switch (toUnit) {

                    case "攝氏":
                        result = celsius;
                        break;

                    case "華氏":
                        result = celsius * 9 / 5 + 32;
                        break;

                    case "克氏":
                        result = celsius + 273.15;
                        break;
                }
            }

            resultField.setText(String.format("%.4f", result));

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "請輸入正確的數字！",
                    "輸入錯誤",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new UnitConverter();
        });
    }
}