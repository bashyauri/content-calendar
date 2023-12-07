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
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(
                1, "My First Blog Post", "My first blog", Status.IN_PROGRESS, Type.ARTICLES, LocalDateTime.now(),
                null, "");
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).count() == 1;
    }

}
