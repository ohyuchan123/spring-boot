package com.example.springboot.dto;

public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    /*
    *  사전적 의미의 override는 기각하다, 중단시키다 라는 의미를 입니다.
    *  그렇기 때문에 오버라이드는 덮어서 쓴다 라는 뜻으로 해석하여 이해했습니다.
    *  오버라이드는 상속 관계에서만 적용되는 특징이기 때문에 부모 클래스에
    *  있는 메소드를 덮고 자식 클래스에서 정의한 것으로 대체한다고 이해하였습니다*/
    public String toString() {
        return "ArticleForm{" +
                "titile='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
