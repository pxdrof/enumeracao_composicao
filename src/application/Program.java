package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter a Client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        System.out.println("Birthdate (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        System.out.println("Enter order Data: ");
        System.out.print("Status: ");
        String status = sc.nextLine();

        Client client = new Client(name, email, birthDate);
        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order?: ");
        int n = sc.nextInt();

        for (int icont = 0; icont < n; icont++){

            System.out.printf("Enter #%d item data: \n", icont+1 );
            sc.nextLine();
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            Double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantityProduct = sc.nextInt();

            Product product = new Product(nameProduct, priceProduct);
            OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);

            order.addItem(orderItem);
        }

        System.out.print(order);

        sc.close();
    }
}
