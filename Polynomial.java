import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private String REGEX = "([+-]?[^-+]+)";
    private static Pattern pattern;
    private static Matcher matcher;

    private ArrayList<Monom> list;

    public Polynomial() {

        this.list = new ArrayList<Monom>();
    }

    public void polySplit(String polynomial) {

        ArrayList<Monom> l = new ArrayList<Monom>();
        float coeff;
        int exp;

        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(polynomial);

        while (matcher.find()) {
            String match;
            String[] array;
            match = matcher.group();
            array = match.split("x");
            coeff = Float.parseFloat(array[0]);
            exp = Integer.parseInt(array[1].substring(1));
            Monom m = new Monom(coeff, exp);
            l.add(m);

        }
        this.list = l;
    }

    private ArrayList<Monom> auxInit(int degree) {
        ArrayList<Monom> auxiliary = new ArrayList<Monom>();
        for (int i = 0; i <= degree; i++) {
            Monom m = new Monom(0, degree - i);
            auxiliary.add(m);
        }
        return auxiliary;
    }

    public Polynomial polySum(Polynomial n) {

        Polynomial sum = new Polynomial();
        ArrayList<Monom> aux = new ArrayList<Monom>();
        int grad = -1;

        if (this.list.get(0).getExp() >= n.list.get(0).getExp()) {
            grad = this.list.get(0).getExp();
        } else {
            grad = n.list.get(0).getExp();
        }

        aux = auxInit(grad);

        int i = 0;
        int j = 0;

        while (i < this.list.size() || j < n.list.size()) {
            if (this.list.get(i).getExp() == n.list.get(j).getExp()) {
                aux.set(grad - this.list.get(i).getExp(), this.list.get(i).monomAdd(n.list.get(j)));
                i++;
                j++;
            } else {
                if (this.list.get(i).getExp() > n.list.get(i).getExp()) {
                    aux.set(grad - this.list.get(i).getExp(), this.list.get(i));
                    i++;
                } else {

                    aux.set(grad - n.list.get(j).getExp(), n.list.get(j));
                    j++;
                }
            }
        }

        sum.list = aux;
        return sum;
    }


    public Polynomial polySubstract(Polynomial n) {

        Polynomial substract = new Polynomial();
        ArrayList<Monom> aux = new ArrayList<Monom>();
        int grad = 0;

        if (this.list.get(0).getExp() > grad) {
            grad = this.list.get(0).getExp();
        }

        if (n.list.get(0).getExp() > grad) {
            grad = n.list.get(0).getExp();
        }

        aux = auxInit(grad);

        int i = 0;
        int j = 0;

        while (i < this.list.size() || j < n.list.size()) {
            if (this.list.get(i).getExp() == n.list.get(j).getExp()) {
                aux.set(grad - this.list.get(i).getExp(), this.list.get(i).monomSubstract(n.list.get(j)));
                i++;
                j++;
            } else {
                if (this.list.get(i).getExp() > n.list.get(i).getExp()) {
                    aux.set(grad - this.list.get(i).getExp(), this.list.get(i));
                    i++;
                } else {

                    aux.set(grad - n.list.get(j).getExp(), n.list.get(j));
                    j++;
                }
            }
        }

        substract.list = aux;

        return substract;
    }

    public Polynomial polyMultiply(Polynomial n) {

        Polynomial multiply = new Polynomial();
        ArrayList<Monom> aux = new ArrayList<Monom>();
        ArrayList<Monom> result = new ArrayList<Monom>();
        int grad = 0;

        grad = this.list.get(0).getExp() + n.list.get(0).getExp();

        aux = auxInit(grad);
        result = auxInit(grad);

        for (int i = 0; i < this.list.size(); i++) {
            for (int j = 0; j < n.list.size(); j++) {
                aux.set(grad - (this.list.get(i).getExp() + n.list.get(j).getExp()), this.list.get(i).monomMultiply(n.list.get(j)));


            }

            for (int k = 0; k < result.size(); k++) {
                result.set(k, aux.get(k).monomAdd(result.get(k)));

            }
            aux.clear();
            aux = auxInit(grad);

        }
        multiply.list = result;
        return multiply;
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.list.size(); i++) {

            if (this.list.get(i).getCoeff() > 0) {
                k = k + "+" + this.list.get(i).getCoeff() + "x^" + this.list.get(i).getExp() + " ";
            }

            if (this.list.get(i).getCoeff() < 0) {
                k = k + this.list.get(i).getCoeff() + "x^" + this.list.get(i).getExp() + " ";
            }
        }
        return k;
    }
}
