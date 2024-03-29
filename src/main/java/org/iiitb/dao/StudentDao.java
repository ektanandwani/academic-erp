package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Organization;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.util.List;


public class StudentDao {
    public void save(Student student) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(student);
        
        transaction.commit();
        session.close();
    }
    
    public Student find(Integer id) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        Student student = session.get(Student.class, id);
        
        transaction.commit();
        session.close();
        return student;
    }
    
    public Student findByRollNumber(String rollNumber) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM Student WHERE rollNumber = :roll_number";
        Query query = session.createQuery(hql);
        query.setParameter("roll_number", rollNumber);
        Student student = (Student) query.getSingleResult();
        
        transaction.commit();
        session.close();
        return student;
    }
    
    public List<Student> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "FROM Student";
        Query query = session.createQuery(hql);
        List<Student> studentList = query.list();
        
        transaction.commit();
        session.close();
        return studentList;
    }
    
    public String getLastRollNumber(Domain domain) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
    
        String hql = "SELECT s.rollNumber FROM Student s WHERE s.domain = :givenDomain ORDER BY s.rollNumber DESC";
        Query query = session.createQuery(hql);
        query.setParameter("givenDomain", domain);
        String rollNumber = null;
    
        if (!query.list().isEmpty())
            rollNumber = (String) query.list().get(0);
    
        transaction.commit();
        session.close();
        return rollNumber;
    }

    public List<Student> findByOrgAndDomain(Integer orgId, Integer domainId){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Domain domain = session.get(Domain.class, domainId);
        Organization org = session.get(Organization.class, orgId);
        String hql = "FROM Student WHERE domain = :givenDomain and organization = : org";
        Query query = session.createQuery(hql);
        query.setParameter("givenDomain", domain);
        query.setParameter("org", org);
        List<Student> students = query.list();
        transaction.commit();
        session.close();
        return students;
    }
}