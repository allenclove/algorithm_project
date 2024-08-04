package cn.alenc._02链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: allenc
 * @Date: 2024/7/31 20:59
 * 简单
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 * 提示：
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 *
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 */
public class 面试题02_07_链表相交 {
    /**
     * 以下这种方法过于巧妙，基本想不出来
     * 方法二直接简单理解为：
     * 如链表A+链表B=链表C1
     * 链表B+链表A=链表C2
     * A -> a1 a2 c1 c2 c3
     * B -> b1 b2 b3 c1 c2 c3
     * C1 -> a1 a2 c1 c2 c3 b1 b2 b3 c1 c2 c3
     * C2 -> b1 b2 b3 c1 c2 c3 a1 a2 c1 c2 c3v
     */
    public static ListNode4 getIntersectionNode(ListNode4 headA, ListNode4 headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode4 a = headA;
        ListNode4 b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    /**
     * 这个题目不是比对具体数值是否相等，而是地址值
     */
    public static ListNode4 getIntersectionNode1(ListNode4 headA, ListNode4 headB) {
        Set<ListNode4> set = new HashSet<>();
        ListNode4 temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // 常规的方法就是，算出两个链表各自的长度，然后从短的长度开始一起遍历，直到找到相等地址值的节点，进行返回
    public static void main(String[] args) {

    }
}

class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4(int x) {
        val = x;
        next = null;
    }
}
