package com.eren.dev.post.create;

public record CreatePostCommand(
        String title,
        String content,
        boolean isActive,
        String author
){
    public static CreatePostCommand with(
            final String aTitle,
            final String aContent,
            final boolean isActive,
            final String aAuthor
    ){
        return new CreatePostCommand(aTitle, aContent, isActive, aAuthor);
    }
}