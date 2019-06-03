import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField textField1, textField2, textField3;
    private JFrame frame = new JFrame("Polynomial Operations");
    public JLabel showResult = new JLabel();

    private JButton addition = new JButton("Addition");
    private JButton substract = new JButton("Substract");
    private JButton multiply = new JButton("Multiply");
    private JButton divide = new JButton("Divide");
    private JButton derivation = new JButton("Derivation");
    private JButton integration = new JButton("Integration");

    public GUI() {
        //  frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel poly1 = new JLabel();
        poly1.setText("Enter the first polynomial: ");
        poly1.setFont(new Font("Arial", Font.BOLD, 16));
        poly1.setBounds(10, 10, 300, 30);
        frame.add(poly1);

        textField1 = new JTextField();
        textField1.setBounds(10, 40, 400, 30);
        frame.add(textField1);
        // frame.setVisible(true);

        JLabel poly2 = new JLabel();
        poly2.setText("Enter the second polynomial: ");
        poly2.setFont(new Font("Arial", Font.BOLD, 16));
        poly2.setBounds(10, 90, 300, 30);
        frame.add(poly2);

        textField2 = new JTextField();
        textField2.setBounds(10, 120, 400, 30);
        frame.add(textField2);

        JLabel choose = new JLabel();
        choose.setText("Choose an operation: ");
        choose.setFont(new Font("Arial", Font.BOLD, 16));
        choose.setBounds(10, 150, 300, 30);
        frame.add(choose);

        addition.setBounds(10, 200, 150, 30);
        frame.add(addition);


        substract.setBounds(250, 200, 150, 30);
        frame.add(substract);

        multiply.setBounds(10, 250, 150, 30);
        frame.add(multiply);

        divide.setBounds(250, 250, 150, 30);
        frame.add(divide);

        derivation.setBounds(10, 300, 150, 30);
        frame.add(derivation);

        integration.setBounds(250, 300, 150, 30);
        frame.add(integration);

        JLabel result = new JLabel();
        choose.setText("Result: ");
        choose.setFont(new Font("Arial", Font.BOLD, 16));
        choose.setBounds(10, 350, 300, 30);
        frame.add(result);

        frame.add(showResult);

        frame.setVisible(true);

    }

    public String getPoly1() {

        return textField1.getText();

    }

    public String getPoly2() {
        return textField2.getText();
    }

    public void additionActionListener(final ActionListener actionListener) {
        addition.addActionListener(actionListener);
    }


    public void substractActionListener(final ActionListener actionListener) {
        substract.addActionListener(actionListener);

    }

    public void multiplyActionListener(final ActionListener actionListener) {
        multiply.addActionListener(actionListener);

    }

    public void divideActionListener(final ActionListener actionListener) {
        divide.addActionListener(actionListener);

    }

    public void derivationActionListener(final ActionListener actionListener) {
        derivation.addActionListener(actionListener);

    }

    public void integrationActionListener(final ActionListener actionListener) {
        integration.addActionListener(actionListener);

    }
}