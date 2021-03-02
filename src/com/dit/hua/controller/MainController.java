package com.dit.hua.controller;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import java.security.*;
import java.util.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.authentication.logout.*;
import javax.servlet.http.*;
import org.springframework.security.crypto.password.*;

@Controller
@RequestMapping("/")
public class MainController{
    @Autowired
    PasswordEncoder passwordEncoder;
	@Autowired
    private AuthoritiesDAO authoritiesDAO;
	@Autowired
    private UserDAO userDAO;
	@RequestMapping("/")
    public String home(Model model,Principal principal){
		model.addAttribute("username",principal.getName());
    	return "index";
    }
    @RequestMapping("/login")
    public String showLogin(){
            return "login";
    }
    @PostMapping("/register")
    public String register(HttpServletRequest request,Model model){
	    String username=request.getParameter("usernamer");
	    String passwordr=request.getParameter("passwordr");
	    String passwordc=request.getParameter("passwordc");
	    List<User> users=userDAO.getUserByUsername(username);
        if(passwordr.equals(passwordc)==true&&users.size()==0){
            User user=new User(username,passwordEncoder.encode(passwordr),1);
            userDAO.insertUser(user);
            Authorities authorities=new Authorities(username,"ROLE_USER");
            authoritiesDAO.insertAuthorities(authorities);
            model.addAttribute("result","User has been created!");
        }
        if(users.size()>0)
            model.addAttribute("result","Username exists!");
        return "login";
    }
    @RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
			new SecurityContextLogoutHandler().logout(request,response,authentication);
		return "redirect:login";
    }
}