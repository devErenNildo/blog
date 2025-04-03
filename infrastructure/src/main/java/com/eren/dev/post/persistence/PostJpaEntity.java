package com.eren.dev.post.persistence;

import com.eren.dev.post.Post;
import com.eren.dev.post.PostID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "post")
public class PostJpaEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, length = 10000)
    private String content;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private Instant updatedAt;

    @Column(name = "deleted_at", columnDefinition = "TIMESTAMP(6)")
    private Instant deletedAt;

    public PostJpaEntity(){
    }

    private PostJpaEntity(
            final String id,
            final String title,
            final String content,
            final boolean active,
            final String aAuthor,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ){
        this.id = id;
        this.title = title;
        this.content = content;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static PostJpaEntity from(final Post aPost){
        return new PostJpaEntity(
                aPost.getId().getValue(),
                aPost.getTitle(),
                aPost.getContent(),
                aPost.isActive(),
                aPost.getAuthor(),
                aPost.getCreatedAt(),
                aPost.getUpdatedAt(),
                aPost.getDeletedAt()
        );
    }

    public Post toAggregate() {
        return Post.with(
                PostID.from(getId()),
                getTitle(),
                getContent(),
                isActive(),
                getAuthor(),
                getCreatedAt(),
                getUpdatedAt(),
                getDeletedAt()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }
}
