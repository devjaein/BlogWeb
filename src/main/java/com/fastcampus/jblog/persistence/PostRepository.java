package com.fastcampus.jblog.persistence;

import com.fastcampus.jblog.biz.post.PostVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostVO, Integer> {
}
