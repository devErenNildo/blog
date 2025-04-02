package com.eren.dev.post;

import com.eren.dev.validation.Error;
import com.eren.dev.validation.ValidationHandler;
import com.eren.dev.validation.Validator;

public class PostValidator extends Validator {
    public static final int TITLE_MAX_LENGTH = 255;
    public static final int TITLE_MIN_LENGTH = 5;

    public static final int CONTENT_MAX_LENGTH = 10000;
    public static final int CONTENT_MIN_LENGTH = 30;

    private final Post post;

    public PostValidator(final Post aPost, final ValidationHandler aHandler){
        super(aHandler);
        this.post = aPost;
    }

    @Override
    public void validate() {
        checkTitleAndContentConstraints();
    }

    private void checkTitleAndContentConstraints(){
        final var title = this.post.getTitle();
        final var content = this.post.getContent();

        if(title == null) {
            this.validationHandler().append(new Error("'title' não pode ser nulo"));
            return;
        }

        if (title.isBlank()){
            this.validationHandler().append(new Error("'title' não pode ser vazio"));
            return;
        }

        final int lenght = title.trim().length();
        if (lenght < TITLE_MIN_LENGTH){
            this.validationHandler().append(new Error("'title' deve ter no mínimo 5 caracteres"));
            return;
        }

        if (lenght > TITLE_MAX_LENGTH){
            this.validationHandler().append(new Error("'title' deve ter no máximo 255 caracteres"));
            return;
        }

        if(content == null) {
            this.validationHandler().append(new Error("'content' não pode ser nulo"));
            return;
        }

        if (content.isBlank()){
            this.validationHandler().append(new Error("'content' não pode ser vazio"));
            return;
        }

        final int lenghtContent = content.trim().length();
        if (lenghtContent < TITLE_MIN_LENGTH){
            this.validationHandler().append(new Error("'content' deve ter no mínimo 5 caracteres"));
            return;
        }

        if (lenghtContent > TITLE_MAX_LENGTH){
            this.validationHandler().append(new Error("'content' deve ter no máximo 255 caracteres"));
        }
    }
}
