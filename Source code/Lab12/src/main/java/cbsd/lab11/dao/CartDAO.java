package cbsd.lab11.dao;

import cbsd.lab11.entity.Cart;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 12:17 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CartDAO {
    public void addCart(Cart cart);
    public Cart findById(Long id);
}
