package org.iiitb.controller;


import org.iiitb.bean.Domain;
import org.iiitb.bean.Organization;
import org.iiitb.service.OrganizationService;
import org.iiitb.service.impl.OrganizationServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/organization")
public class OrganizationController {
    private OrganizationService organizationService= new OrganizationServiceImpl();


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response listDomains() {

        List<Organization> organizations = organizationService.findAll();

        return Response.ok().entity(organizations).build();
    }

}
