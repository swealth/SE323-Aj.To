package cbsd.lab11.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cbsd.lab11.entity.OrderedLog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class OrderedLogDAOImpl implements OrderedLogDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrderedLog(OrderedLog orderedLog) {
        sessionFactory.getCurrentSession().saveOrUpdate(orderedLog);
    }

    @Override
    public List<OrderedLog> getOrderedLogs() {
        return sessionFactory.getCurrentSession().createQuery("from OrderedLog").list();
    }

    @Override
    public OrderedLog findById(Long id) {
        return (OrderedLog) sessionFactory.getCurrentSession().get(OrderedLog.class,id);
    }

    @Override
    public List<OrderedLog> searchByUser(String keyword) {
        Set<OrderedLog> expected = new HashSet<OrderedLog>();
        List result = sessionFactory.getCurrentSession().createQuery("from OrderedLog o where lower(o.member.username) like '%"+ keyword.toLowerCase() +"%'").list();
        expected.addAll(result);
        result = sessionFactory.getCurrentSession().createQuery("from OrderedLog o where lower(o.member.name) like '%"+ keyword.toLowerCase() +"%'").list();
        expected.addAll(result);
        return new ArrayList<OrderedLog>(expected);
    }

    @Override
    public List<OrderedLog> searchByDate(Date date) {
        Set<OrderedLog> expected = new HashSet<OrderedLog>();
        DateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List result = sessionFactory.getCurrentSession().createQuery("from OrderedLog o where o.date like '"+ dbDateFormat.format(date) +"%' ").list();
        expected.addAll(result);
        return new ArrayList<OrderedLog>(expected);
    }
}
