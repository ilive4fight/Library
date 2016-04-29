package com.dao;


import com.model.UserBook;

import java.util.List;

public interface UserDocumentDao {

	List<UserBook> findAll();
	
	UserBook findById(int id);
	
	void save(UserBook document);
	
	List<UserBook> findAllByUserId(int userId);
	
	void deleteById(int id);
}
