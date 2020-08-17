package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.Set;

@Controller
@RequestMapping("/admin/**")
public class AdminViewController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminViewController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/usertable")
    public ModelMap printUserTable() {
        return new ModelMap().addAttribute("userData", userService.getAllUsers());
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/usertable");
        userService.deleteUser(id);
        modelAndView.addObject("userData", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/edituser/{id}")
    public String showEditUserForm(@PathVariable("id") Long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        return "admin/edituser";
    }

    @PostMapping("/edituser/{id}")
    public String editUser(User user, ModelMap modelMap, @RequestParam("roles") Set<String> roles) {
        user.setRoleSet(roleService.getRoleSet(roles));
        userService.updateUser(user);
        modelMap.addAttribute("userData", userService.getAllUsers());
        return "admin/usertable";
    }

    @GetMapping("/signup")
    public String showAdminForm(User user) {
        return "admin/signup";
    }

    @PostMapping("/adduser")
    public String createUser(User user, ModelMap modelMap) {
        user.getRoleSet().add(roleService.getDefaultRole());
        userService.addUser(user);
        modelMap.addAttribute("userData", userService.getAllUsers());
        return "admin/usertable";
    }

}
