import org.junit.Before;
import org.junit.Test;
import timeShop.dao.ProductInCartDAOImpl;
import timeShop.entity.Cart;
import timeShop.entity.Product;
import timeShop.entity.ProductInCart;

/**
 * Created by athit on 2/3/2557.
 */
import static org.junit.Assert.assertEquals;
public class UnitTestProductInCart {
    ProductInCartDAOImpl productInCartDAOImpl = null;
    @Before
    public void setUp() throws Exception{
        productInCartDAOImpl = new ProductInCartDAOImpl();
    }
    @Test
    public void testGetProductInCart() throws Exception{
        assertEquals(5, productInCartDAOImpl.getProductInCarts().size());
    }
    @Test
    public void testFindByPK() throws Exception{
        ProductInCart productInCart = new ProductInCart();
        Cart cart = new Cart();
        Product product = new Product();
        productInCart.setAmount(300);
        assertEquals(productInCart, productInCartDAOImpl.findByPK(cart, product));
    }
}
