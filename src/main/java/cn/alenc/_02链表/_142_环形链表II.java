package cn.alenc._02链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: allenc
 * @Date: 2024/8/1 22:11
 * 中等
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 *
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */
public class _142_环形链表II {
    public ListNode5 detectCycle(ListNode5 head) { // 暴力解法，直接将所有节点存下来比较
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode5> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    // 快慢指针比较难理解，需要用数学公式证明，公式以及原理参考：https://www.bilibili.com/video/BV1if4y1d7ob/?vd_source=649be7f412986cf6a6276ee4d949efc0
    public ListNode5 detectCycle1(ListNode5 head) {
        ListNode5 fast = head;
        ListNode5 slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 有环
                ListNode5 index1 = fast;
                ListNode5 index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
class ListNode5 {
    int val;
    ListNode5 next;
    ListNode5(int x) {
        val = x;
        next = null;
    }
}
