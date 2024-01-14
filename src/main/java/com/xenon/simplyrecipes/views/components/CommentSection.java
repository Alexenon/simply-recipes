package com.xenon.simplyrecipes.views.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
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
        updateCommentsForRecipe();
        setupAddCommentListener();
        chatLayout.add(input, comments);
        add(getSectionHeader(), chatLayout);
    }

    private void addStyle() {
        chatLayout.expand(comments);
        chatLayout.addClassName("comment-section-body");
        input.setId("comment-input");
        setCommentInputPlaceholder();
    }

    private Div getSectionHeader() {
        H3 title = new H3("Comments (" + getCommentsForRecipe().size() + ")");
        Div sectionHeader = new Div(title);
        sectionHeader.addClassName("comment-section-header");
        return sectionHeader;
    }

    private void updateCommentsForRecipe() {
        chatLayout.remove(comments);
        List<MessageListItem> listOfCommentItems = new ArrayList<>();
        for (Comment comment : getCommentsForRecipe()) {
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

    private void setCommentInputPlaceholder() {
        String script = """
                const commentInput = document.getElementById('comment-input');
                const textarea =  commentInput.querySelector('textarea');
                textarea.setAttribute('placeholder', 'Comments');
                """;

        UI.getCurrent().getPage().executeJs(script);
    }

    private List<Comment> getCommentsForRecipe() {
        return commentService.getCommentsByRecipeId(recipe.getId());
    }
}
