import java.awt.*;

public class Control {

    GUI control = new GUI();

    public Control() {

        buttonsControl();
    }

    private void buttonsControl() {
        control.additionActionListener(e -> {
            String poly1;
            String poly2;
            String sumResult;

            poly1 = control.getPoly1();
            poly2 = control.getPoly2();

            Polynomial poly = new Polynomial();
            poly.polySplit(poly1);
            Polynomial polyy = new Polynomial();
            polyy.polySplit(poly2);
            Polynomial result = new Polynomial();

            result = poly.polySum(polyy);

            sumResult = result.toString();

            control.showResult.setText(sumResult);
            control.showResult.setBounds(10, 400, 300, 30);
            control.showResult.setFont(new Font("Arial", Font.BOLD, 16));

        });
        control.substractActionListener(e -> {
            String poly1;
            String poly2;
            String subsResult;

            poly1 = control.getPoly1();
            poly2 = control.getPoly2();

            Polynomial poly = new Polynomial();
            poly.polySplit(poly1);
            Polynomial polyy = new Polynomial();
            polyy.polySplit(poly2);
            Polynomial result = new Polynomial();

            result = poly.polySubstract(polyy);

            subsResult = result.toString();

            control.showResult.setText(subsResult);
            control.showResult.setBounds(10, 400, 300, 30);
            control.showResult.setFont(new Font("Arial", Font.BOLD, 16));
        });

        control.multiplyActionListener(e -> {
            String poly1;
            String poly2;
            String multResult;

            poly1 = control.getPoly1();
            poly2 = control.getPoly2();

            Polynomial poly = new Polynomial();
            poly.polySplit(poly1);
            Polynomial polyy = new Polynomial();
            polyy.polySplit(poly2);
            Polynomial result = new Polynomial();

            result = poly.polyMultiply(polyy);

            multResult = result.toString();

            control.showResult.setText(multResult);
            control.showResult.setBounds(10, 400, 600, 30);
            control.showResult.setFont(new Font("Arial", Font.BOLD, 16));
        });
    }
}
