package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;

    private static SimpleDateFormat sdfMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat sdfBirthDate = new SimpleDateFormat("dd/MM/yyyy");

    private List<OrderItem> items = new ArrayList<>();

    public List<OrderItem> getClient() {
        return items;
    }

    public Order(){}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
       items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total() {
        Double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order Summary: " + "\n");
        sb.append("Order moment: " + sdfMoment.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName() + " (" + sdfBirthDate.format(client.getBirthDate()) + ")" + " - " + client.getEmail() + "\n");
        sb.append("Order items: \n");

        for (OrderItem c : items) {
            sb.append(c.getProduct().getName() + ", ");
            sb.append(String.format("$ " + "%.2f", c.getProduct().getPrice()) + ", ");
            sb.append("Quantity: " + c.getQuantity() + ", ");
            sb.append("Subtotal: " + String.format("%.2f", c.subTotal()) + "\n");
        }
        sb.append("Total price: $ " + String.format("%.2f", total()));

        return sb.toString();
    }


}