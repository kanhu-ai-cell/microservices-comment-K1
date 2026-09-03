package com.microservice.comment.service.Impl;

import com.microservice.comment.config.RestTemplateConfig;
import com.microservice.comment.entity.Comment;
import com.microservice.comment.payload.Post;
import com.microservice.comment.repository.CommentRepository;
import com.microservice.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RestTemplateConfig restTemplate;

    @Override
    public Comment saveComment(Comment comment) {
        Post forObject = restTemplate.getRestTemplate().getForObject("http://POST-SERVICE/api/post/" + comment.getPostId(), Post.class);
        if(forObject !=null){

            String commentId = UUID.randomUUID().toString();
            comment.setId(commentId);
            Comment save = commentRepository.save(comment);
            return save;
        }else{
            return null;
        }
    }

    @Override
    public List<Comment> getCommentListByPostId(String postId) {
        List<Comment> byPostId = commentRepository.findByPostId(postId);
        return byPostId;
    }
}
