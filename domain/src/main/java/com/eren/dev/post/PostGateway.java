package com.eren.dev.post;

import com.eren.dev.pagination.Pagination;
import com.eren.dev.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface PostGateway {
    Post create(Post aPost);

    void deleteById(PostID anId);

    Optional<Post> findById(PostID anId);

    Post update(Post aPost);

    Pagination<Post> findAll(SearchQuery aQuery);

    List<PostID> existsByIds(Iterable<PostID> ids);
}
