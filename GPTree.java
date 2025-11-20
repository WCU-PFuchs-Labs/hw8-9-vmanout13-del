import tabular.*;
import java.util.*;

public class GPTree implements Comparable<GPTree>, Cloneable {
    private Node root;
    private double fitness;

    public GPTree(Node root) {
        this.root = root;
        this.fitness = Double.POSITIVE_INFINITY;
    }

    public void evalFitness(DataSet dataSet) {
        double sum = 0.0;
        for (DataRow row : dataSet.getRows()) {
            double predicted = root.eval(row.getX());
            double error = predicted - row.getY();
            sum += error * error;
        }
        this.fitness = sum;
    }

    public double getFitness() { return fitness; }
    public Node getRoot() { return root; }

    public int compareTo(GPTree t) { return Double.compare(this.fitness, t.fitness); }
    public boolean equals(Object o) {
        if (o == null || !(o instanceof GPTree)) return false;
        return this.compareTo((GPTree) o) == 0;
    }
    public GPTree clone() { return new GPTree(root.clone()); }
    public String toString() { return root.toString(); }
}
