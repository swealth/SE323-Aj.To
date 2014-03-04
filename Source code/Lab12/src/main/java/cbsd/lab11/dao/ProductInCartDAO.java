package cbsd.lab11.dao;

import cbsd.lab11.entity.Cart;
import cbsd.lab11.entity.Product;
import cbsd.lab11.entity.ProductInCart;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductInCartDAO {
    public void addProductInCart(ProductInCart productInCart);
    public void deleteProductInCart(ProductInCart productInCart);
    public List<ProductInCart> getProductInCarts();
    public ProductInCart findByPK(Cart cart, Product product);
}
