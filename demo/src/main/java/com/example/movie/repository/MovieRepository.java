package com.example.movie.repository;

import com.example.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie , Integer>{

    @Query(value = "SELECT * FROM moviesproject WHERE LOWER(title) LIKE LOWER(CONCAT('%':title'%')", nativeQuery = true)
     List<Movie> findByTitle(String title);

    @Query(value = "SELECT * FROM moviesproject WHERE LOWER(genre) LIKE LOWER(CONCAT('%':genre'%')", nativeQuery = true)
     List<Movie> findByGenre(String genre);

    Page<Movie> findAll(Pageable pageable);
}
