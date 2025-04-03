package com.eren.dev.post;

import com.eren.dev.pagination.Pagination;
import com.eren.dev.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public class PostPostgresSQLGateway implements PostGateway{
    @Override
    public Post create(Post aPost) {
        return null;
    }

    @Override
    public void deleteById(PostID anId) {

    }

    @Override
    public Optional<Post> findById(PostID anId) {
        return Optional.empty();
    }

    @Override
    public Post update(Post aPost) {
        return null;
    }

    @Override
    public Pagination<Post> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<PostID> existsByIds(Iterable<PostID> ids) {
        return List.of();
    }
}
