package calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RunCalculator extends JFrame implements ActionListener {

    private JLabel number1Label, number2Label, resultLabel;
    private JTextField number1Field, number2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private JMenuBar menuBar;
    private JMenu operationMenu, exitMenu;
    
    

    public RunCalculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new GridLayout(2, 1));
        this.setTitle("Menu Demo");

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        operationMenu = new JMenu("Operation");
        menuBar.add(operationMenu);

        exitMenu = new JMenu("Exit");
        menuBar.add(exitMenu);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(1, 6));

        number1Label = new JLabel("Number 1:");
        number1Field = new JTextField(5);

        number2Label = new JLabel("Number 2:");
        number2Field = new JTextField(5);

        resultLabel = new JLabel("Result:");
        resultField = new JTextField(5);
        resultField.setEditable(false);

        panelTop.add(number1Label);
        panelTop.add(number1Field);
        panelTop.add(number2Label);
        panelTop.add(number2Field);
        panelTop.add(resultLabel);
        panelTop.add(resultField);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 4));

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        panelBottom.add(addButton);
        panelBottom.add(subtractButton);
        panelBottom.add(multiplyButton);
        panelBottom.add(divideButton);

        add(panelTop);
        add(panelBottom);

        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Cannot divide by zero");
                    return;
                }
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }
}
