package cbsd.lab11.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ProductInCart implements Serializable{
    @Id
    @JoinColumn(referencedColumnName = "id",table = "Cart")
    private Long id;
    @Id
    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Product product;
    private int amount = 0;
    private BigDecimal total = new BigDecimal(0);

    public ProductInCart() {
    }

    public ProductInCart(Product product, int amount) {
        this.product = product;
        this.amount = amount;
        this.total = product.getPrice().multiply(BigDecimal.valueOf(amount));
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.total = product.getPrice().multiply(BigDecimal.valueOf(this.amount));
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.total = this.product.getPrice().multiply(BigDecimal.valueOf(amount));
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductInCart)) return false;

        ProductInCart that = (ProductInCart) o;

        if (amount != that.amount) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
