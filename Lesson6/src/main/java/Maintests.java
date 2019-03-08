import java.util.Random;

public class Maintests {

    public static void main(String[] args) {
        double notBalanced=0;
        double balanced = 0;
        double percentageOfBalanced;

        for (int j = 0; j < 100; j++) {
            Tree<Integer> tree = new TreeImpl<>(4);
            for (int i = 0; i < Math.pow(2,((TreeImpl<Integer>) tree).MAX_DEPTH)-1; i++) {
                tree.add(new Random().nextInt(200)-100);
            }
            //tree.display();
            if(isBalanced(((TreeImpl<Integer>) tree).rootNode)){
               balanced++;
            }else notBalanced++;

        }
        percentageOfBalanced=(balanced/(balanced+notBalanced))*100;
        System.out.println(percentageOfBalanced);



    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }
    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
