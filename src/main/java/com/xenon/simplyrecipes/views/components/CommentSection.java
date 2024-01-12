package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.xenon.simplyrecipes.entities.Comment;
import com.xenon.simplyrecipes.entities.Recipe;
import com.xenon.simplyrecipes.services.CommentService;
import com.xenon.simplyrecipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class CommentSection extends Section {

    private final Recipe recipe;
    private final CommentService commentService;
    private final UserService userService;

    private final MessageInput input = new MessageInput();
    private final MessageList comments = new MessageList();
    private final VerticalLayout chatLayout = new VerticalLayout();

    @Autowired
    public CommentSection(Recipe recipe, CommentService commentService, UserService userService) {
        this.recipe = recipe;
        this.commentService = commentService;
        this.userService = userService;

        initialize();
        addStyle();
    }

    private void initialize() {
        chatLayout.add(input, comments);
        updateCommentsForRecipe();
        setupAddCommentListener();
    }

    private void addStyle() {
        chatLayout.setHeight("500px");
        chatLayout.setWidth("400px");
        chatLayout.expand(comments);
        add(chatLayout);
    }

    private void updateCommentsForRecipe() {
        chatLayout.remove(comments);
        List<Comment> commentsByRecipeId = commentService.getCommentsByRecipeId(recipe.getId());
        List<MessageListItem> listOfCommentItems = new ArrayList<>();
        for (Comment comment : commentsByRecipeId) {
            String text = comment.getText();
            Instant datePosted = comment.getDatePosted().toInstant(ZoneOffset.UTC);
            String username = comment.getUser().getUsername();
            MessageListItem commentItem = new MessageListItem(text, datePosted, username);
            listOfCommentItems.add(commentItem);
        }
        comments.setItems(listOfCommentItems);
        chatLayout.add(comments);
    }

    private void setupAddCommentListener() {
        input.addSubmitListener(submitEvent -> {
            Comment comment = new Comment();
            comment.setText(submitEvent.getValue());
            comment.setDatePosted(LocalDateTime.now());
            comment.setUser(userService.getDefaultUser());
            comment.setRecipe(recipe);
            commentService.addComment(comment);

            updateCommentsForRecipe();
        });
    }


}
