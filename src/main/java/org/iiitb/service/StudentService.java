package org.iiitb.service;

import org.iiitb.bean.Alumni;
import org.iiitb.bean.Student;
import org.iiitb.dao.StudentDao;
import org.iiitb.service.impl.DomainServiceImpl;

import java.util.List;

public interface StudentService {
    
    StudentDao studentDao = new StudentDao();
    DomainService domainService = new DomainServiceImpl();
    
    void save(Student student,
              Integer domainId);
    
    Student find(Integer id);
    
    Student findByRollNumber(String rollNumber);
    
    List<Student> findAll();

    List<Student> findbyOrgandDomain(Integer orgId, Integer domainId);

    Alumni findAlum(Integer id);
}
