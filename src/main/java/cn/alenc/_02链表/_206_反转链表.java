package cn.alenc._02链表;

/**
 * @Auther: allenc
 * @Date: 2024/7/28 13:10
 * 简单
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class _206_反转链表 {

    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(1, new ListNode1(2, new ListNode1(3, new ListNode1(4, new ListNode1(5)))));
        ListNode1 listNode11 = reverseList(listNode1);
        System.out.println(listNode11);
    }

    public static ListNode1 reverseList(ListNode1 head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode1 temp = head.next.next;
        ListNode1 newHead = head.next;
        head.next = null;
        while (newHead != null) { // 关键点就是这里的转换，temp存储下一个需要改变指针的节点，newHead存储当前需要改变指针的节点，head存储当前需要被指向的节点
            newHead.next = head;
            head = newHead;
            newHead = temp;
            if (temp !=null) {
            temp = temp.next;

            }
        }

        return head;
    }
}
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}
