package cbsd.lab11.service;

import cbsd.lab11.entity.Cart;
import cbsd.lab11.entity.Product;
import cbsd.lab11.entity.ProductInCart;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/8/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductInCartService {
     void addProductInCart(ProductInCart productInCart);
     void deleteProductInCart(ProductInCart productInCart);
     List<ProductInCart> getProductInCarts();
     ProductInCart findByPK(Cart cart, Product product);
}
