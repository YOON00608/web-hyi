package com.korea.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.korea.test.entity.BookEntity;

@Repository
// JpaRepository<BookEntity, Long> -> 상속 받으면 Repository로 취급한다.
public interface BookRepository extends JpaRepository<BookEntity, Long>  {
	@Query("SELECT b FROM BookEntity b WHERE b.title = ?1")
	List<BookEntity> findByTitle(String title);
	
	@Query("SELECT b FROM BookEntity b WHERE b.category = ?1")
	List<BookEntity> findByCategory(String category);
}
