package cbsd.lab11.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cbsd.lab11.entity.Cart;
import cbsd.lab11.entity.Product;
import cbsd.lab11.entity.ProductInCart;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/12/13
 * Time: 1:06 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductInCartDAOImpl implements ProductInCartDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addProductInCart(ProductInCart productInCart) {
        sessionFactory.getCurrentSession().saveOrUpdate(productInCart);
    }

    @Override
    public void deleteProductInCart(ProductInCart productInCart) {
        sessionFactory.getCurrentSession().saveOrUpdate(productInCart);
    }

    @Override
    public List<ProductInCart> getProductInCarts() {
        return sessionFactory.getCurrentSession().createQuery("from ProductInCart").list();
    }

    @Override
    public ProductInCart findByPK(Cart cart, Product product) {
        if(cart == null || product == null){
            return null;
        }
        return (ProductInCart) sessionFactory.getCurrentSession().createQuery
                ("from ProductInCart p where p.id = "+ cart.getId() +" and p.product = "+ product +" ").uniqueResult();
    }
}
