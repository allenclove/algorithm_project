package cn.alenc.链表;

/**
 * @Auther: allenc
 * @Date: 2024/7/29 21:51
 * 中等
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class _24_两两交换链表中的节点 {
    public static ListNode2 swapPairs(ListNode2 head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode2 newHead = new ListNode2(0, head);
        ListNode2 temp;
        ListNode2 pre;
        ListNode2 sHead = newHead;
        while (sHead != null && sHead.next != null && sHead.next.next != null) { // 关键点，使用虚拟节点，简单很多
            temp = sHead.next.next.next;
            pre = sHead.next;
            sHead.next = sHead.next.next;
            sHead.next.next = pre;
            sHead.next.next.next = temp;
            sHead = sHead.next.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        swapPairs(new ListNode2(1,new ListNode2(2,new ListNode2(3,new ListNode2(4)))));
    }
}
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
