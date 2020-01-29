package test.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ds.linkedlist.ListNode;

class ListNodeTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testInsertAtStart() {

        int[] dataSequence = {1, 2, 3};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        ListNode insertNode = ListNode.insertAtStart(node, 9);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "9->1->2->3";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testInsertAtStartForNullNode() {

        ListNode insertNode = ListNode.insertAtStart(null, 9);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "9";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testInsertAtEnd() {

        int[] dataSequence = {1, 2, 3};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        ListNode insertNode = ListNode.insertAtEnd(node, 99);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "1->2->3->99";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testInsertAtEndForNullNode() {

        ListNode insertNode = ListNode.insertAtEnd(null, 99);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "99";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testInsertAtPos() {

        int[] dataSequence = {1, 2, 3};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        ListNode insertNode = ListNode.insertAtPos(node, 99, 2);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "1->2->99->3";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testRemoveOneDuplicate() {

        int[] dataSequence = {1, 2, 3, 3, 4};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        ListNode insertNode = ListNode.removeDuplicates(node);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "1->2->3->4";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testRemoveTwoDuplicates() {

        int[] dataSequence = {1, 2, 3, 3, 4, 4};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        ListNode insertNode = ListNode.removeDuplicates(node);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "1->2->3->4";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testRemoveAllDuplicates() {

        int[] dataSequence = {1, 1, 1, 1};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        ListNode insertNode = ListNode.removeDuplicates(node);

        String linkedListStr = ListNodeTestUtil.linkedListToString(insertNode);

        String expected = "1";

        assertEquals(expected, linkedListStr);
    }

    @Test
    void testKthToLast() {

        int[] dataSequence = {1, 2, 3, 4, 5};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        assertEquals(4, ListNode.kthToLast(node, 2));

        int[] dataSequence1 = {1, 2, 3};

        ListNode node1 = ListNodeTestUtil.arrayToLinkedList(dataSequence1);

        assertEquals(1, ListNode.kthToLast(node1, 3));
    }

    @Test
    void testGetMiddleEle() {

        int[] dataSequence = {1, 2, 3, 4, 5};

        ListNode node = ListNodeTestUtil.arrayToLinkedList(dataSequence);

        assertEquals(3, ListNode.getMiddleEle(node));
    }

    @Test
    void testSumByReverseLists() {

        int[] array1 = {7, 1, 6};

        ListNode numNode1 = ListNodeTestUtil.arrayToLinkedList(array1);

        int[] array2 = {5, 9, 2};

        ListNode numNode2 = ListNodeTestUtil.arrayToLinkedList(array2);

        ListNode result = ListNode.sumListsInReverse(numNode1, numNode2);

        String linkedListStr = ListNodeTestUtil.linkedListToString(result);

        assertEquals("2->1->9", linkedListStr);
    }

    @Test
    void testSumByLists() {

        int[] array1 = {6, 1, 7};

        ListNode numNode1 = ListNodeTestUtil.arrayToLinkedList(array1);

        int[] array2 = {2, 9, 5};

        ListNode numNode2 = ListNodeTestUtil.arrayToLinkedList(array2);

        ListNode result = ListNode.sumLists(numNode1, numNode2);

        String linkedListStr = ListNodeTestUtil.linkedListToString(result);

        System.out.println(linkedListStr);

        assertEquals("9->1->2", linkedListStr);
    }

    @Test
    void testSumByReverseLists2() {

        ListNode numNode1 = ListNodeTestUtil.arrayToLinkedList(new int[]{7,1,6});

        ListNode numNode2 = ListNodeTestUtil.arrayToLinkedList(new int[]{5,9,2});

        ListNode result = ListNode.sumListsInReverse2(numNode1, numNode2);

        String linkedListStr = ListNodeTestUtil.linkedListToString(result);

        assertEquals("2->1->9", linkedListStr);

        //-------- Assertion 2 ----------------//

        ListNode numNode11 = ListNodeTestUtil.arrayToLinkedList(new int[]{9, 9, 9, 9});

        ListNode numNode22 = ListNodeTestUtil.arrayToLinkedList(new int[]{9, 9, 9});

        ListNode result2 = ListNode.sumListsInReverse2(numNode11, numNode22);

        String linkedListStr2 = ListNodeTestUtil.linkedListToString(result2);

        assertEquals("8->9->9->10", linkedListStr2);
    }

    @Test
    void testReverseLinkedList() {
        ListNode node = ListNodeTestUtil.arrayToLinkedList(new int[]{1,2,3,4,5});
        ListNode result = ListNode.reverse(node);
        String linkedListStr = ListNodeTestUtil.linkedListToString(result);
        assertEquals("5->4->3->2->1", linkedListStr);
    }

    @Test
    void testPalindromeToTrue() {
        ListNode node = ListNodeTestUtil.arrayToLinkedList(new int[]{0,1,2,3,2,1,0});
        assertTrue(ListNode.isPalindrome(node));
    }

    @Test
    void testPalindromeToFalse() {
        ListNode node = ListNodeTestUtil.arrayToLinkedList(new int[]{1,2,3});
        assertFalse(ListNode.isPalindrome(node));
    }
}