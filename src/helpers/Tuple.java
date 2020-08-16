package helpers;

import java.util.StringJoiner;

public class Tuple <A,B> {

    private final A valueA;
    private final B valueB;

    public Tuple(A valueA, B valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    public A getValueA() {
        return valueA;
    }

    public B getValueB() {
        return valueB;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("valueA=" + valueA)
                .add("valueB=" + valueB)
                .toString();
    }
}
