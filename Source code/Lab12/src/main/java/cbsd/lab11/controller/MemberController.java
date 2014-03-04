package cbsd.lab11.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import cbsd.lab11.entity.*;
import cbsd.lab11.service.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/1/13
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("member")
@SessionAttributes({"productSession","memberSession","userSession"})
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductInCartService productInCartService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ImageService imageService;

    @ModelAttribute("userSession")
    public User getUserSession(){
        return new User();
    }

    @RequestMapping(value = "profile")
    public String getToProfilePage(@ModelAttribute("userSession") User user, ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Member member = memberService.findById(auth.getName());
        if(member == null){
            member = memberService.findById(user.getUsername());
        }
        if(member!=null){
            model.addAttribute("memberSession",member);
        }
        if(user.getUsername() == null){
            user = userService.findByUsername(auth.getName());
        }
        model.addAttribute("userSession",user);
        return "profile";
    }

    @RequestMapping(value = "update/{username}")
    public String updateMember(@PathVariable("username") String username,ModelMap model){
        Member member = memberService.findById(username);
        model.addAttribute("member",member);
        model.addAttribute("memberService",member);
        return "register";
    }

    @RequestMapping(value = "searchKeyword")
    public String getKeyword(@RequestParam("searchfield")String keyword,ModelMap model){
        return "redirect:/member/search/"+keyword;
    }

    @RequestMapping(value = "search/{keyword}")
    public String search(@PathVariable("keyword") String keyword, Model model){
        model.addAttribute("products",productService.searchProducts(keyword));
        return "product";
    }

    @RequestMapping(value = "productList")
    public String showProductList(@ModelAttribute("memberSession")Member member,ModelMap model){
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("memberSession",member);
        return "product";
    }

    @RequestMapping(value = "addToCart/{productId}",method = RequestMethod.GET)
    public String addToCart(@PathVariable("productId") Long id,@ModelAttribute("memberSession") Member member,
                            @RequestParam("amount") int amount, ModelMap model){
        Product product = productService.findById(id);
        if(amount > product.getAmount()){
            model.addAttribute("error","Quality should less than Product's amount");
            return "redirect:/";
        }
        ProductInCart productInCart = new ProductInCart();
        productInCart.setProduct(product);
        productInCart.setAmount(amount);
        productInCart.setId(member.getCart().getId());
        productInCartService.addProductInCart(productInCart);
        Set<ProductInCart> products = new HashSet<ProductInCart>();
        if(member.getCart().getProducts().isEmpty()){
            products.add(productInCart);
            member.getCart().setProducts(products);
        }
        else if(member.getCart().getProducts().contains(productInCart)){
            Cart cart = member.getCart();
            ProductInCart oldProduct = cart.getProductInCart(product);
            products = member.getCart().getProducts();
            products.remove(oldProduct);
            int newAmount = oldProduct.getAmount() + productInCart.getAmount();
            productInCart.setAmount(newAmount);
            productInCartService.addProductInCart(productInCart);
            products.add(productInCart);
            member.getCart().setProducts(products);
        }
        else{
            products = member.getCart().getProducts();
            products.add(productInCart);
            productInCartService.addProductInCart(productInCart);
            member.getCart().setProducts(products);
        }
        memberService.addMember(member);
        model.addAttribute("memberSession", member);
        return "cart";
    }

    @RequestMapping(value = "deleteProductInCart/{cartID}", method = RequestMethod.GET)
    public String deleteProductInCart(@PathVariable("cartId") Long cartId,@RequestParam("productId") Long productId,
                                      @ModelAttribute("memberSession") Member member,ModelMap model)
    {
        Cart cart = cartService.findById(cartId);
        Product product = productService.findById(productId);
        ProductInCart productInCart = productInCartService.findByPK(cart,product);
        productInCartService.deleteProductInCart(productInCart);
        memberService.addMember(member);
        model.addAttribute("memberSession",member);
        return "cart";
    }

    @RequestMapping(value = "checkout")
    public String checkOut(@ModelAttribute("memberSession")Member member, ModelMap model){
        model.addAttribute("memberSession",member);
        model.addAttribute("payment",PaymentMethod.values());
        return "checkout";
    }

    @RequestMapping(value = "/image/{id}")
    public String showImage(@PathVariable("id") Long id,
                            HttpServletResponse response){
        try{
            Image image = imageService.get(id);
            if(image != null){
                OutputStream out = response.getOutputStream();
                response.setContentType(image.getContentType());
                IOUtils.copy(new ByteArrayInputStream(image.getContent()), out);
                out.flush();
                out.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "cart")
    public String showCartPage(@ModelAttribute("memberSession")Member member, ModelMap model){
        model.addAttribute("memberSession",member);
        return "cart";
    }
}
