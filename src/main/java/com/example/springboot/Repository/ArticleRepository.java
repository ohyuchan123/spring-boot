package com.example.springboot.Repository;

import com.example.springboot.entity.Article;
import org.springframework.data.repository.CrudRepository;

//CrudRepository를 상속 받음
public interface ArticleRepository extends CrudRepository<Article,Long>{

}
