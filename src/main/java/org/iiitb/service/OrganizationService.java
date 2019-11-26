package org.iiitb.service;

import org.iiitb.bean.Organization;
import org.iiitb.dao.OrganizationDao;

import java.util.List;

public interface OrganizationService {
    OrganizationDao organizationDao = new OrganizationDao();
    List<Organization> findAll();

}
