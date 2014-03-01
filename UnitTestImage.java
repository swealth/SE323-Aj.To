import org.junit.Before;
import org.junit.Test;
import timeShop.entity.Image;
import timeShop.service.ImageServiceImpl;

/**
 * Created by athit on 1/3/2557.
 */
import static org.junit.Assert.assertEquals;
public class UnitTestImage {
    ImageServiceImpl imageServiceImpl = null;
    Long x = Long.valueOf(1);
    @Before
    public void setUp() throws Exception{
        imageServiceImpl = new ImageServiceImpl();
    }
    @Test
    public void testGetImage() throws Exception{
        Image image = new Image();
        image.setFilename("Aok123456");
        assertEquals(image.getFilename(), imageServiceImpl.get(x).getFilename());
    }
}
