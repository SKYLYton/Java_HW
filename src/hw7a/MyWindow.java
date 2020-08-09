package hw7a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame implements ActionListener {

    private JTextField textField;
    private double savedC;
    private final int SIZE_W = 350;
    private final int SIZE_H = 220;
    private JTextField textFieldCommand;

    public MyWindow() {
        setBounds(200, 200, SIZE_W, SIZE_H);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Калькулятор");


        setResizable(false);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setLayout(new BorderLayout());

        Font font = new Font("Arial", Font.PLAIN, 14);

        JPanel panel = new JPanel(new GridLayout(4, 10));


        int c = 0;

        for (int i = 0; i < 16; i++) {
            if (i != 3 && i != 7 && i != 11) {
                c++;
            }
            JButton button1 = new JButton(c + "");
            button1.setFont(font);
            button1.addActionListener(this);
            panel.add(button1);
        }

        ((JButton) panel.getComponent(3)).setText("+");
        ((JButton) panel.getComponent(7)).setText("-");
        ((JButton) panel.getComponent(11)).setText("/");
        ((JButton) panel.getComponent(12)).setText("C");
        ((JButton) panel.getComponent(13)).setText("0");
        ((JButton) panel.getComponent(14)).setText("=");
        ((JButton) panel.getComponent(15)).setText("*");


        add(panel, BorderLayout.SOUTH);

        JPanel panel1 = new JPanel(new GridLayout(1, 2));

        textField = new JTextField();
        textField.setFont(font);
        textField.setText("0");
        textField.setEnabled(false);

        panel1.add(textField);

        textFieldCommand = new JTextField();
        textFieldCommand.setFont(font);
        textFieldCommand.setText("");
        textFieldCommand.setEnabled(false);

        panel1.add(textFieldCommand);

        add(panel1, BorderLayout.NORTH);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(textField.getText().equals("На ноль делить нельзя")){
            textFieldCommand.setText("");
            textField.setText("0");
        }

        String command = ((JButton) e.getSource()).getText();

        double textC = Double.parseDouble(textField.getText());

        if (command.equals("/") || command.equals("*") || command.equals("+") || command.equals("-") || command.equals("=") || command.equals("C")) {
            switch (command) {
                case "/":
                case "*":
                case "+":
                case "-":
                    textFieldCommand.setText(command);
                    savedC = textC;
                    textField.setText("0");
                    break;
                case "=":
                    textField.setText(operation(textFieldCommand.getText(), textC));
                    break;
                case "C":
                    textFieldCommand.setText("");
                    textField.setText("0");
                    break;
            }

            if(textField.getText().endsWith(".0")){
                textField.setText(textField.getText().replace(".0",""));
            }

            return;
        }

        int c = Integer.parseInt(command);


        textC = textC * 10 + c;

        textField.setText(textC + "");

        if(textField.getText().endsWith(".0")){
            textField.setText(textField.getText().replace(".0",""));
        }


    }

    private String operation(String command, double textC){
        double result = 0;
        switch (command) {
            case "/":
                if(textC == 0){
                    return "На ноль делить нельзя";
                }
                result = savedC / textC;
                break;
            case "*":
                result = savedC * textC;
                break;
            case "+":
                result = savedC + textC;
                break;
            case "-":
                result = savedC - textC;
                break;
        }

        return result + "";
    }
}
