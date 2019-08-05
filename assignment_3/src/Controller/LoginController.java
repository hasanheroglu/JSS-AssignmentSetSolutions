package Controller;

import Model.DAO.User;
import Model.Service.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp){
        ModelAndView mv = new ModelAndView();

        if(userExists(req)){
            mv.setViewName("welcome.jsp");
            mv.addObject("username", req.getParameter("username"));
        } else{
            mv.setViewName("login-error.jsp");
        }

        return mv;
    }

    private boolean userExists(HttpServletRequest req){

        boolean exists = false;
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = HibernateUtil.<User,String>search(User.class, username);

        if(user == null){
            System.out.println("Username does not exist");
        } else{
            if(password.equals(user.getPassword())){
                exists = true;
            }
        }

        return exists;
    }
}
