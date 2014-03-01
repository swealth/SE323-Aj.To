import org.junit.Before;
import org.junit.Test;
import timeShop.entity.Product;
import timeShop.service.ProductServiceImpl;

/**
 * Created by athit on 2/3/2557.
 */
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class UnitTestProduct {
    ProductServiceImpl productServiceImpl = null;
    @Before
    public void setUp() throws Exception{
        productServiceImpl = new ProductServiceImpl();
    }
    @Test
    public void testGetProducts() throws Exception{
        assertEquals(5, productServiceImpl.getProducts().size());
    }
    @Test
    public void testSearchProduct() throws Exception{
        assertEquals(1, productServiceImpl.searchProducts("Egg").size());
    }
}
