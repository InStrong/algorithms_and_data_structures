package stack;

public class StringReverser {

    static String reverseMe = "You can't reverse me";

    public static String reverser(String string,Stack<String> stack){
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        for (int i = 0; i < sb.length(); i++) {
            stack.push(sb.substring(i,i+1));
        }
        sb.delete(0,sb.length());
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Stack<String> stack = new StackImplementation<>(reverseMe.length());
        System.out.println(reverser(reverseMe,stack));

    }


}
