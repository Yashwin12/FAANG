import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        // We need new pointers p1, p2 b/c we want to return headOne or headTwo to be
        // returned at the end. Also if p1 and p2 are not used then the headOne/ headTwo
        // would be at the end of LL.
        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList prev = null;

        while (p1 != null && p2 != null) {
            if (p1.value >= p2.value) {

                if (prev != null) {
                    prev.next = p2;
                }

                prev = p2;
                p2 = p2.next;
                prev.next = p1;

            } else {
                prev = p1;
                p1 = p1.next;
            }

        }

        if (p1 == null && p2 != null) {
            prev.next = p2;
        }

        return headOne.value < headTwo.value ? headOne : headTwo;
    }
}
