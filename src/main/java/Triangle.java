import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Triangle {
    private double a;
    private double b;
    private double c;


    public Triangle(double a, double b, double c) throws TriangleException {
        List<Double> sides = new LinkedList<Double>(Arrays.asList(new Double[]{a, b, c}));
        Collections.sort(sides);
        this.a = sides.get(0);
        this.b = sides.get(1);
        this.c = sides.get(2);
        if ((this.a == 0 || this.b == 0 || this.c == 0) || (this.a + this.b <= this.c)) throw new TriangleException();
    }

    public TriangleKind getKind() {
        if (a == b && b == c) return TriangleKind.EQUILATERAL;
        if ((a == b && b != c) || (a == c && b != c) || (a != c && b == c)) return TriangleKind.ISOSCELES;
        if (a != b && b != c) return TriangleKind.SCALENE;

        return null;
    }
}
