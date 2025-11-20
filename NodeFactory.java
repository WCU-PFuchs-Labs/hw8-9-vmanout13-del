import java.util.Random;

public class NodeFactory {
    private static final char[] OPERATORS = {'+', '-', '*', '/'};

    public static Node randomTree(int maxDepth, Random rand, int numVariables) {
        if (maxDepth == 0) {
            if (rand.nextBoolean()) return new VariableNode(rand.nextInt(numVariables));
            else return new ConstantNode(-10 + 20 * rand.nextDouble());
        } else {
            char op = OPERATORS[rand.nextInt(OPERATORS.length)];
            Node left = randomTree(maxDepth - 1, rand, numVariables);
            Node right = randomTree(maxDepth - 1, rand, numVariables);
            return new OperatorNode(op, left, right);
        }
    }
    public static Node randomTree(int maxDepth, Random rand) {
        return randomTree(maxDepth, rand, 11); // 11 for wine quality data, adjust as needed
    }
}
