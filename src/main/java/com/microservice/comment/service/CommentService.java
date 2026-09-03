package com.microservice.comment.service;

import com.microservice.comment.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    Comment saveComment(Comment comment);

    List<Comment> getCommentListByPostId(String postId);
}
