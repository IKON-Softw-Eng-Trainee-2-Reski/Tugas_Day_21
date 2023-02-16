package com.tugas.redis.respository;

import com.tugas.redis.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    public static final String HASH_KEY = "Books";
    @Autowired
    private RedisTemplate template;

    public Books save(Books books){
        template.opsForHash().put(HASH_KEY,books.getId(),books);
        return books;
    }

    public List<Books> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Books findBooksById(int id){
        return (Books) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteBooks(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "Books deleted !!";
    }
}
