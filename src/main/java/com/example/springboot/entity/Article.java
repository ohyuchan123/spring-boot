package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //DB가 해당 객체를 인식가능
@AllArgsConstructor //모든 파라미터를 자동적으로 만들어줌
@NoArgsConstructor   // 디폴트 생성자 추가
@ToString
public class Article {

    @Id //대표값을 지정! Like a 주민등록번호
    @GeneratedValue //1,2,3,....자동 생성 어노테이션!
    private Long id; //기본적으로 Entity에는 대표값이 필요하다

    //제목(title) 과 내용(content)를 받았기 때문에 이렇게 선언
    @Column //DB에서 관리하는 테이블이라는 단위에 연결해주는 기능
    private String title;

    @Column
    private String content;
}
