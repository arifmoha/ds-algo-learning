package ds.linkedlist;

import java.util.Hashtable;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Integer d) {
        this.data = d;
        this.next = null;
    }

    public static ListNode insertAtStart(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }


    public static ListNode insertAtEnd(ListNode head, int data) {
        if (head == null) {
            return new ListNode(data);
        } else {
            ListNode cn = head;
            while (cn.next != null) {
                cn = cn.next;
            }
            cn.next = new ListNode(data);
        }

        return head;
    }


    public static ListNode insertAtPos(ListNode head, int data, int pos) {
        if (pos == 0) {
            System.out.println("Invalid index");
        }
        if (pos == 1 || head == null) {
            insertAtStart(head, data);
        } else {
            int index = 0;
            ListNode cn = head;
            while (index < pos - 1 && cn.next != null) {
                cn = cn.next;
                index++;
            }

            insert(cn, data);
        }

        return head;
    }

    private static void insert(ListNode node, int data) {
        ListNode insertNode = new ListNode(data);
        ListNode nextNode = node.next;
        node.next = insertNode;
        insertNode.next = nextNode;
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cn = head;
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        ListNode previous = null;
        while (cn != null) {
            int key = cn.data;
            if (ht.containsKey(key)) {
                previous.next = cn.next;
            } else {
                ht.put(key, key);
                previous = cn;
            }

            cn = cn.next;
        }

        return head;

    }

    public static int kthToLast(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return 0;
        }

        ListNode p = head;
        ListNode pk = head;

        while (pk != null) {
            if (k > 0) {
                pk = pk.next;
                k--;
            } else {
                pk = pk.next;
                p = p.next;
            }

        }

        return p.data;
    }

    public static int getMiddleEle(ListNode head) {
        if (head == null) {
            return -9999;
        } else if (head.next == null) {
            return head.data;
        } else {
            ListNode slowPtr = head;
            ListNode fastPtr = head;

            while (fastPtr != null && fastPtr.next!= null) {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }

            return slowPtr.data;
        }
    }

    public static ListNode sumListsInReverse(ListNode n1, ListNode n2){
        String numStr1 = numInRev(n1);
        String numStr2 = numInRev(n2);

        int sum = Integer.parseInt(numStr1) + Integer.parseInt(numStr2);
        return reverseNumToNode(sum);

    }

    public static String numInRev(ListNode n){
        if(n == null){
            return "";
        }
        else{
           String digit = numInRev(n.next);
           return digit + n.data;
        }
    }


    public static ListNode reverseNumToNode(int num){
        ListNode head = null;
        ListNode tail = null;

        int remaining = num;
        while(remaining > 0){
            int mod = remaining % 10;
            remaining = remaining/10;

            if(head == null){
                ListNode n = new ListNode(mod);
                head = n;
                tail = n;
            }

            else{
                ListNode n = new ListNode(mod);
                tail.next = n;
                tail = n;
            }
        }

        return head;
    }

    public static ListNode sumLists(ListNode n1, ListNode n2){
        String numStr1 = nodeToNum(n1);
        String numStr2 = nodeToNum(n2);

        int sum = Integer.parseInt(numStr1) + Integer.parseInt(numStr2);
        return numToNode(sum);
    }

    public static ListNode numToNode(int num){
        ListNode result = null;

        int remaining = num;
        while(remaining > 0){
            int mod = remaining % 10;
            remaining = remaining/10;

            ListNode n = new ListNode(mod);
            n.next = result;
            result = n;
        }

        return result;
    }

    public static String nodeToNum(ListNode n){
        if(n == null){
            return "";
        }
        else{
            String digit = nodeToNum(n.next);
            return n.data + digit;
        }
    }

    public static ListNode sumListsInReverse2(ListNode l1, ListNode l2) {
        return sumListsInRev(l1, l2, 0);
    }

    private static ListNode sumListsInRev(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int value = carry;
        if (l1 != null) value = value + l1.data;
        if (l2 != null) value = value + l2.data;

        int digit = value > 10 ? value % 10 : value;

        ListNode digitNode = new ListNode(digit);

        carry = value > 10 ? 1 : 0;

        if (l1 != null || l2 != null) {
            ListNode l1Next = l1 != null ? l1.next : null;
            ListNode l2Next = l2 != null ? l2.next : null;

            digitNode.next = sumListsInRev(l1Next, l2Next, carry);
        }

        return digitNode;
    }

    private static int length(ListNode node){
        int size = 0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }

    private static ListNode insertZeros(ListNode list, int n){
        ListNode result = list;
        for(int i=1; i <= n; i++){
            ListNode zeroNode = new ListNode(0);
            zeroNode.next = result;
            result = zeroNode;
        }
        return result;
    }

    private static class PartialSum {
        ListNode digit;
        int carry;

        PartialSum(ListNode digit, int carry) {
            this.digit = digit;
            this.carry = carry;
        }
    }

    private static PartialSum sumListsHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum(null, 0);
        }
        PartialSum ps = sumListsHelper(l1.next, l2.next);
        int value = l1.data + l2.data + ps.carry;
        int digit = value > 10 ? value % 10 : value;
        int carry = value > 10 ? 1 : 0;

        ListNode digitNode = new ListNode(digit);
        digitNode.next = ps.digit;
        return new PartialSum(digitNode, carry);
    }


    public static ListNode sumLists2(ListNode l1, ListNode l2) {
        int length1 = length(l1);
        int length2 = length(l2);

        if (length1 > length2) {
            l2 = insertZeros(l2, length1 - length2);
        }

        if (length2 > length1) {
            l1 = insertZeros(l1, length2 - length1);
        }

        PartialSum ps = sumListsHelper(l1, l2);
        return ps.digit;
    }

    public static ListNode reverse(ListNode head){
        ListNode n = head;
        ListNode result = null;
        while(n!=null){
            ListNode next = n.next;
            n.next = result;
            result = n;
            n = next;
        }
        return result;
    }

    public static ListNode reverseByRecurse(ListNode head, ListNode result){
        if(head == null) return result;

        ListNode next = head.next;
        head.next = result;
        result = head;
        return reverseByRecurse(next, result);
    }

    public static boolean isPalindrome(ListNode node){
        ListNode revNode = reverse(node);

        ListNode x = node;
        ListNode y = revNode;

        while(x!=null){
            if(x.data != y.data) return false;
            x = x.next;
            y = y.next;
        }

        return true;
    }
}
