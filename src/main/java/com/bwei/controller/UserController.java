package com.bwei.controller;

import com.bwei.bean.User;
import com.bwei.repository.UserRepos;
import com.bwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 染熙 on 2017/7/28.
 */
@Controller
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepos userRepos;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/findUserByUsername")
    public void findUserByUsername(String username, HttpServletResponse response) throws IOException {
        int i = userService.findUserByUsername(username);
        PrintWriter writer = response.getWriter();
        writer.println(i);
        writer.flush();
        writer.close();
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        List<User> users = userService.loginUser(username,password);
        if(users!=null&&users.size()>0){
            return "redirect:list";
        }
        String str="登录失败";
        session.setAttribute("str",str);
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        userRepos.save(user);
        return "index";
    }

    @RequestMapping("/list")
    public String findAll(Model model){
        List<User> all = userRepos.findAll();
        model.addAttribute("all",all);
        return "list";
    }

    @RequestMapping("/delete")
    public String deleteUser(int id){
        userRepos.delete(id);
        return "redirect:list";
    }

    @GetMapping("/dc")
    public String dc(){
        String services ="Service:" + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
