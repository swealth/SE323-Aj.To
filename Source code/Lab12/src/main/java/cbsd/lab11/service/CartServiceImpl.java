package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cbsd.lab11.dao.CartDAO;
import cbsd.lab11.entity.Cart;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartDAO cartDAO;
    @Override
    public void addCart(Cart cart) {
        cartDAO.addCart(cart);
    }

    @Override
    public Cart findById(Long id) {
        return cartDAO.findById(id);
    }
}
