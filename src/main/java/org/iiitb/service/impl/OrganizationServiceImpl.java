package org.iiitb.service.impl;

import org.iiitb.bean.Domain;
import org.iiitb.bean.Organization;
import org.iiitb.service.OrganizationService;

import java.util.List;

public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public List<Organization> findAll() {
        return organizationDao.findAll();
    }
}
