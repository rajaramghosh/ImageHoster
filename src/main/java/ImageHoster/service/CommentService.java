/*
 * Copyright (c) 2020.
 */

package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is the service class for creating comment
 *
 * @author Rajaram Ghosh
 * @version 1.0
 */

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    /**
     * This method passes the comment to CommentRepository to store in the Database
     * @param comment comment to be added to the image
     */

    public void createComment(Comment comment) {
        commentRepository.insertCommentIntoDatabase(comment);
    }
}
