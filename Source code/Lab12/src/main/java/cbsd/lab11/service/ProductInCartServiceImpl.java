package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.ProductInCartDAO;
import cbsd.lab11.entity.Cart;
import cbsd.lab11.entity.Product;
import cbsd.lab11.entity.ProductInCart;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/8/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductInCartServiceImpl implements ProductInCartService {
    @Autowired
    private ProductInCartDAO dao;
    @Override
    @Transactional
    public void addProductInCart(ProductInCart productInCart) {
        dao.addProductInCart(productInCart);
    }

    @Override
    @Transactional
    public void deleteProductInCart(ProductInCart productInCart) {
        dao.deleteProductInCart(productInCart);
    }

    @Override
    @Transactional
    public List<ProductInCart> getProductInCarts() {
        return dao.getProductInCarts();
    }

    @Override
    @Transactional
    public ProductInCart findByPK(Cart cart, Product product) {
        return dao.findByPK(cart, product);
    }
}
