import java.util.Random;

public class Maintests {

    public static void main(String[] args) {
        double notBalanced=0;
        double balanced = 0;
        double percentageOfBalanced;

        for (int j = 0; j < 1000000; j++) {
            Tree<Integer> tree = new TreeImpl<>(4);
            for (int i = 0; i < Math.pow(2,((TreeImpl<Integer>) tree).MAX_DEPTH)-1; i++) {
                tree.add(new Random().nextInt(1000000)-500000);
            }
            //tree.display();
            if(isBalanced(((TreeImpl<Integer>) tree).rootNode)){
               balanced++;
            }else notBalanced++;

        }
        percentageOfBalanced=(balanced/(balanced+notBalanced))*100;
        System.out.println(percentageOfBalanced);


        // Получаем, что для глубины 3 - процент сбалансированных 71%
        //               для глубины 4 - процент сбалансированных 36%
        //               для глубины 5 - процент сбалансированных 9%
        //               для глубины 6 - процент сбалансированных 0,6%
        //               для глубины 7 - процент сбалансированных 0,005%
        // Все проверялось на 1млн деревьев и на большом диапазоне входящих данных, чтобы точнее получить результат

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
