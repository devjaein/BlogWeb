//package com.fastcampus.jblog.biz.blog;
//
//import com.fastcampus.jblog.persistence.BlogRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BlogDAOJPA implements BlogService {
//
//    @Autowired
//    private BlogRepository blogRepository;
//
//    @Override
//    public void deleteRequest(BlogVO vo) {
//        BlogVO findBlog = blogRepository.findById(vo.getBlogId()).get();
//        findBlog.setStatus(vo.getStatus());
//        blogRepository.save(vo);
//    }
//
//    @Override
//    public void insertBlog(BlogVO vo) {
//        blogRepository.save(vo);
//    }
//
//    @Override
//    public void updateBlog(BlogVO vo) {
//        BlogVO findBlog = blogRepository.findById(vo.getBlogId()).get();
//        findBlog.setTitle(vo.getTitle());
//        findBlog.setTag(vo.getTag());
//        findBlog.setCntDisplayPost(vo.getCntDisplayPost());
//        blogRepository.save(vo);
//    }
//
//    @Override
//    public void deleteBlog(int blogId) {
//        blogRepository.deleteById(blogId);
//    }
//
//    @Override
//    public BlogVO getBlog(BlogVO vo) {
//        return blogRepository.findById(vo.getBlogId()).get();
//    }
//
//    @Override
//    public List<BlogVO> getBlogList(BlogVO vo) {
//        return (List<BlogVO>) blogRepository.findAll();
//    }
//}
