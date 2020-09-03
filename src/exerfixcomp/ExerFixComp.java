package exerfixcomp;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ExerFixComp {


    public static void main(String[] args) throws ParseException {
       
        Locale.setDefault (Locale.US);        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        System.out.println("Enter client data:");
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Email:");
        String email = sc.nextLine();
        System.out.print("Birth Date:");
        Date birthDate = sdf.parse(sc.next());
        
        Client client = new Client(name, email, birthDate);
        
              
        System.out.println("Enter Order Data:");
        
        System.out.print("Status:");
        String orderStatus = sc.nextLine();
        System.out.print("How many items to this order?");
        int n = sc.nextInt();
        
        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);
        
        for (int i = 0; i <= n; i++){
        
            System.out.println("Enter item #" + i + " Data:");
            System.out.print("name: ");
            String iName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            
            Product product = new Product (iName, price);            
            OrderItem oItem = new OrderItem (qty, product.price, product);
            
            order.addItem(oItem);
        }            
            
        System.out.println(order);
        
        sc.close();
        
        
    }
    
}
