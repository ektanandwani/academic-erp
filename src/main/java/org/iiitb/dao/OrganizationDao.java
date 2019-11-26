package org.iiitb.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.Domain;
import org.iiitb.bean.Organization;
import org.iiitb.bean.Student;
import org.iiitb.util.SessionUtil;

import java.util.List;

public class OrganizationDao {


    public List<Organization> findAll() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Organization";
        Query query = session.createQuery(hql);

        List<Organization> organizations = query.list();

        transaction.commit();
        session.close();

        return organizations;
    }

    public Organization getOrganizationById(Integer id){
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Organization WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Organization org = (Organization) query.getSingleResult();

        transaction.commit();
        session.close();
        return org;
    }

}
