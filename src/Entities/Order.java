package Entities;

import Entities.enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> item = new ArrayList() {
    };

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

       
    
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

    public Client getClient() {
        return client;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem newItem) {

        item.add(newItem);

    }

    public void removeItem(OrderItem newItem) {

        item.remove(newItem);

    }

    public Double total() {

        double sum = 0;
        for (OrderItem p : item) {

            sum += p.subTotal();

        }

        return sum;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Order Sumary \n");
        sb.append("Order Moment: ");
        sb.append(moment);
        sb.append(sdf.format(moment) + "\n");
        sb.append("OrderStatus \n");
        sb.append(status + "\n");
        sb.append("Client:");
        sb.append(client.toString() + "\n");
        sb.append("Order Itens: \n");
        sb.append("");
        for (OrderItem i : item) {

            sb.append(i.toString() + "\n");
        }
        return sb.toString();

    }

}
