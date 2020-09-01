package cl.inacap.auth.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.inacap.auth.models.User;
import cl.inacap.auth.services.UserService;

@Controller
public class UserController {

	@Autowired
	private  UserService userService;
    
  
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    

    
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
    	
    	User verif=userService.findByEmail(user.getEmail());
    	if(verif!=null) {
    		redirectAttributes.addFlashAttribute("mensaje", "El usuario ya existe");
    		return "redirect:/login";
    	}
    	
    	User u= userService.registerUser(user);	
    	session.setAttribute("id", u.getId());
    	return "redirect:/home";
    	
    
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
          
    	 if(userService.authenticateUser(email, password)) {
    		 User user= userService.findByEmail(email);
    		 session.setAttribute("id", user.getId());
    		 return "redirect:home";
    	 }
    	 
    	 model.addAttribute("mensaje", "CREDENCIALES INCORRECTAS");
         return "loginPage.jsp";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	
    	Long userId = (Long) session.getAttribute("id");
    	
    	
    	///MUY IMPORTANTE
    	if(userId==null) {
    		return "redirect:/login";
    	}
    		
    	User user =userService.findUserById(userId);
    	model.addAttribute("user", user); 	
    	return "homePage.jsp";
    	
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
    	return "redirect:/login";
    }
}
