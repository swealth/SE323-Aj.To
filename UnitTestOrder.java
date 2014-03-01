import org.junit.Before;
import org.junit.Test;
import timeShop.entity.Member;
import timeShop.entity.OrderedLog;
import timeShop.entity.PaymentMethod;
import timeShop.service.OrderedLogServiceImpl;

/**
 * Created by athit on 1/3/2557.
 */
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class UnitTestOrder {
    OrderedLogServiceImpl orderedLogServiceImpl = null;
    Long x = Long.valueOf(1);
    @Before
    public void setUp() throws Exception{
        orderedLogServiceImpl = new OrderedLogServiceImpl();
    }
    @Test
    public void testGetOrderLogs() throws Exception{
        assertEquals(5, orderedLogServiceImpl.getOrderedLogs().size());
    }
    @Test
    public void testFindById() throws Exception{
        OrderedLog orderedLog = new OrderedLog();
        Member member = new Member();
        member.setName("Aok");
        orderedLog.setMember(member);
        assertEquals(member.getName(), orderedLogServiceImpl.findById(x).getMember().getName());
    }
    @Test
    public void testSearchByUser() throws Exception{
        List<OrderedLog> list = new ArrayList<OrderedLog>();
        OrderedLog orderedLog = new OrderedLog();
        Member member = new Member();
        member.setName("Aok");
        orderedLog.setMember(member);
        list.add(orderedLog);
        assertEquals(list.size(), orderedLogServiceImpl.searchByUser("Aok").size());
    }
    @Test
    public void testSearchByDate() throws Exception{
        List<OrderedLog> list = new ArrayList<OrderedLog>();
        OrderedLog orderedLog = new OrderedLog();
        Date date = new Date();
        orderedLog.setDate(date);
        list.add(orderedLog);
        assertEquals(list.size(), orderedLogServiceImpl.searchByDate(date).size());
    }
}
