package leetcode;

// 设计循环队列
public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(6);
        boolean en1 = obj.enQueue(6);
        int re1 = obj.Rear();
        int re2 = obj.Rear();
        boolean de1 = obj.deQueue();
        boolean en2 = obj.enQueue(5);
        int re3 = obj.Rear();
        boolean de2 = obj.deQueue();
        int front1 = obj.Front();
        boolean de3 = obj.deQueue();
        boolean de4 = obj.deQueue();
        boolean de5 = obj.deQueue();

        System.out.println("null");
        System.out.println(en1);
        System.out.println(re1);
        System.out.println(re2);
        System.out.println(de1);
        System.out.println(en2);
        System.out.println(re3);
        System.out.println(de2);
        System.out.println(front1);
        System.out.println(de3);
        System.out.println(de4);
        System.out.println(de5);

    }

    // 定义类的成员变量
    private int head = 0;
    private int tail = 0;
    private int k;
    private int[] queue = null;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.k = k;
        queue = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        boolean isfull = isFull();
        if(isfull){
            return !isfull;
        }
        queue[tail%this.k] = value;
        tail ++ ;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        boolean isempty = isEmpty();
        if(isempty){
            return false;
        }
        head ++ ;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        boolean isem = isEmpty();
        if(isem){
            return -1;
        }
        return queue[head%this.k];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        boolean isem = isEmpty();
        if(isem){
            return -1;
        }
        return queue[(tail-1)%this.k];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(head == tail){
            return true;
        }else {
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(head == 0 && tail == 0){
            return false;
        }
        if((Math.abs(tail - head) % this.k == 0) && tail != head){
            return true;
        }else {
            return false;
        }
    }
}
