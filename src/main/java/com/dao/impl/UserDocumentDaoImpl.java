package com.dao.impl;


import com.dao.AbstractDao;
import com.dao.UserDocumentDao;
import com.model.UserBook;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDocumentDao")
 public class UserDocumentDaoImpl extends AbstractDao<Integer, UserBook> implements UserDocumentDao {

	@SuppressWarnings("unchecked")
	public List<UserBook> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<UserBook>)crit.list();
	}

	public void save(UserBook document) {
		persist(document);
	}


	public UserBook findById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<UserBook> findAllByUserId(int userId){
		Criteria crit = createEntityCriteria();
		Criteria userCriteria = crit.createCriteria("user");
		userCriteria.add(Restrictions.eq("id", userId));
		return (List<UserBook>)crit.list();
	}


	public void deleteById(int id) {
		UserBook document =  getByKey(id);
		delete(document);
	}

}
