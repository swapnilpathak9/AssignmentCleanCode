import dao.Order;
import dao.Product;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        OrderService orderService = new OrderService();

        //Add product
        Product newProduct = new Product(123, "Computer", 50000);
        orderService.addProduct(newProduct);

        //Placing an order
        List<Integer> Order = new ArrayList<>();
        Order.add(123);
        Order order = new Order(123, Order);
        orderService.placeOrder(order);
        orderService.cancelOrder(123);

        //Get all orders
        List<Order> allOrders = orderService.getAllOrders();
        for (Order newOrder : allOrders) {
            System.out.println("Order: "+newOrder);
        }

        //Get all products
        List<Product> allProducts = orderService.getAllProducts();
        for (Product product : allProducts){
            System.out.println("Product: "+product.getName());
        }
    }
}
