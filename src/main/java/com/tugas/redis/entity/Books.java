package com.tugas.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Books")
public class Books implements Serializable {
    @Id
    private int id;
    private String isbn;

    private String judul;
    private String penulis;

    private String deskripsi;

    private String kategory;
}
