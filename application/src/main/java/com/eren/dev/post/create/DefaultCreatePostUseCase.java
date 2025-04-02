package com.eren.dev.post.create;

import com.eren.dev.post.Post;
import com.eren.dev.post.PostGateway;
import com.eren.dev.utils.Either;
import com.eren.dev.validation.handler.Notification;

import java.util.Objects;

public class DefaultCreatePostUseCase extends CreatePostUseCase{

    private final PostGateway postGateway;

    public DefaultCreatePostUseCase(final PostGateway postGateway){
        this.postGateway = Objects.requireNonNull(postGateway);
    }

    @Override
    public Either<Notification, CreatePostOutput> execute(CreatePostCommand aCommand) {
        final var aTitle = aCommand.title();
        final var aContent = aCommand.content();
        final var isActive = aCommand.isActive();
        final var aAuthor = aCommand.author();

        final var notification = Notification.create();

        final var aPost = Post.newPost(aTitle, aContent, isActive, aAuthor);
        aPost.validate(notification);

        return notification.hasError() ? Either.left(notification) : create(aPost);
    }

    private Either<Notification, CreatePostOutput> create(final Post aPost) {
        try {
            final var createdPost = this.postGateway.create(aPost);
            return Either.right(CreatePostOutput.from(createdPost));
        } catch (Exception ex){
            return Either.left(Notification.create(ex));
        }
    }
}
