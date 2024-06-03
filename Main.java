import java.util.Random;

class Rational {
    private Integer nominator;
    private Integer denominator;

    public Rational(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }
}

class DivisionByZero extends Exception {
    public DivisionByZero(String message) {
        super(message);
    }
}

public class Main {
    public static Rational[] RationalFactory(Integer n) throws DivisionByZero {
        if (n == 0) {
            throw new DivisionByZero("Denominator cannot be zero");
        }

        Rational[] rationals = new Rational[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            rationals[i] = new Rational(random.nextInt(20) + 1, n);
        }

        return rationals;
    }

    public static void main(String[] args) throws DivisionByZero {
        try {
            Rational[] rationals = RationalFactory(5);
            System.out.println("Rationals with denominator 5:");
            for (Rational rational : rationals) {
                System.out.println(rational);
            }
        } catch (DivisionByZero e) {
            System.err.println(e.getMessage());
        }

        try {
            Rational[] rationals = RationalFactory(0);
            System.out.println("Rationals with denominator 0:");
            for (Rational rational : rationals) {
                System.out.println(rational);
            }
        } catch (DivisionByZero e) {
            System.err.println(e.getMessage());
        }
    }
}
