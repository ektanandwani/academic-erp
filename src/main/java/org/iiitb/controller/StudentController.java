package org.iiitb.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Alumni;
import org.iiitb.bean.Student;
import org.iiitb.service.StudentService;
import org.iiitb.service.impl.StudentServiceImpl;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static javax.ws.rs.core.Response.ok;

@Path("/student")
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();
    
    @POST
    @Path("/submit")
    public Response filterStudents(String jsonObject) throws URISyntaxException {

        System.out.println("student controller");
        JSONObject json = new JSONObject(jsonObject);
        System.out.println(json);
        Integer orgId = Integer.parseInt(json.getString("orgId"));
        Integer domainId = Integer.parseInt(json.getString("domainId"));
        Integer year = Integer.parseInt(json.getString("year"));
        Integer placed = Integer.parseInt(json.getString("placed"));

        Alumni a = studentService.findAlum(2);
        System.out.println(a.getPassingYear());

        List<Student> studentList = null;
        if(orgId != 0 && domainId != 0) {
            studentList = studentService.findbyOrgandDomain(orgId, domainId);
            System.out.println(studentList.size());
        }
        else if (orgId != null) {

        }
//        else if(domainId != null) {
//
//        }
        else if(orgId == 0 && domainId == 0) {
            System.out.println("inside if both 0");
            studentList = studentService.findAll();
        }

        return ok().entity(studentList).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAllStudent() {
        List<Student> studentList = studentService.findAll();
        if (studentList == null)
            return Response.noContent().build();
        return ok().entity(studentList).build();
    }
}
