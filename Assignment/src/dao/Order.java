package dao;

import java.util.List;

public class Order {
    private int id;
    private List<Integer> productIdList;

    public Order(int id, List<Integer> productIdList) {
        this.id = id;
        this.productIdList = productIdList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductIdList(List<Integer> productIdList) {
        this.productIdList = productIdList;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getProductIdList() {
        return productIdList;
    }
}
