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

    @Test
    public void givenAnInvalidNullContent_whenCallNewPostAnValidate_thenShouldReceiveError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'content' não pode ser nulo";

        final var actualPost = PostFactory.newInvalidPostNullContent();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenAnInvalidEmptyTitle_whenCallNewPostAndValidate_thenShouldReceiverError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'title' não pode ser vazio";

        final var actualPost = PostFactory.newInvalidPostEmptyTitle();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenAnInvalidEmptyContent_whenCallNewPostAndValidate_thenShouldReceiverError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'content' não pode ser vazio";

        final var actualPost = PostFactory.newInvalidPostEmptyContent();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenAnInvalidTitleLengthLessThan5_whenCallNewPostAndValidate_thenShouldReceiverError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'title' deve ter no mínimo 5 caracteres";

        final var actualPost = PostFactory.newInvalidPostMinLengthTitle();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenAnInvalidContentLengthLessThan5_whenCallNewPostAndValidate_thenShouldReceiverError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'content' deve ter no mínimo 5 caracteres";

        final var actualPost = PostFactory.newInvalidPostMinLengthContent();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenAnInvalidTitleLengthMoreThan255_whenCallNewPostAndValidate_thenShouldReceiverError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'title' deve ter no máximo 255 caracteres";

        final var actualPost = PostFactory.newInvalidPostMaxLengthTitle();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }

    @Test
    public void givenAnInvalidContentLengthMoreThan255_whenCallNewPostAndValidate_thenShouldReceiverError(){
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'content' deve ter no máximo 255 caracteres";

        final var actualPost = PostFactory.newInvalidPostMaxLengthContent();

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actualPost.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().getFirst().message());
    }


}
