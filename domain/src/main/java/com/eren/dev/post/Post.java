package com.eren.dev.post;

import com.eren.dev.AggregateRoot;
import com.eren.dev.utils.InstantUtils;
import com.eren.dev.validation.ValidationHandler;

import java.time.Instant;
import java.util.Objects;

public class Post extends AggregateRoot<PostID> {

    private String title;
    private String content;
    private boolean active;
    private String author;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;


    private Post(
            final PostID anId,
            final String aTitle,
            final String aContent,
            final boolean isActive,
            final String aAuthor,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.title = aTitle;
        this.content = aContent;
        this.active = isActive;
        this.author = aAuthor;
        this.createdAt = Objects.requireNonNull(aCreationDate, "'createdAt' não pode ser nulo");
        this.updatedAt = Objects.requireNonNull(aUpdateDate, "'updatedAt' não pode ser nulo");
        this.deletedAt = aDeleteDate;
    }

    public static Post newPost(final String aTitle, final String aContent, final boolean isActive, final String aAuthor){
        final var id = PostID.unique();
        final var now = InstantUtils.now();
        final var deletedAt = isActive ? null : now;
        return new Post(id, aTitle, aContent, isActive, aAuthor, now, now, deletedAt);
    }

    public static Post with(
            final PostID anId,
            final String aTitle,
            final String aContent,
            final boolean isActive,
            final String aAuthor,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        return new Post(
                anId,
                aTitle,
                aContent,
                isActive,
                aAuthor,
                createdAt,
                updatedAt,
                deletedAt
        );
    }

    public static Post with(final Post aPost){
        return with(
                aPost.getId(),
                aPost.title,
                aPost.content,
                aPost.active,
                aPost.author,
                aPost.createdAt,
                aPost.updatedAt,
                aPost.deletedAt
        );
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new PostValidator(this, handler).validate();
    }

    public Post activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Post deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = InstantUtils.now();
        }

        this.active = false;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Post update(
            final String aTitle,
            final String aContent,
            final boolean isActive
    ) {
        if (isActive) {
            activate();
        } else {
            deactivate();
        }
        this.title = aTitle;
        this.content = aContent;
        this.updatedAt = InstantUtils.now();
        return this;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isActive() {
        return active;
    }

    public String getAuthor() {
        return author;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
