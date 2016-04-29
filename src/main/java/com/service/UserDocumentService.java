package com.service;


import com.model.UserBook;

import java.util.List;

public interface UserDocumentService {

	UserBook findById(int id);

	List<UserBook> findAll();
	
	List<UserBook> findAllByUserId(int id);
	
	void saveDocument(UserBook document);
	
	void deleteById(int id);
}
