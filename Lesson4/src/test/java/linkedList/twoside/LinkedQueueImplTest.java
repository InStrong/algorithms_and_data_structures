package linkedList.twoside;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueImplTest {

    private TwoSidedLinkedList<Integer> data;

    @Test
    public void insert() {
        LinkedQueueImpl<Integer> linkedList = new LinkedQueueImpl<>();
        linkedList.insert(4);
        Assert.assertThat(linkedList.size(),Is.is(1));
        Assert.assertThat(linkedList.peek(),Is.is(4));
    }

    @Test
    public void remove() {
        LinkedQueueImpl<Integer> linkedList = new LinkedQueueImpl<>();
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        Assert.assertThat(linkedList.remove(),Is.is(4));
        Assert.assertThat(linkedList.remove(),Is.is(5));
    }

    @Test
    public void peek() {
        LinkedQueueImpl<Integer> linkedList = new LinkedQueueImpl<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(5);
        Assert.assertThat(linkedList.peek(),Is.is(1));
    }

    @Test
    public void size() {
        LinkedQueueImpl<Integer> linkedList = new LinkedQueueImpl<>();
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(4);
        Assert.assertThat(linkedList.size(),Is.is(3));
    }

    @Test
    public void isEmpty() {
        LinkedQueueImpl<Integer> linkedList = new LinkedQueueImpl<>();
        Assert.assertThat(linkedList.isEmpty(), Is.is(true));
    }
}