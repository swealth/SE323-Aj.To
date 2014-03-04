package cbsd.lab11.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.ProductDAO;
import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.*;
import cbsd.lab11.service.MemberService;
import cbsd.lab11.service.OrderedLogService;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/25/13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    OrderedLogService logService;
    @Autowired
    MemberService memberService;

    boolean isLoad = false;

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        //To change body of implemented methods use File | Settings | File Templates.
        if(!isLoad){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setRole(1);

            userDAO.addUser(admin);
            Member member = new Member("qwerty","123456",null,"Qwerty","ChiangMai'",new Cart());
            memberService.addMember(member);

 /*
            Product p = new Product("Ant",null,"Big ant",(BigDecimal.valueOf(400)),2);
            Product p2 = new Product("Bird",null,"Fly bird",(BigDecimal.valueOf(200)),2);
            Product p3 = new Product("Cat",null,"Cute cat",(BigDecimal.valueOf(200)),2);

            productDAO.addProduct(p);
            productDAO.addProduct(p2);
            productDAO.addProduct(p3);

            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            OrderedLog log = null;
            try {
                log = new OrderedLog(format.parse("22/11/2012"),member,null,PaymentMethod.CREDIT_CARD);
            } catch (ParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            logService.addOrderedLog(log);

            PurchasedProduct purchasedProduct = new PurchasedProduct(log.getId(),p,1);
            Set<PurchasedProduct> purchasedProducts = new HashSet<PurchasedProduct>();
            purchasedProducts.add(purchasedProduct);

            log.setProducts(purchasedProducts);
*/
            isLoad = true;
        }
    }
}
