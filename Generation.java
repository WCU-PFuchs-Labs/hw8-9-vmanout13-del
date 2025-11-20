import tabular.*;
import java.util.*;

public class Generation {
    private GPTree[] trees;
    private final DataSet dataSet;
    private final int size;

    public Generation(int size, int maxDepth, String fileName) throws Exception {
        this.size = size;
        dataSet = new DataSet(fileName);
        trees = new GPTree[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            Node root = NodeFactory.randomTree(maxDepth, rand, dataSet.get(0).getX().length);
            trees[i] = new GPTree(root);
        }
    }

    public void evalAll() {
        for (GPTree tree : trees) tree.evalFitness(dataSet);
        Arrays.sort(trees);
    }

    public ArrayList<GPTree> getTopTen() {
        evalAll();
        ArrayList<GPTree> topTen = new ArrayList<>();
        for (int i = 0; i < 10 && i < trees.length; i++) topTen.add(trees[i]);
        return topTen;
    }

    public void printBestFitness() {
        evalAll();
        System.out.printf("%.2f\n", trees[0].getFitness());
    }
    public void printBestTree() {
        evalAll();
        System.out.println(trees[0]);
    }
    // evolve() for HW9 goes here if needed
}
