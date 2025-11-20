public abstract class Node implements Cloneable {
    public abstract double eval(double[] x);
    public abstract Node clone();
    public abstract String toString();
}
