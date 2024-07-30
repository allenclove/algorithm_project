package cn.alenc.链表;

/**
 * @Auther: allenc
 * @Date: 2024/7/30 20:45
 * 中等
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
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
        while (count>1) {
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

    public static void main(String[] args) {
        removeNthFromEnd(new ListNode3(1,new ListNode3(2)), 2);
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