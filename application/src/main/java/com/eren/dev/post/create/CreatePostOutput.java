package com.eren.dev.post.create;

import com.eren.dev.post.Post;

public record CreatePostOutput(
        String id
) {
    public static CreatePostOutput from (final String aId){
        return new CreatePostOutput(aId);
    }

    public static CreatePostOutput from (final Post aPost){
        return new CreatePostOutput(aPost.getId().getValue());
    }
}
