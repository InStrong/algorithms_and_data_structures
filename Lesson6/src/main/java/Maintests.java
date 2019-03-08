public class Maintests {

    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(32);
        tree.add(55);
        tree.display();
        tree.delete(15);
        tree.display();



    }

}
