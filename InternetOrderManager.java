package com.company;


public class InternetOrderManager implements OrderManager{

    private QueueNode head;
    private QueueNode tail;
    private int size=0;


    public boolean add(Order order){
        QueueNode temp=new QueueNode(order);
        if(head==null){
            head=temp;
        }else{
            tail.setNext(temp);
        }
        temp.setPrev(tail);
        tail=temp;
        size++;
        return true;
    }

    public void removeFirst(){
        if(head.getNext()==null) tail=null;
        else head.getNext().setPrev(null);
        head=head.getNext();
    }
    public void removeLast(){
        if(head.getNext()==null) head=null;
        else tail.getPrev().setNext(null);
        tail=tail.getPrev();
    }
    public boolean remove(Order order){
        QueueNode temp=tail;
        while (!(temp.getValue()==order)) {
            temp = temp.getPrev();
            if (temp == null) return false;
        }
        if(temp==head) removeFirst();
        else temp.getPrev().setNext(temp.getNext());
        if(temp==tail) removeLast();
        else temp.getNext().setPrev(temp.getPrev());
        size--;
        return true;
    }
    @Override
    public int itemsQuantity(String itemName) {
        int count=0;
        QueueNode temp=head;
        while (temp!=null){
            count+=temp.getValue().itemQuantity(itemName);
            temp=temp.getNext();
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return itemsQuantity(item.getName());
    }

    @Override
    public Order[] getOrders() {
       Order[] orders=new Order[size];
       QueueNode temp=head;
       int i=0;
       while (temp!=null){
           orders[i]=temp.getValue();
           i++;
           temp=temp.getNext();
       }
       return orders;
    }

    @Override
    public int ordersCostSummary() {
        Order[] orders=getOrders();
        int sum=0;
        for(Order i:orders){
            sum+=i.costTotal();
        }
        return sum;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }
}
