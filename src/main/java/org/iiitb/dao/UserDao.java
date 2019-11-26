package org.iiitb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.bean.User;
import org.iiitb.util.SessionUtil;

public class UserDao {

    public User findByUserName(String userName) {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User WHERE userName = :user_name";
        Query query = session.createQuery(hql);
        query.setParameter("user_name", userName);
        User user = (User) query.getSingleResult();
        System.out.println("userdao");
        System.out.println(user);

        transaction.commit();
        session.close();
        return user;
    }
}
