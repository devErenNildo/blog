package com.eren.dev.post.create;

import com.eren.dev.UseCase;
import com.eren.dev.utils.Either;
import com.eren.dev.validation.handler.Notification;

public abstract class CreatePostUseCase extends
        UseCase<CreatePostCommand, Either<Notification, CreatePostOutput>> {
}
