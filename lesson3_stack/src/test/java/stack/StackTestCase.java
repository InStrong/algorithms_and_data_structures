package stack;


import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StackTestCase {

    @Test
    public void test_add(){
       Stack<Integer> stack = new StackImplementation<>(5);
       stack.push(1);
       stack.push(2);
       stack.push(3);

        Assert.assertThat(stack.size(), Is.is(3));
        Assert.assertThat(stack.peek(), Is.is(3));

    }
}
