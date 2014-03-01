import org.junit.Before;
import org.junit.Test;
import timeShop.service.MemberServiceImpl;

/**
 * Created by athit on 1/3/2557.
 */
import static org.junit.Assert.assertEquals;
public class UnitTestMember {
    MemberServiceImpl memberService = null;
    @Before
    public void setUp() throws Exception{
        memberService = new MemberServiceImpl();
    }
    @Test
    public void testGetMembers() throws Exception{
        assertEquals(10, memberService.getMembers().size());
    }
    @Test
    public void testFindByName() throws Exception{
        assertEquals("Aok", memberService.findById("Aok"));
    }
    @Test
    public void testSearchByKeyword() throws Exception{
        assertEquals(1, memberService.searchMember("Aok").size());
    }
}
