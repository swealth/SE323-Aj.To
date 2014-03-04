package cbsd.lab11.dao;

import cbsd.lab11.entity.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDAO {
    public void addProduct(Product product);
    public void deleteProduct(Product product);
    public List<Product> getProducts();
    public Product findById(Long id);
    public List<Product> searchProducts(String keyword);
}
