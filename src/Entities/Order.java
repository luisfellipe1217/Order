package Entities;

import Entities.enums.OrderStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;
    private List<OrderItem> item = new ArrayList() {
    };

    public Order() {
    }

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItem() {
        return item;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }
        

    public void addItem(OrderItem newItem) {

        item.add(newItem);

    }

    public void removeItem(OrderItem newItem) {

        item.remove(newItem);

    }
    
    public Double total(){
    
        double sum =0;
        for(OrderItem p: item){
            
              sum += p.subTotal();
            
        }  
        
        return sum;
    }

}
