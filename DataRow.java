package tabular;  // Must be in the tabular folder with this package name

public class DataRow {
    private final double y;
    private final double[] x;

    public DataRow(double y, double[] x) {
        this.y = y;
        this.x = x.clone();
    }

    public double getY() { return y; }
    public double[] getX() { return x.clone(); }
}
