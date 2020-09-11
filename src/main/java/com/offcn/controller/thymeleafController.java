package com.offcn.controller;

import com.offcn.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class thymeleafController {

    @RequestMapping("/test")
    public String method(Model model){
        String str="hello thymeleaf！";
        model.addAttribute("name",str);
        return "index";
    }

    //对象
    @RequestMapping("/getUser")
    public String method2(Model model){
        User user=new User();
        user.setId(1);
        user.setName("花花");
        model.addAttribute("user",user);
        Map map=new HashMap();
        map.put("src","1.jpg");
        model.addAttribute("map",map);
        return "index";
    }

    //集合
    @RequestMapping("/list")
    public String method3(Model model){
        User user=new User();
        user.setId(1);
        user.setName("花花");

        User user2=new User();
        user2.setId(2);
        user2.setName("如花");

        User user3=new User();
        user3.setId(3);
        user3.setName("翠花");

        List<User> list=new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        model.addAttribute("list",list);

        //字符串拼接
        model.addAttribute("message","你谁啊你？");

        //条件判断
        model.addAttribute("flag","yes");

        //switch
        model.addAttribute("a",1);
        model.addAttribute("b",2);
        model.addAttribute("c",1);
        return "index";
    }

    @RequestMapping("/fragment")
    public String fragment(){
        return "index1";
    }
}
