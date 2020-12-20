package com.company;

public class QueueNode {
    private QueueNode next;
    private QueueNode prev;
    private Order value;

    QueueNode(Order value){
        this.value=value;
    }
    public void setNext(QueueNode next) {
        this.next = next;
    }

    public void setPrev(QueueNode prev) {
        this.prev = prev;
    }

    public Order getValue() {
        return value;
    }

    public QueueNode getNext() {
        return next;
    }

    public QueueNode getPrev() {
        return prev;
    }
}
