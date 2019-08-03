package calculator_main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;
    private final JButton but[], add, minus, multiply, divide, silverRatio,
            equal, cancel ;
    private final Calculator calc;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};

    public UI() {
        frame = new JFrame("Simple Calculator");
        frame.setResizable(false);
        panel = new JPanel(new FlowLayout());

        text = new JTextArea(2, 25);
        but = new JButton[10];
        /**
         * create a button on calculator
         */
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }

        add = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equal = new JButton("=");
        cancel = new JButton("C");
        silverRatio = new JButton("S");
        calc = new Calculator();
    }

    public void init() {
        frame.setVisible(true);
        frame.setSize(300, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.add(text);
       
        for (int i = 1; i < 10; i++) {
            panel.add(but[i]);
            but[i].addActionListener(this);
        }
        panel.add(but[0]);
        but[0].addActionListener(this);

        panel.add(add);
        panel.add(minus);
        panel.add(multiply);
        panel.add(divide);
        panel.add(equal);
        panel.add(silverRatio);
        panel.add(cancel);
        
        

        add.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        equal.addActionListener(this);
        silverRatio.addActionListener(this);
        cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource(); // The object on which the Event initially occurred

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        if (source == add) {
            print(calc.calculate(Calculator.Operators.add, read()));
        }

        if (source == minus) {
            print(calc.calculate(Calculator.Operators.minus, read()));
        }

        if (source == multiply) {
            print(calc.calculate(Calculator.Operators.multiply, read()));
        }

        if (source == divide) {
            print(calc.calculate(Calculator.Operators.divide, read()));
        }
        if (source == silverRatio) {
            print(calc.calculate(Calculator.Operators.silverRatio, read()));
        }
        if (source == equal) {
            print(calc.calculateEqual(read()));
        }

        if (source == cancel) {
            print(calc.reset());
        }

        text.selectAll();
    }

    public Double read() {
        Double num;
        String str;
        str = text.getText();
        num = Double.valueOf(str);
        System.out.println(num);
        return num;
        
    }

    public void print(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}
