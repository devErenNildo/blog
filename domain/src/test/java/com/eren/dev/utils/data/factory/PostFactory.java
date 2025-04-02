package com.eren.dev.utils.data.factory;

import com.eren.dev.post.Post;
import net.datafaker.Faker;

import java.util.Locale;

public class PostFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static Post newValidFakerPost(){
        return validPost();
    }

    public static Post newInvalidPostNullTitle(){
        return Post.newPost(null, faker.lorem().paragraph(), true, faker.name().fullName());
    }

    public static Post newInvalidPostNullContent(){
        return Post.newPost(faker.book().title(), null, true, faker.name().fullName());
    }


    private static Post validPost(){
        Post post = Post.newPost(faker.book().title(), faker.lorem().paragraph(), true, faker.name().fullName());
        return post;
    }
}
