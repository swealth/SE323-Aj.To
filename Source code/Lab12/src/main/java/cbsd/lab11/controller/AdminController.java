package cbsd.lab11.controller;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import cbsd.lab11.entity.*;
import cbsd.lab11.service.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/11/13
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes({"userSession","productSession","memberSession"})
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderedLogService orderedLogService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;

    @ModelAttribute("userSession")
    public User getUserSession(){
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public  String adminPage(){
        return "admin";
    }

    @RequestMapping(value = "orderedLogList",method = RequestMethod.GET)
    public String showOrderedLog(@ModelAttribute("userSession") User user, ModelMap model){
        model.addAttribute("orderedLog",orderedLogService.getOrderedLogs());
        model.addAttribute("userSession",user);
        return "OrderedLogList";
    }

    @RequestMapping("searchOrderedLog/{keyword}")
    public String searchOrderedLogByUser(@ModelAttribute("userSession") User user,@PathVariable("keyword")String s,ModelMap model){
        try{
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(s);
            List<OrderedLog> logs = orderedLogService.searchByDate(date);
            model.addAttribute("orderedLog",orderedLogService.searchByDate(date));
            model.addAttribute("userSession",user);
            return "OrderedLogList";
        } catch (Exception e) { }
        model.addAttribute("orderedLog",orderedLogService.searchByUser(s));
        model.addAttribute("userSession",user);
        return "OrderedLogList";
    }

    @RequestMapping(value = "memberlist")
    public String list(Model model){
        model.addAttribute("members", memberService.getMembers());
        return "memberList";
    }

    @RequestMapping(value = "searchMember")
    public String search(Model model){
        model.addAttribute("members", memberService.getMembers());
        return "memberList";
    }

    @RequestMapping(value = "searchMember/{keyword}")
    public String search(@PathVariable("keyword") String keyword, Model model){
        model.addAttribute("products",memberService.searchMember(keyword));
        return "memberList";
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

    @RequestMapping(value = "addProduct")
    public String showMemberRegisterPage(Model model){
        model.addAttribute("product",new Product());
        return "addProduct";
    }

    @RequestMapping(value = "addValidProduct", method = RequestMethod.POST)
    public String addValidMember(@Valid Product product, BindingResult bindingResult, ModelMap model,
                                 @RequestParam("file")MultipartFile file){
        if(bindingResult.hasErrors()){
            return "addProduct";
        }
        //add image
        if(file.getSize() != 0){
            try{
                Image image = new Image();
                image.setFilename(file.getName());
                image.setContentType(file.getContentType());
                ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
                ImageIO.setUseCache(false);
                BufferedImage myImage = ImageIO.read(bis);
                int rectangleSize = 300;
                BufferedImage bi = Scalr.resize(myImage, rectangleSize);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bi,getContentType(image.getContentType()),baos);
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                baos.close();
                image.setContent(imageInByte);
                product.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productService.addProduct(product);
        return "redirect:/admin/productlist";

    }

    private String getContentType(String contentType){
        if (contentType.contains("jpg")){
            return "jpg";
        }else if (contentType.contains("png")){
            return "png";
        }else if (contentType.contains("gif")){
            return "gif";
        }else{
            return "jpg";
        }
    }

    @RequestMapping(value = "productlist")
    public String productList(Model model){
        model.addAttribute("products", productService.getProducts());
        return "product";
    }

    


}
