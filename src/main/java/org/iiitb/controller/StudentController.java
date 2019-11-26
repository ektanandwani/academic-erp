package org.iiitb.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
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
//    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/submit")
    public Response addStudent(String jsonObject) throws URISyntaxException {


        JSONObject json = new JSONObject(jsonObject);
        String id = json.getString("orgId");
        System.out.println("student controller");
//        Student student = new Student();
//
//        if(organizationId != null && domainId != null) {
//            List<Student> studentList = studentService.findbyOrgandDomain(organizationId, domainId);
//            System.out.println(studentList.get(0).toString());
//        }
//        else if (organizationId != null) {
//
//        }
//        else if(domainId != null) {
//
//        }
//        else {
//
//        }

        return Response.seeOther(new URI("/studentlist.html")).build();
    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response showAllStudent() {
//        List<Student> studentList = studentService.findAll();
//        if (studentList == null)
//            return Response.noContent().build();
//        return ok().entity(studentList).build();
//    }
}
