package org.iiitb.controller;


import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.User;
import org.iiitb.service.UserService;
import org.iiitb.service.impl.UserServiceImpl;
import org.json.JSONObject;

import javax.persistence.NoResultException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

import static javax.ws.rs.core.Response.ok;

@Path("/user")
public class UserController {
    private UserService userService = new UserServiceImpl();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateUser(String jsonObject) throws URISyntaxException {

        JSONObject json = new JSONObject(jsonObject);
        System.out.println(json);
        String userName = json.getString("userName");
        String password = json.getString("password");


        System.out.println("usercontroller" + userName);
        User u;
        try {
             u = userService.findByUserName(userName);
        }
        catch (NoResultException e)
        {
            System.out.println("no result exception");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        System.out.println(password);
        System.out.println(u);
        if (u.getPassword().contentEquals(password))
            return ok().entity(u).build();
        else
            return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
