package cbsd.lab11.controller;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/21/13
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
@SessionAttributes({"productSession","memberSession","userSession"})
public class VisitorController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

    @ModelAttribute("userSession")
    public User getUserSession(){
        return new User();
    }

    @ModelAttribute("memberSession")
    public Member getMemberSession(){
        return new Member();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){

        model.addAttribute("productSession",productService.getProducts());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Member member = memberService.findById(auth.getName());
        User user = userService.findByUsername(auth.getName());
        if(member == null && user == null){
            return "index";
        }
        else if(member != null){
            model.addAttribute("memberSession",member);
            return "index";
        }
        else {
            model.addAttribute("userSession",user);
            return "index";
        }
    }

    @RequestMapping(value = "adminregister")
    public String showAdminRegisterPage(Model model){
        User user = new User();
        user.setRole(1);
        model.addAttribute("user",user);
        return "adminLogin";
    }

    @RequestMapping(value = "addValidAdmin", method = RequestMethod.POST)
    public String addValidAdmin(@Valid User user, BindingResult bindingResult, ModelMap model,
                                 @RequestParam("file")MultipartFile file){
        if(bindingResult.hasErrors()){
            return "adminLogin";
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
                user.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        user.setRole(1);
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "register")
    public String showMemberRegisterPage(Model model){
        model.addAttribute("member",new Member());
        return "register";
    }

    @RequestMapping(value = "addValidMember", method = RequestMethod.POST)
    public String addValidMember(@Valid Member member, BindingResult bindingResult, ModelMap model,
                                 @RequestParam("file")MultipartFile file){
        if(bindingResult.hasErrors()){
            return "register";
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
                member.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Cart cart = new Cart();
        member.setCart(cart);
        memberService.addMember(member);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && userService.findByUsername(auth.getName()) != null && userService.findByUsername(auth.getName()).getRole() == 1)
        {
            return "redirect:/admin/memberlist";
        } else {
            model.addAttribute("userSession",userService.findByUsername(member.getUsername()));
            model.addAttribute("memberSession",member);
            return "redirect:member/profile";
        }
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

    @RequestMapping(value = "image/{id}")
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

    @RequestMapping(value = "denied",method = RequestMethod.GET)
    public String deinedPage(){
        return "index";
    }

    @RequestMapping(value = "productlist")
    public String productList(Model model){

        System.out.println(productService.getProducts().toString());
        model.addAttribute("products", productService.getProducts());
        return "product";
    }
}

