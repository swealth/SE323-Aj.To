package cbsd.lab11.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class PurchasedProduct implements Serializable {
    @Id
    @JoinColumn (referencedColumnName = "id", table = "OrderedLog")
    private Long OrderedLogId;
    @Id
    @OneToOne (fetch = FetchType.EAGER,orphanRemoval = true)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private Product product;
    private Integer amount;

    public PurchasedProduct() {
    }

    public PurchasedProduct(Long orderedLogId, Product product, Integer amount) {
        OrderedLogId = orderedLogId;
        this.product = product;
        this.amount = amount;
    }

    public Long getOrderedLogId() {
        return OrderedLogId;
    }

    public void setOrderedLogId(Long orderedLogId) {
        OrderedLogId = orderedLogId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchasedProduct)) return false;

        PurchasedProduct that = (PurchasedProduct) o;

        if (OrderedLogId != null ? !OrderedLogId.equals(that.OrderedLogId) : that.OrderedLogId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = OrderedLogId != null ? OrderedLogId.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
