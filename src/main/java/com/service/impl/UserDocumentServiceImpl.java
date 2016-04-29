package com.service.impl;


import com.dao.UserDocumentDao;
import com.model.UserBook;
import com.service.UserDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService {

	@Autowired
	UserDocumentDao dao;

	public UserBook findById(int id) {
		return dao.findById(id);
	}

	public List<UserBook> findAll() {
		return dao.findAll();
	}

	public List<UserBook> findAllByUserId(int userId) {
		return dao.findAllByUserId(userId);
	}
	
	public void saveDocument(UserBook document){
		dao.save(document);
	}

	public void deleteById(int id){
		dao.deleteById(id);
	}
	
}
