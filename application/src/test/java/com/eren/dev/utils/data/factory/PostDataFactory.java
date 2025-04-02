package com.eren.dev.utils.data.factory;

import com.eren.dev.post.create.CreatePostCommand;
import net.datafaker.Faker;

import java.util.Locale;

public class PostDataFactory {

    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static CreatePostCommand newPostCommand(){
        return CreatePostCommand.with(faker.book().title(), "", true, faker.name().fullName());
    }
}
