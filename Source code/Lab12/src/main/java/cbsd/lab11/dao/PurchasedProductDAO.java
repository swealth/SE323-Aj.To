package cbsd.lab11.dao;

import cbsd.lab11.entity.OrderedLog;
import cbsd.lab11.entity.Product;
import cbsd.lab11.entity.PurchasedProduct;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PurchasedProductDAO {
    public void addPurchasedProduct(PurchasedProduct purchasedProduct);
    public void deletePurchasedProduct(PurchasedProduct purchasedProduct);
    public List<PurchasedProduct> getPurchasedProducts();
    public PurchasedProduct findByPK(OrderedLog log, Product product);
}
