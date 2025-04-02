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

    public static Post newInvalidPostEmptyTitle(){
        return Post.newPost("", faker.lorem().paragraph(), true, faker.name().fullName());
    }

    public static Post newInvalidPostMinLengthTitle(){
        return Post.newPost(faker.lorem().characters(4), faker.lorem().paragraph(), true, faker.name().fullName());
    }

    public static Post newInvalidPostMaxLengthTitle(){
        return Post.newPost(faker.lorem().characters(256), faker.lorem().paragraph(), true, faker.name().fullName());
    }


    //content-----------------------------------
    public static Post newInvalidPostNullContent(){
        return Post.newPost(faker.book().title(), null, true, faker.name().fullName());
    }

    public static Post newInvalidPostEmptyContent(){
        return Post.newPost(faker.book().title(), "", true, faker.name().fullName());
    }

    public static Post newInvalidPostMinLengthContent(){
        return Post.newPost(faker.book().title(), faker.lorem().characters(4), true, faker.name().fullName());
    }

    public static Post newInvalidPostMaxLengthContent(){
        return Post.newPost(faker.book().title(), faker.lorem().characters(10001), true, faker.name().fullName());
    }


    private static Post validPost(){
        Post post = Post.newPost(faker.book().title(), faker.lorem().paragraph(), true, faker.name().fullName());
        return post;
    }
}
