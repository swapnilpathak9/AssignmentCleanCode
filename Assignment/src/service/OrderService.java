package service;

import dao.Order;
import dao.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Product> productList;
    private List<Order> orderList;

    public OrderService() {
        this.productList = new ArrayList<>();
        this.orderList = new ArrayList<>();
    }

    public void addProduct(Product product) throws Exception {
        if (product.getPrice() == 0) {
            throw new Exception("Price cannot be zero");
        }
        productList.add(product);
    }

    public void removeProduct(int productId) throws Exception {
        for (Product product : productList) {
            if (product.getId() == productId) {
                productList.remove(product);
            } else {
                throw new Exception("Product not found");
            }
        }
    }

    public void placeOrder(Order order) throws Exception {
        for (int productId : order.getProductIdList()) {
            if (!isProductAvailable(productId)) {
                throw new Exception("Product is not available.");
            }
        }
        orderList.add(order);
    }

    private boolean isProductAvailable(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return true;
            }
        }
        return false;
    }

    public void cancelOrder(int orderId) {
        orderList.removeIf(order -> order.getId() == orderId);
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
