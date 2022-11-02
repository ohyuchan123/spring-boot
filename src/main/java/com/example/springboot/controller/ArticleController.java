package com.example.springboot.controller;

import com.example.springboot.Repository.ArticleRepository;
import com.example.springboot.dto.ArticleForm;
import com.example.springboot.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j // 로깅을 위한 롬복 어노테이션
public class ArticleController {

    @Autowired //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    //DB를 저장하는 과정
    @PostMapping("/articles/create")
    //화면에서 던진 데이터를 ArticleForm이라는 파라미터에 넣어줌
    public String createArticle(ArticleForm form){
//        System.out.println(form.toString());
        log.info(form.toString()); //println을 로깅으로 대체
        // 1. Dto를 변환 : Entity!
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info(article.toString()); //println을 로깅으로 대체


        // 2. Repository에게 Entity를 DB안에 저장
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(saved.toString()); //println을 로깅으로 대체

        // 리다이렉트 적용: 생성 후, 브라우저가 해당 URL로 재요청
        return "redirect:/articles/" + saved.getId();
        /*
            처음에는 dto에 정보가 들어갔고
            dto에 들어가 있던 정보가 Entity로 변하였다
            그래서 위에는 ArticleForm이 였지만 변환 후는 Article로 출력이 된다

            이 Article을 Repository에 저장하도록 하였더니 결과에 반환이 되었다
            이 반환된 saved 값을 출력 해보니 id값이 자동으로 추가되서 출력되었다
        */
    }
    @GetMapping("/articles/{id}") // 해당 URL요청을 처리 선언
    public String show(@PathVariable Long id,
                       Model model) { // URL에서 id를 변수로 가져옴
        log.info("id = " + id);
        // 1: id로 데이터를 가져옴!
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2: 가져온 데이터를 모델에 등록!
        model.addAttribute("article", articleEntity);
        // 3: 보여줄 페이지를 설정!
        return "articles/show";
    }


    @GetMapping("/articles")//브라워저 요청
    public String index(Model model){
        // 1: 모든 Article을 가져온다!
        List<Article> articleEntityList = articleRepository.findAll();

        // 2: 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList", articleEntityList);

        // 3: 뷰 페이지를 설정!
        return "articles/index";
    }
}
