package com.company;

import java.util.Arrays;

public class TableOrder implements Order {
    private Customer customer;
    private int size=0;
    private MenuItem[] items=new MenuItem[10];
    @Override
    public boolean add(MenuItem item) {
        if(size<10) {
            items[size] = item;
            size++;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String[] itemsNames() {
        String[] itemsNames=new String[items.length];
        for(int i=0;i<items.length;i++) {
            itemsNames[i]=items[i].getName();
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
        for(MenuItem i:items){
            if(i!=null){
                if(i.getName().equals(itemName)){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        return itemQuantity(itemName.getName());
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        boolean flag=false;
        for(int i=0;i<items.length;i++){
            if(items[i].getName().equals(itemName)){
                items[i]=null;
                flag=true;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean remove(MenuItem item) {
        return remove(item.getName());
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                items[i] = null;
                count++;
            }
        }
        MenuItem[] newItems = new MenuItem[items.length];
        int index = 0;
        for (MenuItem item : items) {
            if (item != null) {
                newItems[index] = item;
                index++;
            }
        }
        items = newItems;
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        return removeAll(item.getName());
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        Arrays.sort(items,(o1,o2)->{
            if(o1!=null&&o2!=null) return Double.compare(o1.getCost(), o2.getCost());
            return 0;
        });
        return items;
    }

    @Override
    public int costTotal() {
        int sum=0;
        for(MenuItem i:items){
            if(i!=null) sum+=i.getCost();
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
        return "TableOrder{" +
                "customer=" + customer +
                ", size=" + size +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
