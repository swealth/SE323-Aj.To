package cbsd.lab11.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cbsd.lab11.entity.Cart;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CartDAOImpl implements CartDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addCart(Cart cart) {
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
    }

    @Override
    public Cart findById(Long id) {
        return (Cart) sessionFactory.getCurrentSession().get(Cart.class,id);
    }
}
