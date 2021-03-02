package com.dit.hua.daoi;
import com.dit.hua.dao.UserDAO;
import com.dit.hua.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.*;
import javax.transaction.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
    private SessionFactory sessionFactory;
	@Override
    @Transactional
	public void insertUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(user);
	}
	@Override
	@Transactional
	public List<User> getUserByUsername(String username){
		Session session=this.sessionFactory.getCurrentSession();
		Query<User> query=session.createQuery("from User where username='"+username+"'",User.class);
		return query.getResultList();
	}
	@Override
	@Transactional
	public void deleteUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(user);
	}
	@Override
	@Transactional
	public void updateUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.update(user);
	}
	@Override
	@Transactional
	public List<User> getUsers(){
		Session session=this.sessionFactory.getCurrentSession();
		Query<User> query=session.createQuery("from User",User.class);
		return query.getResultList();
	}
}