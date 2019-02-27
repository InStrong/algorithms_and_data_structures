package linkedList;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkStackImplTest {

    @Test
    public void push() {
        LinkStackImpl<Integer> linkedList = new LinkStackImpl<>();
        linkedList.push(5);
        Assert.assertThat(linkedList.peek(), Is.is(5));
    }

    @Test
    public void pop() {
        LinkStackImpl<Integer> linkedList = new LinkStackImpl<>();
        linkedList.push(85);
        Assert.assertThat(linkedList.size(),Is.is(1));
        Assert.assertThat(linkedList.pop(),Is.is(85));
        Assert.assertThat(linkedList.size(),Is.is(0));
    }

    @Test
    public void peek() {
        LinkStackImpl<Integer> linkedList = new LinkStackImpl<>();
        linkedList.push(77);
        Assert.assertThat(linkedList.peek(),Is.is(77));
    }

    @Test
    public void size() {
        LinkStackImpl<Integer> linkedList = new LinkStackImpl<>();
        linkedList.push(77);
        linkedList.push(77);
        linkedList.push(77);
        linkedList.push(77);
        Assert.assertThat(linkedList.size(),Is.is(4));

    }

    @Test
    public void isEmpty() {
        LinkStackImpl<Integer> linkedList = new LinkStackImpl<>();
        Assert.assertThat(linkedList.isEmpty(),Is.is(true));
        linkedList.push(4);
        Assert.assertThat(linkedList.isEmpty(),Is.is(false));
    }
}