import java.util.*;
import java.io.*;

public class TestGeneration {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data file name: ");
        String fileName = sc.nextLine();

        Generation gen = new Generation(500, 3, fileName);

        gen.evalAll();
        System.out.println("Best Tree: " + gen.getTopTen().get(0));

        System.out.print("Top Ten Fitness Values: ");
        ArrayList<GPTree> topTen = gen.getTopTen();
        for (int i = 0; i < topTen.size(); i++) {
            System.out.printf("%.2f", topTen.get(i).getFitness());
            if (i < topTen.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
