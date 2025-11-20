package tabular;

import java.io.*;
import java.util.*;

public class DataSet {
    private final ArrayList<DataRow> rows = new ArrayList<>();

    public DataSet(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty() || line.trim().startsWith("y")) continue;
            String[] tokens = line.split(",");
            double y = Double.parseDouble(tokens[0].trim());
            double[] x = new double[tokens.length - 1];
            for (int i = 1; i < tokens.length; i++) {
                x[i - 1] = Double.parseDouble(tokens[i].trim());
            }
            rows.add(new DataRow(y, x));
        }
        reader.close();
    }

    public int size() { return rows.size(); }
    public DataRow get(int i) { return rows.get(i); }
    public List<DataRow> getRows() { return Collections.unmodifiableList(rows); }
}

