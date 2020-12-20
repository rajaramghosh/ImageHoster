/*
 * Copyright (c) 2020.
 */

package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

/**
 * This is the Repository Class for handling comment
 *
 * @author Rajaram Ghosh
 * @version 1.0
 */

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    /**
     * This method insert the comment in the database
     *
     * @param comment the comment that need to be stored
     * @return the comment that hae been stored
     */

    public Comment insertCommentIntoDatabase(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }
}
