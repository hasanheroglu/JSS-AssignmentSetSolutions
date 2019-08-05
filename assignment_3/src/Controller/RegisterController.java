package Controller;

import Model.DAO.User;
import Model.Service.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@Controller
@ControllerAdvice
public class RegisterController{



    @RequestMapping(value = "/user-form", method = RequestMethod.GET)
    public ModelAndView getUserForm(Model model){
        return new ModelAndView("register.jsp", "user", new User());
    }



    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") User user, BindingResult result, ModelMap model){

        System.out.println(user.getSex());
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());


        if(result.hasErrors()){
            return new ModelAndView("login.jsp");
        }

        HibernateUtil.add(user);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("successful-register.jsp");

        return mv;
    }

    @RequestMapping("check_uniqueness")
    public void checkUniqueness(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        User user = HibernateUtil.search(User.class, username);
        if(user != null){
            try{
                resp.getWriter().write("yes");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
