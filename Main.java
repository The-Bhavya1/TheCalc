import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TheCalc implements ActionListener {
    JFrame frame;
    JTextField textField;
    JTextArea historyArea;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[22];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JButton sqrtButton, powButton, percentButton, factButton;
    JButton sinButton, cosButton, tanButton, lnButton, logButton;
    JButton memClearButton, memRecallButton, memAddButton, memSubButton;
    JButton darkModeButton;
    JPanel panel;
    boolean darkMode = false;

    // Variables for calculations
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    double memory = 0;
    ArrayList<String> history = new ArrayList<>();

    public TheCalc() {
        frame = new JFrame("The Calc - Ultimate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(null);

        // Text Field for input
        textField = new JTextField();
        textField.setBounds(50, 25, 480, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setEditable(false);
        frame.add(textField);

        // History TextArea for previous calculations
        historyArea = new JTextArea();
        historyArea.setBounds(50, 500, 480, 100);
        historyArea.setFont(new Font("Arial", Font.PLAIN, 15));
        historyArea.setEditable(false);
        frame.add(historyArea);

        // Function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        sqrtButton = new JButton("√");
        powButton = new JButton("^");
        percentButton = new JButton("%");
        factButton = new JButton("x!");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        memClearButton = new JButton("MC");
        memRecallButton = new JButton("MR");
        memAddButton = new JButton("M+");
        memSubButton = new JButton("M-");
        darkModeButton = new JButton("Dark Mode");

        // Assign buttons to an array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = sqrtButton;
        functionButtons[9] = powButton;
        functionButtons[10] = percentButton;
        functionButtons[11] = factButton;
        functionButtons[12] = sinButton;
        functionButtons[13] = cosButton;
        functionButtons[14] = tanButton;
        functionButtons[15] = lnButton;
        functionButtons[16] = logButton;
        functionButtons[17] = memClearButton;
        functionButtons[18] = memRecallButton;
        functionButtons[19] = memAddButton;
        functionButtons[20] = memSubButton;
        functionButtons[21] = darkModeButton;

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));
        }

        // Action listeners for function buttons
        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
        }

        darkModeButton.setBounds(50, 620, 120, 30);
        frame.add(darkModeButton);

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 480, 500);
        panel.setLayout(new GridLayout(6, 5, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(sqrtButton);
        panel.add(powButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(percentButton);
        panel.add(factButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(lnButton);
        panel.add(logButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat("."));
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
            addToHistory("√" + num1 + " = " + result);
        }
        if (e.getSource() == powButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if (e.getSource() == percentButton) {
            num1 = Double.parseDouble(textField.getText());
            result = num1 / 100;
            textField.setText(String.valueOf(result));
            addToHistory(num1 + "% = " + result);
        }
        if (e.getSource() == factButton) {
            num1 = Double.parseDouble(textField.getText());
            result = factorial((int) num1);
            textField.setText(String.valueOf(result));
            addToHistory(num1 + "! = " + result);
        }
        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
            addToHistory("sin(" + num1 + ") = " + result);
        }
        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
            addToHistory("cos(" + num1 + ") = " + result);
        }
        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(Math.toRadians(num1));
            textField.setText(String.valueOf(result));
            addToHistory("tan(" + num1 + ") = " + result);
        }
        if (e.getSource() == lnButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.log(num1);
            textField.setText(String.valueOf(result));
            addToHistory("ln(" + num1 + ") = " + result);
        }
        if (e.getSource() == logButton) {
            num1 = Double.parseDouble(textField.getText());
            result = Math.log10(num1);
            textField.setText(String.valueOf(result));
            addToHistory("log(" + num1 + ") = " + result);
        }
        if (e.getSource() == equButton) {
         num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error: Division by zero!");
                        return;
                    }
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            addToHistory(num1 + " " + operator + " " + num2 + " = " + result);
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = ' ';
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
        if (e.getSource() == memClearButton) {
            memory = 0;
            JOptionPane.showMessageDialog(frame, "Memory cleared!");
        }
        if (e.getSource() == memRecallButton) {
            textField.setText(String.valueOf(memory));
        }
        if (e.getSource() == memAddButton) {
            memory += Double.parseDouble(textField.getText());
            JOptionPane.showMessageDialog(frame, "Added to memory: " + memory);
        }
        if (e.getSource() == memSubButton) {
            memory -= Double.parseDouble(textField.getText());
            JOptionPane.showMessageDialog(frame, "Subtracted from memory: " + memory);
        }
        if (e.getSource() == darkModeButton) {
            toggleDarkMode();
        }
    }

    // Function to toggle dark/light mode
    private void toggleDarkMode() {
        darkMode = !darkMode;
        Color backgroundColor = darkMode ? Color.DARK_GRAY : Color.LIGHT_GRAY;
        Color textColor = darkMode ? Color.WHITE : Color.BLACK;

        frame.getContentPane().setBackground(backgroundColor);
        textField.setBackground(backgroundColor);
        textField.setForeground(textColor);
        historyArea.setBackground(backgroundColor);
        historyArea.setForeground(textColor);

        for (JButton button : functionButtons) {
            button.setBackground(backgroundColor);
            button.setForeground(textColor);
        }
        for (JButton button : numberButtons) {
            button.setBackground(backgroundColor);
            button.setForeground(textColor);
        }
    }

    // Function to calculate factorial
    public double factorial(int n) {
        if (n < 0) {
            JOptionPane.showMessageDialog(frame, "Error: Factorial of a negative number!");
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Function to add calculations to the history area
    private void addToHistory(String calculation) {
        if (history.isEmpty()) {
          historyArea.setText(calculation);
        } else {
          history.add(calculation);
        }
        StringBuilder historyText = new StringBuilder();
        for (String entry : history) {
            historyText.append(entry).append("\n");
        }
        historyArea.setText(historyText.toString());
    }

    public static void main(String[] args) {
        new TheCalc();
    }
}
