package com.example.Crowdfunding.Comments;
/*
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CommentSansMockitoTest {

    @Test
    public void testCreateComment() {
        // Given
        CommentRepository commentRepository = new CommentRepository();
        CommentService commentService = new CommentService(commentRepository);
        Comment comment = new Comment(1L, "Test Comment", null, null);

        // When
        commentService.createComment(comment);

        // Then
        List<Comment> comments = commentRepository.findAll();
        assertTrue(comments.contains(comment));
    }

    @Test
    public void testGetCommentById() {
        // Given
        CommentRepository commentRepository = new CommentRepository();
        CommentService commentService = new CommentService(commentRepository);
        long commentId = 1L;
        Comment comment = new Comment(commentId, "Test Comment", null, null);
        commentRepository.save(comment);

        // When
        Optional<Comment> retrievedComment = commentService.getCommentById(commentId);

        // Then
        assertTrue(retrievedComment.isPresent());
        assertEquals(commentId, retrievedComment.get().getComment_id());
    }

   @Test
    public void testUpdateComment() {
        // Given
        CommentRepository commentRepository = new CommentRepository();
        CommentService commentService = new CommentService(commentRepository);
        long commentId = 1L;
        Comment existingComment = new Comment(commentId, "Existing Comment", null, null);
        commentRepository.save(existingComment);
        Comment updatedComment = new Comment(commentId, "Updated Comment", null, null);

        // When
        commentService.updateComment(commentId, updatedComment);

        // Then
        Optional<Comment> retrievedComment = commentRepository.findById(commentId);
        assertNotNull(retrievedComment);
        assertEquals("Updated Comment", retrievedComment.getCommentText());
    }


    @Test
    public void testDeleteComment() {
        // Given
        CommentRepository commentRepository = new CommentRepository();
        CommentService commentService = new CommentService(commentRepository);
        long commentId = 1L;
        Comment comment = new Comment(commentId, "Test Comment", null, null);
        commentRepository.save(comment);

        // When
        commentService.deleteComment(commentId);

        // Then
        Optional<Comment> retrievedComment = commentRepository.findById(commentId);
        assertNull(retrievedComment);
    }
};*/
