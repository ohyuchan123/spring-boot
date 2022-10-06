package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//요청은 controller가 받는다
@Controller //동료 선언
public class FirstController {

    @GetMapping("/hi") //URL 요청 연결(필수!!)
    //메소드를 생성 ->이 메소드를 통해서 view templates를 반환 할 수 있게 해줌
    public String nice(Model model){
        model.addAttribute("username","yuchan");
        return "greeting"; //templates 안에 greetings 파일을 찾아서 -> 브라우저로 전송
    }

    @GetMapping("/bye")
    public String goodBye(Model model){
        model.addAttribute("nickname","오유찬");
        return "goodbye";
    }
}
