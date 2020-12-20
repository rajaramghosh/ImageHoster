package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The is the Model for Comment
 *
 * * @author  Rajaram Ghosh
 * * @version 1.0
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="text")
    private String text;

    @Column(name="created_at")
    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="image_id")
    private Image image;

    /**
     * Non Parameterized Constructor
     */
    public Comment() {
    }

    /**
     * Parameterized Constructor
     *
     * @param text Comment Message
     * @param createdDate Current Data
     * @param user User who created the comment
     * @param image Image for which the comment is created
     */
    public Comment(String text, LocalDate createdDate, User user, Image image) {
        this.text = text;
        this.createdDate = createdDate;
        this.user = user;
        this.image = image;
    }

    /**
     * @return Comment ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id Comment ID to be Set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Comment Message
     */
    public String getText() {
        return text;
    }

    /**
     * @param text Set the Comment Message
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return Date on which Comment is Created
     */
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate Set Date on which Comment is Created
     */
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return User who Created the Comment
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user Set the User who Created the Comment
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return Image Details on which the Comment is Created
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image Set Image Details on which the Comment is Created
     */
    public void setImage(Image image) {
        this.image = image;
    }
}