package com.dit.hua.daoi;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;
import javax.transaction.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.*;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO{
	@Autowired
    private SessionFactory sessionFactory;
	@Override
    @Transactional
	public void insertAuthorities(Authorities authority){
		Session session=this.sessionFactory.getCurrentSession();
		session.save(authority);
	}
	@Override
	@Transactional
	public void deleteAuthorities(Authorities authority){
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(authority);
	}
	@Override
	@Transactional
	public Authorities getAuthorByUsername(String username){
		Session session=this.sessionFactory.getCurrentSession();
		Authorities authorities=null;
		try{
			authorities=session.createQuery("from Authorities where username='"+username+"'", Authorities.class).getSingleResult();
		}catch(Exception exception){}
		return authorities;
	}
	@Override
	@Transactional
	public List<Authorities> getAuthorities(){
		 Session session=this.sessionFactory.getCurrentSession();
		 Query<Authorities> query=session.createQuery("from Authorities",Authorities.class);
		 return query.getResultList();
	}
	@Override
	@Transactional
	public List<Authorities> getTeachers(){
		 Session session=this.sessionFactory.getCurrentSession();
		 Query<Authorities> query=session.createQuery("from Authorities where authority='ROLE_TEACHER'",Authorities.class);
		return query.getResultList();
	}
}