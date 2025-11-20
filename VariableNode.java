public class VariableNode extends Node {
    private final int index;

    public VariableNode(int index) { this.index = index; }

    public double eval(double[] x) { return x[index]; }

    public Node clone() { return new VariableNode(index); }

    public String toString() { return "x" + index; }
}
