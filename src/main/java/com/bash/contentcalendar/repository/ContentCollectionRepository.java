package com.bash.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bash.contentcalendar.model.Content;
import com.bash.contentcalendar.model.Status;
import com.bash.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
                1, "My First Blog Post", "My first blog", Status.IDEA, Type.ARTICLES, LocalDateTime.now(),
                null, "");
        content.add(c);
    }

}
