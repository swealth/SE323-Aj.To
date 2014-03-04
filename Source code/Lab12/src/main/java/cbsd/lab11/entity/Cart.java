package cbsd.lab11.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/24/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @Cascade({CascadeType.ALL})
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<ProductInCart> products = new HashSet<ProductInCart>();
    private int items = 0;
    private BigDecimal total = BigDecimal.valueOf(0);

    public Cart() {
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cart(Set<ProductInCart> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductInCart> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductInCart> products) {
        this.products = products;
        BigDecimal sum = new BigDecimal(0);
        int count = 0;
        if(products.isEmpty() || products == null){
            this.items = count;
            this.total = sum;
        } else {
            for(ProductInCart productInCart:products){
                count = count + productInCart.getAmount();
                sum = sum.add(productInCart.getTotal());
            }
            this.items = count;
            this.total = sum;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (items != cart.items) return false;
        if (id != null ? !id.equals(cart.id) : cart.id != null) return false;
        if (products != null ? !products.equals(cart.products) : cart.products != null) return false;
        if (total != null ? !total.equals(cart.total) : cart.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + items;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    public ProductInCart getProductInCart(Product product){
        if(products.isEmpty()){
            return null;
        }
        for(ProductInCart p:products){
            if(p.getProduct().equals(product)){
                return p;
            }
        }
        return null;
    }
}
