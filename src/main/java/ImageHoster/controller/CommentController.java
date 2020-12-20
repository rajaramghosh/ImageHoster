/*
 * Copyright (c) 2020.
 */

package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller class for handling comment
 *
 * @author Rajaram Ghosh
 * @version 1.0
 */

@Controller
public class CommentController {

    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * This method handles the post request when a comment is submitted, it retrieves the user and image
     * details in addition to the information from the post request and send the query to commentService
     * for further processing
     *
     * @param title title of the image
     * @param id id of the image
     * @param comment comment provided by the user on the image
     * @param session user session details
     * @param redirectAttr redirect attributes
     * @param userComment instance of the Comment
     * @return redirect back to the image page
     * @throws IOException
     */

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addComment(@PathVariable("imageTitle") String title, @PathVariable("imageId") Integer id, @RequestParam("comment") String comment, HttpSession session, RedirectAttributes redirectAttr, Comment userComment) throws IOException {
        User user = (User) session.getAttribute("loggeduser");

        userComment.setUser(user);
        userComment.setText(comment);
        userComment.setCreatedDate(LocalDate.now());
        userComment.setImage(imageService.getImage(id));

        commentService.createComment(userComment);

        redirectAttr.addAttribute("id", id).addFlashAttribute("id", id);
        redirectAttr.addAttribute("title", title).addFlashAttribute("title", title);

        return "redirect:/images/{id}/{title}";
    }
}