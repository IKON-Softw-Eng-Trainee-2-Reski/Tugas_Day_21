package com.tugas.redis;

import com.tugas.redis.entity.Books;
import com.tugas.redis.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class SpringDataRedisExampleApplication {
    @Autowired
    private BookRepository repo;

    @PostMapping
    public Books save(@RequestBody Books books) {
        return repo.save(books);
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Books findBooks(@PathVariable int id) {
        return repo.findBooksById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
    	return repo.deleteBooks(id);
	}


    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}
