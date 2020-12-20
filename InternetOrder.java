package com.company;


import java.util.Arrays;
import java.util.Comparator;

public class InternetOrder implements Order {
    int size=0;
    private ListNode head;
    private ListNode tail;
    private Customer customer;

    @Override
    public boolean add(MenuItem item) {
        ListNode listNode=new ListNode();
        listNode.setValue(item);
        size++;
        if(tail==null){
            head=listNode;
            tail=listNode;
        }else{
            tail.setNext(listNode);
            tail=listNode;
        }
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] itemsNames=new String[size];
        int i=0;
        ListNode temp=head;
        while (temp!=null){
            itemsNames[i]=temp.getValue().getName();
            temp=temp.getNext();
            i++;
        }
        return itemsNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count=0;
        ListNode temp=head;
        while (temp!=null){
            if(head.getValue().getName().equals(itemName)){
                count++;
            }
            temp=temp.getNext();
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        return itemQuantity(itemName.getName());
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] items=new MenuItem[size];
        ListNode temp=new ListNode();
        temp=head;
        int i=0;
        while (temp!=null){
            items[i]=temp.getValue();
            temp=temp.getNext();
            i++;
        }
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        if(head == null)
            return false;

        if (head == tail &&head.getValue().getName().equals(itemName)) {
            head = null;
            tail = null;
            return true;
        }

        if (head.getValue().getName().equals(itemName)) {
            head = head.getNext();
            return true;
        }

        ListNode t = head;
        while (t.getNext() != null) {
            if (t.getNext().getValue().getName().equals(itemName)) {
                if(tail == t.getNext())
                {
                    tail = t;
                }
                t.setNext(t.getNext().getNext());
                return true;
            }
            t = t.getNext();
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        return remove(item.getName());
    }

    @Override
    public int removeAll(String itemName) {
        int count=0;
        while (remove(itemName)){
            count++;
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
       return removeAll(item.getName());
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = getItems();
        Arrays.sort(items,(o1,o2)->{
            if(o1!=null&&o2!=null) return Double.compare(o1.getCost(), o2.getCost());
            return 0;
        });
        return items;
    }

    @Override
    public int costTotal() {
        MenuItem[] items=getItems();
        int sum=0;
        for(MenuItem i:items){
            sum+=i.getCost();
        }
        return sum;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer=customer;
    }

    @Override
    public String toString() {
        return "InternetOrder{" +
                ", customer=" + customer + " order="+Arrays.toString(getItems())+
                '}';
    }
}
