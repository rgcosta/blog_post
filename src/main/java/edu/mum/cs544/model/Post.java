package edu.mum.cs544.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String title;
    private String description;
    @NotBlank
    @Lob
    private String text;
    @ElementCollection
    private List<String> categories;
    private Integer userId;

    public Post() {
        this.categories = new ArrayList<>();
    }

    public Post(String title, String description, String text, Integer userId) {
        this();
        this.title = title;
        this.description = description;
        this.text = text;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public boolean addCategory(String category) {
        return this.categories.add(category);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
