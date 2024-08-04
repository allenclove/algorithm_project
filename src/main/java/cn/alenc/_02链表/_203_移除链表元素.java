package cn.alenc._02链表;

/**
 * @Auther: allenc
 * @Date: 2024/7/22 21:43
 * 简单
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class _203_移除链表元素 {
    public static ListNode removeElements(ListNode head, int val) { // 这种是暴力解法，感觉有点笨重。 移除头部以及移除中间的节点是不同的规则
        if (head != null && head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }

        while (head != null && head.val == val) {
            head = head.next;
        }


        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode pre = head;
        head = head.next;
        while (head != null && head.next != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }

        if (head != null && head.val == val) {
            pre.next = null;
        }
        return first;
    }
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
//        removeElements(listNode, 7);
//        removeElements(null, 1);
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6)))))));
//        removeElements(listNode1, 6);
//        ListNode listNode2 = new ListNode(1, new ListNode(2));
//        removeElements(listNode2, 1);
        removeElements1(listNode1, 6);
    }

    public static ListNode removeElements1(ListNode head, int val) { // 使用虚拟头节点统一规则
        ListNode listNode = new ListNode(-1, head); // 这里使用一个虚拟节点来指向头节点，也就是说后续直接返回虚拟节点指向的结果就是最后结果
        ListNode curr = listNode; // 最开始这里的curr指向虚拟节点，正好符合下面构造的结构：1. 判断节点的值，该节点前后的值我们都可以获取到
        while (curr.next != null) {
            if (curr.next.val == val) { // 这里要判断下一个的值，因为如果是当前值，我们无法获取到当前值的上一个元素来改变指针
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return listNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
