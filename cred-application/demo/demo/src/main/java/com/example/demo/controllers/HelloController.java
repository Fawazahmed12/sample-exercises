package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("hello")

public class HelloController {
    @RequestMapping(value="")
    @ResponseBody()
    public String index(){
return "Welcome Vinoth!";
    }
    @RequestMapping(value="thankyou")
    @ResponseBody()
    public String index1(){
        return "Thank You Vinoth! Have A Nice Day!!";
    }
 }

