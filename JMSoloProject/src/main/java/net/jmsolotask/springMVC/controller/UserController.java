package net.jmsolotask.springMVC.controller;


import net.jmsolotask.springMVC.model.Role;
import net.jmsolotask.springMVC.model.User;
import net.jmsolotask.springMVC.service.RoleService;
import net.jmsolotask.springMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(String error, String logout, ModelAndView modelAndView) {
        if (error != null) {
            modelAndView.addObject("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            modelAndView.addObject("message", "Logged out successfully.");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String MainAdminPageGet() {
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView mainAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.addObject("listUser", this.userService.getAllClient());
        modelAndView.addObject("rolesName", roleService.getRoles());
        modelAndView.setViewName("admin-jsp");
        return modelAndView;
    }

    @RequestMapping(value = {"/admin/add"}, method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("user") User user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String add = "a user with the same name already exists";
        Set <Role> roles=new HashSet<>();
        String [] rolesFromForm=request.getParameterValues("userRole");
        for (String role:rolesFromForm) {
            roles.add(roleService.getRoleByName(role));
        }
        if (userService.getUserByUserName(user.getName()) == null) {
            user.setRoles(roles);
            userService.addUser(user);
            add = "User added successfully";
        }

        redirectAttributes.addFlashAttribute("addResult", add);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = "admin/delete", method = RequestMethod.GET)
    public String delete(User user) {
        userService.deleteUser(user.getId());
        return "redirect:/admin";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(Model model, User user) {
        String result = "User not added";
        if (userService.getUserByUserName(user.getName()) == null) {
            Set<Role> roleSet=Collections.singleton(roleService.getRoleById(2));
            user.setRoles(roleSet);
            userService.addUser(user);
            result = "User added successfully";
        }
        model.addAttribute("addResult", result);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration() {
        return "registration";
    }


    @RequestMapping(value = {"/admin/update"}, method = RequestMethod.POST)
    public ModelAndView updatePost(@ModelAttribute("admin/user") User user, HttpServletRequest request) {
        Set<Role> roleSet = Collections.singleton(roleService.getRoleById(Long.valueOf(request.getParameter("role"))));
        user.setRoles(roleSet);
        userService.updateUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value = {"/admin/update"}, method = RequestMethod.GET)
    public ModelAndView updateGet(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = userService.getUserById(userId);
        ModelAndView model = new ModelAndView("update");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();//get logged in username
        model.addAttribute("userName", name);
        return "user-jsp";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName("error");
        return modelAndView;
    }




/*

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(HttpServletRequest request, Model model) {
        final HttpSession session = request.getSession();
        User user = (User) session.getAttribute("getUser");
        model.addAttribute("userName", user.getName());
        return "user-jsp";
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.GET)
    public String updateGet(User user, Model model) {
        User userUpd = userService.getUserById(user.getId());
        model.addAttribute("user", userUpd);
        return "forward:/admin";
    }

    @RequestMapping(value = "admin/update", method = RequestMethod.POST)
    public String updateGet(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userService.updateUser(user);
        redirectAttributes.addFlashAttribute("UpdateResult", "User update successfully");
        return "redirect:/admin";
    }
*/

}
