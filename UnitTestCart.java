import org.junit.Before;
import org.junit.Test;
import timeShop.entity.Cart;
import timeShop.service.CartServiceImpl;

/**
 * Created by athit on 1/3/2557.
 */
import static org.junit.Assert.assertEquals;
public class UnitTestCart {
    Long x = Long.valueOf(1);
    CartServiceImpl cartServiceImpl = null;
    @Before
    public void setUp() throws Exception{
        cartServiceImpl = new CartServiceImpl();
    }
    @Test
    public void testFindById() throws Exception{
        Cart cart = new Cart();
        cart.setItems(5);
        assertEquals(cart.getItems(), cartServiceImpl.findById(x).getItems());
    }
}
