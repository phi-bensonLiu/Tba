package phi.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import phi.dao.ITestDAO;
import phi.dao.to.Test;
import phi.dao.to.Note;

@Transactional("db")
@Repository
public class TestDAO implements ITestDAO{
	@Autowired  
	private SessionFactory sessionFactory;  
	
	public void persistUser(Test test) throws Exception {    
		try {
			System.out.println("AAAAAAAAAAAAAAAAA");
			sessionFactory.getCurrentSession().save(test);
			//throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public void persistUser1(Test test) throws Exception {    
		try {
			System.out.println("AAAAAAAAAAAAAAAAA");
			sessionFactory.getCurrentSession().saveOrUpdate(test);
			//throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Note> getUserById(Test test) throws Exception {
		
		//HQL
		//from Test t left join Note n with t.tag_sn = n.sn where t.tag_sn = :tag_sn
		//from Test t LEFT OUTER JOIN Note n on t.tag_sn = n.sn where t.tag_sn = :tag_sn
		//from Note n LEFT OUTER JOIN n.testList where n.sn = :tag_sn
		//from Note n where n.testList.tag_sn = :tag_sn
		
		Query query = sessionFactory.getCurrentSession().
					  createQuery("from Note n where n.sn = :tag_sn");
			  query.setParameter("tag_sn", test.getTag_sn());
		return (ArrayList<Note>) query.list();
		
		/*
		Query query = sessionFactory.getCurrentSession().
				  createQuery("from Note n where n.content = :tag_name");
		  query.setParameter("tag_name", test.getTag_name());
		return (ArrayList<Note>) query.list();
		*/
		/*
		Query query = sessionFactory.getCurrentSession().
				  createQuery("from Note n where n.sn = :tag_sn");
		query.setParameter("tag_sn", test.getTag_sn());
		return (ArrayList<Note>) query.list();
		*/
		//HQL
		/*
		Query query = sessionFactory.getCurrentSession().
					  createQuery("from Test t where t.tag_sn = :tag_sn");
			  query.setParameter("tag_sn", test.getTag_sn());
		return (Test) query.list().get(0);
		*/
		//Hiberbate 只能查詢PK
		/*
		return (Test) sessionFactory.getCurrentSession().
					  get(Test.class, test.getTag_name());
		*/
	}
}
