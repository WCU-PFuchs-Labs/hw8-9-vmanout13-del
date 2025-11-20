public class OperatorNode extends Node {
    private final char operator;
    private final Node left, right;

    public OperatorNode(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public double eval(double[] x) {
        double l = left.eval(x), r = right.eval(x);
        switch (operator) {
            case '+': return l + r;
            case '-': return l - r;
            case '*': return l * r;
            case '/': return r == 0 ? 1 : l / r;
        }
        throw new RuntimeException("Bad operator " + operator);
    }

    public Node clone() {
        return new OperatorNode(operator, left.clone(), right.clone());
    }

    public String toString() {
        return "(" + left + " " + operator + " " + right + ")";
    }
}
