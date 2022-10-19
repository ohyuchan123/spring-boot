package com.example.springboot.controller;

import com.example.springboot.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    //화면에서 던진 데이터를 ArticleForm이라는 파라미터에 넣어줌
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        return "";
    }
}
