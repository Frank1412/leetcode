package com.bonc.data_structure;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-01-31 21:15
 */
public class PriorityQueue {
    static class Node {
        int value;
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    Node head = null;

    /**
     * 插入Node到对应位置
     * @param value
     * @param priority
     */
    public void push(int value, int priority) {
        if (this.head == null) {
            this.head = new Node(value, priority);
            this.head = null;
        } else {
            Node cur = head;
            while (cur.next!=null && cur.next.priority > priority){
                cur = cur.next;
            }
            Node newNode = new Node(value, priority);
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    /**
     * 返回优先级最高元素 对于优先队列来说，就是头节点
     * @return
     */
    public Node peek(){
        return head;
    }


    public Node pop(){
        if (head!=null){
            Node first = head;
            head = head.next;
            return first;
        } else{
            return head;
        }
    }

    public Boolean isEmpty(){
        return head==null;
    }
}
