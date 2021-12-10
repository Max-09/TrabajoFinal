package com.informatorio.ApiRest.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;
    private String startup;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public String getStartup() {
        return startup;
    }
    public void setStartup(String startup) {
        this.startup = startup;
    }
    @Override
    public String toString() {
        return "Tags [id=" + id + ", startup=" + startup + ", tagName=" + tagName + "]";
    }
    
    
}
