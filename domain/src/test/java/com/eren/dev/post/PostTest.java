package com.eren.dev.post;

import com.eren.dev.UnitTest;
import com.eren.dev.data.factory.PostFactory;
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
}
