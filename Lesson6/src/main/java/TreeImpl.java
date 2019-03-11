import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    protected Node<E> rootNode;
    int MAX_DEPTH ;
    int CURRENT_DEPTH;

    public TreeImpl(int MAX_DEPTH) {
        this.MAX_DEPTH = MAX_DEPTH;
    }







    public void add(E value) {

        Node<E> newNode = new Node<>(value);
        if (isEmpty()){
            rootNode = newNode;
            return;
        }
        Node<E> current = rootNode;
        Node<E> previous = null;
        CURRENT_DEPTH = 1;

        while (current != null) {

            previous=current;
            if (++CURRENT_DEPTH == MAX_DEPTH) break;
            if ( current.shouldBeLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }


            if (previous.shouldBeLeftChild(value)) {
                previous.setLeftChild(newNode);
            } else {
                previous.setRightChild(newNode);
            }


    }




    public boolean delete(E value) {

        //Поиск удаляемого элемента и его родителя
        Node<E> current = rootNode;
        Node<E> parent = null;
        while (current != null) {
            if (current.getValue().equals(value)) {
                break;
            }
            parent = current;

            if (current.shouldBeLeftChild(value)) {
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
        }

        if (current == null) {//Нет удаляемого элемента
            return false;
        }

        if (isLeaf(current)) {
            if (current == rootNode) {
                rootNode = null;
            }
            else if (parent.getLeftChild() != null && parent.getLeftChild().equals(current)) {
                parent.setLeftChild(null);
            }
            else {
                parent.setRightChild(null);
            }
        }
        else if (hasOnlySingleChildElement(current)) {
            Node<E> childNode = current.getLeftChild() != null
                    ? current.getLeftChild()
                    : current.getRightChild();

            if (current == rootNode) {
                rootNode = childNode;
            }
            else if (parent.getLeftChild() != null && parent.getLeftChild().equals(current)) {
                parent.setLeftChild(childNode);
            }
            else {
                parent.setRightChild(childNode);
            }
        }
        else {
            Node<E> successor = getSuccessor(current);
            if (current == rootNode) {
                rootNode = successor;
            }
            else if (parent.getLeftChild() != null && parent.getLeftChild().equals(current)) {
                parent.setLeftChild(successor);
            }
            else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }

        return false;
    }


    private Node<E> getSuccessor(Node<E> removedNode){
        Node<E> successor = removedNode;
        Node<E> successorParent=null;
        Node<E> current = removedNode.getRightChild();

        while (current != null){
            successorParent=successor;
            successor= current;
            current = current.getLeftChild();

        }

        if(successor!= removedNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }
        return successor;


    }

    private boolean hasOnlySingleChildElement(Node<E> current) {
        return current.getLeftChild()==null || current.getRightChild() == null;
    }

    private boolean isLeaf(Node<E> current) {
        return current.getLeftChild()==null && current.getRightChild() == null;
    }

    public boolean find(E value) {
        Node<E> current = rootNode;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }

            if (current.shouldBeLeftChild(value)){
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
        }

            return false;
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(rootNode);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }




    @Override
    public void traverse(TraverseMode traverseMode) {
        switch (traverseMode){
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
                default:
                    throw new IllegalArgumentException("Unknown traverse mode "+ traverseMode);

        }

    }

    private void inOrder(Node<E> node){
        if (node == null)
            return;

        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<E> node){

        System.out.println(node);
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());

    }

    private void postOrder(Node<E> node){
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node);

    }
}
