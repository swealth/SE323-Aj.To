package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.ProductDAO;
import cbsd.lab11.entity.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        productDAO.deleteProduct(product);
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Product> searchProducts(String keyword) {
        return productDAO.searchProducts(keyword);
    }
}
