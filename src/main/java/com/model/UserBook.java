package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "USER_DOCUMENT")
public class UserBook {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "description", length = 255)
    @JsonProperty("description")
    private String description;

    @Column(name = "type", length = 100, nullable = false)
    @JsonProperty("type")
    private String type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", nullable = false)
    private byte[] content;

//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "IMAGE_ID")
//    private BookImage bookImage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
//    public BookImage getBookImage() {
//        return bookImage;
//    }
//
//    public void setBookImage(BookImage bookImage) {
//        this.bookImage = bookImage;
//    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserBook))
            return false;
        UserBook other = (UserBook) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserBook [id=" + id + ", name=" + name + ", description="
                + description + ", type=" + type + "]";
    }


}
