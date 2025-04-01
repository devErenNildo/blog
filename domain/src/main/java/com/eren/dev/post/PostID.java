package com.eren.dev.post;

import com.eren.dev.Identifier;
import com.eren.dev.utils.IdUtils;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode
public class PostID extends Identifier {

    private final String value;

    private PostID(final String value){
        this.value = Objects.requireNonNull(value);
    }

    public static PostID unique(){
        return PostID.from(IdUtils.uuid());
    }

    public static PostID from(final String anId){
        return new PostID(anId);
    }

    @Override
    public String getValue() {
        return value;
    }
}
