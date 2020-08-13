package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
//@RequestMapping("/")
public class UserController {
    // методы, которые будут возвращать наши представления в ответ на запросы
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getHomePage() { return "index"; }
    @GetMapping(value = "/login")
    public String getLoginPage() { return "login"; }

    //домашняя страница
    //Аннотация @RequestMapping позволяет задать адреса методам контроллера, по которым они будут
    //доступны в клиенте (браузер)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView allUsersGet() {
        List<User> users = userService.allUsers();
        ModelAndView model = new ModelAndView();
        model.setViewName("users");
        model.addObject("usersList", users);
        return model;
    }

    //страница редактирования
    //аннотация @PathVariable. Она указывает на то, что данный параметр (int id)
    // получается из адресной строки
    //В методе editPage мы дополнительно передавали атрибут, чтобы потом его изменить
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("editPage"); //"edit" - для отдель.стр
        User user = this.userService.getById(id);
        model.addObject("user", user);
        return model;
    }
    //с помощью аннотации @ModelAttribute мы получаем этот атрибут и можем его изменить
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("redirect:/users"); //model.setViewName""
        userService.edit(user);
        return model; //редирект на /+GET
    }

    //Метод для получения страницы
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView model = new ModelAndView("newPage"); //передаем имя страницы
        model.addObject("user", new User()); //создаем новый объект
        return model;
    }
    //метод для добавления
    //когда на странице добавления мы жмем кнопку отправки данных, делается POST-запрос
    //здесь будет создан новый объект User
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("redirect:/users");
        userService.add(user);
        return model; //редирект на /+GET
    }

    //Переходя по ссылке на главной странице мы делаем GET-запрос
    //метод контроллера для удаления юзера из списка
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView("redirect:/users");
        User user = userService.getById(id);
        userService.delete(user);
        return model; //редирект на /+GET
    }

}

