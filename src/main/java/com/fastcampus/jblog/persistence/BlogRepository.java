package com.fastcampus.jblog.persistence;

import com.fastcampus.jblog.biz.blog.BlogVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogVO, Integer> {
}