package cn.alenc.链表;

/**
 * @Auther: allenc
 * @Date: 2024/7/25 20:49
 * 中等
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 * <p>
 * 示例：
 * 输入
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * 输出
 * [null, null, null, null, 2, null, 3]
 * 解释
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
 * myLinkedList.get(1);              // 返回 2
 * myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
 * myLinkedList.get(1);              // 返回 3
 * <p>
 * 提示：
 * 0 <= index, val <= 1000
 * 请不要使用内置的 LinkedList 库。
 * 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
 */
public class _707_设计链表 {

    public static void main(String[] args) {
        MyLinkedList1 myLinkedList = new MyLinkedList1();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
    }
}

class MyLinkedList {

    Node node;

    public MyLinkedList() {
        node = null;
    }

    public int get(int index) {
        if (this.node == null) {
            return -1;
        }
        Node start = this.node;
        for (int i = 0; i < index; i++) {
            if (start != null) {
                start = start.next;
            } else {
                return -1;
            }
        }
        return start != null ? start.val : -1;
    }

    public void addAtHead(int val) {
        node = new Node(val, this.node);
    }

    public void addAtTail(int val) {
        Node last = this.node;
        while (last != null && last.next != null) {
            last = last.next;
        }
        if (last != null) {
            last.next = new Node(val, null);
        } else {
            this.node = new Node(val, null);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node last = this.node;
        for (int i = 0; i < index - 1; i++) {
            if (last != null) {
                last = last.next;
            }
        }
        if (last != null && last.next != null) {
            Node newNode = new Node(val, last.next);
            last.next = newNode;
        } else if (last != null && last.next == null) {
            last.next = new Node(val, null);
        }
    }

    public void deleteAtIndex(int index) {
        Node last = this.node;
        for (int i = 0; i < index - 1; i++) {
            if (last != null) {
                last = last.next;
            } else {
                return;
            }
        }

        if (index == 0 && this.node != null) {
            this.node = this.node.next;
            return;
        }

        if (last != null && last.next != null) {
            last.next = last.next.next;
        }
    }
}

/**
 * 这里使用了size，方法确实简单很多。这里的在头部添加和在尾部添加其实都可以服用在指定索引位置添加，代码更加简单
 */
class MyLinkedList1 {

    int size = 0;

    Node node = new Node(0, null);

    public MyLinkedList1() {

    }

    public int get(int index) {
        if (index >= this.size) {
            return -1;
        }
        Node temp = this.node;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    public void addAtHead(int val) {
        this.node = new Node(val, this.node);
        this.size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            this.node = new Node(val, null);
            this.size++;
            return;
        }

        Node temp = this.node;
        for (int i = 0; i < this.size - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(val, null);
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }

        if (index == this.size) {
            this.addAtTail(val); // 注意这里调用方法里面已经有加数量了，不需要再自己加
            return; // 还有这种特殊情况处理完成之后需要return
        }

        if (index == 0) {
            this.node = new Node(val, this.node);
            this.size++;
            return;
        }

        Node temp = this.node;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = new Node(val, temp.next);
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= this.size) {
            return;
        }

        if (index == 0) {
            this.node = this.node.next;
            this.size--;
            return;
        }

        Node temp = this.node;
        for (int i = index; i > 1; i--) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        this.size--;
    }
}

class Node {
    int val;

    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
