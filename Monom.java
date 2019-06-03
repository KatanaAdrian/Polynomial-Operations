public class Monom {

    private float coeff;
    private int exp;

    public Monom(float coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
    }

    public float getCoeff() {
        return this.coeff;
    }

    public int getExp() {
        return this.exp;
    }

    public void setCoeff(float coeff) {
        this.coeff = coeff;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Monom monomAdd(Monom m) {

        Monom x = new Monom(0, 0);
        x.coeff = this.coeff + m.coeff;
        x.exp = this.exp;
        return x;
    }

    public Monom monomSubstract(Monom m) {

        Monom x = new Monom(0, 0);
        x.coeff = this.coeff - m.coeff;
        x.exp = this.exp;
        return x;
    }

    public Monom monomMultiply(Monom m) {

        Monom x = new Monom(0, 0);
        x.coeff = this.coeff * m.coeff;
        x.exp = this.exp + m.exp;
        return x;
    }

    public Monom monomDivide(Monom m) {

        Monom x = new Monom(0, 0);
        x.coeff = this.coeff / m.coeff;
        x.exp = this.exp - m.exp;
        return x;
    }

    public Monom monomDerivation() {

        Monom x = new Monom(0, 0);
        x.coeff = this.coeff * this.exp;
        x.exp = this.exp - 1;
        return x;
    }

    public Monom monomIntegration() {

        Monom x = new Monom(0, 0);
        x.coeff = this.coeff / (this.exp + 1);
        x.exp = (this.exp + 1);
        return x;
    }

    public String toString() {
        String s = "";
        s = s + coeff + "x^" + exp;
        return s;
    }
}



