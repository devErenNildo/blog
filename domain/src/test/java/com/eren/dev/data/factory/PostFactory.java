package com.eren.dev.data.factory;

import com.eren.dev.post.Post;
import net.datafaker.Faker;

import java.util.Locale;

public class PostFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static Post newValidFakerPost(){
        return validPost();
    }


    private static Post validPost(){
        Post post = Post.newPost(faker.book().title(), faker.lorem().paragraph(), true, faker.name().fullName());
        return post;
    }
}
