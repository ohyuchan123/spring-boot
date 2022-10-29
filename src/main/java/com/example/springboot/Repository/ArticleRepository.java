package com.example.springboot.Repository;

import com.example.springboot.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

//CrudRepository를 상속 받음
public interface ArticleRepository extends CrudRepository<Article,Long>{
    @Override
    ArrayList<Article> findAll();
}
