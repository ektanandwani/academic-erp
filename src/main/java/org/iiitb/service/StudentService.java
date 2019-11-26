package org.iiitb.service;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.iiitb.bean.Student;
import org.iiitb.dao.StudentDao;
import org.iiitb.service.impl.DomainServiceImpl;
import org.iiitb.service.impl.FileServiceImpl;

import java.io.InputStream;
import java.util.List;

public interface StudentService {
    
    StudentDao studentDao = new StudentDao();
    DomainService domainService = new DomainServiceImpl();
    FileService fileService = new FileServiceImpl();
    
    void save(Student student,
              Integer domainId);
    
    Student find(Integer id);
    
    Student findByRollNumber(String rollNumber);
    
    List<Student> findAll();

    List<Student> findbyOrgandDomain(Integer orgId, Integer domainId);
}
