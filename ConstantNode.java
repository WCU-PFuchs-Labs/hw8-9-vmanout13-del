public class ConstantNode extends Node {
    private final double value;

    public ConstantNode(double value) { this.value = value; }

    public double eval(double[] x) { return value; }

    public Node clone() { return new ConstantNode(value); }

    public String toString() { return String.format("%.2f", value); }
}
