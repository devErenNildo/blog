package com.eren.dev.post;

import com.eren.dev.UnitTest;
import com.eren.dev.exceptions.DomainException;
import com.eren.dev.utils.data.factory.PostFactory;
import com.eren.dev.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostTest extends UnitTest {


    @Test
    public void givenAValidPans_wenCallNewPost_thenInstantiateAPost(){
        final var actualPost = PostFactory.newValidFakerPost();

        Assertions.assertNotNull(actualPost);
        Assertions.assertNotNull(actualPost.getId());
        Assertions.assertNotNull(actualPost.getCreatedAt());
        Assertions.assertNotNull(actualPost.getUpdatedAt());
        Assertions.assertNull(actualPost.getDeletedAt());
    }

    @Test
    public void givenAnInvalidNullTitle_whenCallNewPostAnValidate_thenShouldReceiveError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'title' não pode ser nulo";

        final var actualPost = PostFactory.newInvalidPostNullTitle();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }
}
