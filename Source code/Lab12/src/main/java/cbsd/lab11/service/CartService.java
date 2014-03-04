package cbsd.lab11.service;

import cbsd.lab11.entity.Cart;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CartService {
    public void addCart(Cart cart);
    public Cart findById(Long id);
}
