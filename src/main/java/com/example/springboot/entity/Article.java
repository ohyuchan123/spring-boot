package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //DB가 해당 객체를 인식가능
public class Article {

    @Id //대표값을 지정! Like a 주민등록번호
    @GeneratedValue //1,2,3,....자동 생성 어노테이션!
    private Long id; //기본적으로 Entity에는 대표값이 필요하다

    //제목(title) 과 내용(content)를 받았기 때문에 이렇게 선언
    @Column //DB에서 관리하는 테이블이라는 단위에 연결해주는 기능
    private String title;

    @Column
    private String content;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
