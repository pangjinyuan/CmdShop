import user.User;

import java.util.Date;

public class Order  {
    private User user;
    private  Product product[];
    private  int productAmmount;
    private  float totaPrice;
    private  float finalPay;
    private Date orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public int getProductAmmount() {
        return productAmmount;
    }

    public void setProductAmmount(int productAmmount) {
        this.productAmmount = productAmmount;
    }

    public float getTotaPrice() {
        return totaPrice;
    }

    public void setTotaPrice(float totaPrice) {
        this.totaPrice = totaPrice;
    }

    public float getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(float finalPay) {
        this.finalPay = finalPay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotaPrice() {
    }

    public void setFinalPay() {
    }
}

