package cn.alenc._02链表;

/**
 * @Auther: allenc
 * @Date: 2024/7/30 20:45
 * 中等
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class _19_删除链表的倒数第N个结点 {
    public static ListNode3 removeNthFromEnd(ListNode3 head, int n) {
        int size = 0;
        ListNode3 newHead = head;
        while (newHead != null) {
            newHead = newHead.next;
            size++;
        }

        newHead = head;
        int count = size - n;
        while (count > 1) {
            newHead = newHead.next;
            count--;
        }

        if (newHead != null && newHead.next == null) {
            return null;
        }
        if (count == 0) {
            return head.next;
        }
        if (newHead != null && newHead.next != null) {
            newHead.next = newHead.next.next;
            return head;
        }
        return head;
    }

    public static ListNode3 removeNthFromEnd1(ListNode3 head, int n) { // 快慢指针 快指针先走，慢指针后走，如果快指针正好走完，那么慢指针指向的就是要删除元素
        if (n == 0) {
            return head.next;
        }
        ListNode3 newHead = new ListNode3(0, head); // 新建虚拟头节点
        ListNode3 slow = newHead;
        ListNode3 fast = newHead;
        int count = n;
        while (count > 0) { // 这里快指针先走n步
            fast = fast.next;
            count--;
        }

        while (true) {
            if (fast.next == null) { // 如果说快指针的下一位事null，说明慢指针指向的下一位就是要删除的
                slow.next = slow.next.next;
                break;
            } else { // 如果说快指针下一位不是null，那么快指针往前走一位，慢指针也往前走一位
                slow = slow.next;
                fast = fast.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
//        removeNthFromEnd1(new ListNode3(1, new ListNode3(2)), 1);
        removeNthFromEnd1(new ListNode3(1, new ListNode3(2,new ListNode3(3,new ListNode3(4,new ListNode3(5))))), 2);
    }
}

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }
}