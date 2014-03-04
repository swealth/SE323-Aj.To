package cbsd.lab11.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/24/13
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class OrderedLog {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    @OneToOne (fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    private Member member;
    @Cascade({CascadeType.ALL})
    @OneToMany (fetch = FetchType.EAGER)
    @ElementCollection
    private Set<PurchasedProduct> products = new HashSet<PurchasedProduct>();
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public OrderedLog() {
    }

    public OrderedLog(Date date, Member member, Set<PurchasedProduct> products, PaymentMethod paymentMethod) {
        this.date = date;
        this.member = member;
        this.products = products;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Set<PurchasedProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<PurchasedProduct> products) {
        this.products = products;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedLog)) return false;

        OrderedLog that = (OrderedLog) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (paymentMethod != that.paymentMethod) return false;
        if (products != null ? !products.equals(that.products) : that.products != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        return result;
    }
}
