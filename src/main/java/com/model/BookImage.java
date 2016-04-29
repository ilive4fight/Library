//package com.model;
//
//import javax.persistence.*;
//
///**
// * Created by semen on 29.04.2016.
// */
//@Entity
//@Table(name = "BOOK_IMAGE")
//public class BookImage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Column(name = "content", nullable = false)
//    private byte[] content;
//
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "IMAGE_ID")
//    private UserBook userBook;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public byte[] getContent() {
//        return content;
//    }
//
//    public void setContent(byte[] content) {
//        this.content = content;
//    }
//
//    public UserBook getUserBook() {
//        return userBook;
//    }
//
//    public void setUserBook(UserBook userBook) {
//        this.userBook = userBook;
//    }
//}
