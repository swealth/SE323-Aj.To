package cbsd.lab11.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;


/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/24/13
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Member extends User{
    @NotEmpty(message = "Please input name")
    @Size(min = 4, max = 18, message = "Name must between 4 - 18 characters")
    private String name;
    @NotEmpty(message = "Please input address")
    private String address;
    @OneToOne (fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    private Cart cart;

    public Member() {
    }

    public Member(String username, String password, Image image, String name, String address, Cart cart) {
        super(username, password, image);
        this.name = name;
        this.address = address;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;

        Member member = (Member) o;

        if (address != null ? !address.equals(member.address) : member.address != null) return false;
        if (cart != null ? !cart.equals(member.cart) : member.cart != null) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (cart != null ? cart.hashCode() : 0);
        return result;
    }
}
