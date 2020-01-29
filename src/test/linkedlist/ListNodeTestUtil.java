package test.linkedlist;

import ds.linkedlist.ListNode;

class ListNodeTestUtil {

    static String linkedListToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.data);
            if(node.next != null)
                sb.append("->");
            node = node.next;
        }
        return sb.toString();
    }

    static ListNode arrayToLinkedList(int[] array){
        ListNode head = null;
        ListNode tail = null;
        for(int num: array){
            if(head == null){
                ListNode node = new ListNode(num);
                head = node;
                tail = node;
            }
            else{
                ListNode node = new ListNode(num);
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }
}
