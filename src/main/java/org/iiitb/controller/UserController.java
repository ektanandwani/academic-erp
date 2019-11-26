package org.iiitb.controller;


import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.User;
import org.iiitb.service.UserService;
import org.iiitb.service.impl.UserServiceImpl;

import javax.persistence.NoResultException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/user")
public class UserController {
    private UserService userService = new UserServiceImpl();

    @POST
    @Produces(MediaType.TEXT_HTML)
    public Response validateUser(@FormDataParam("userName") String userName,
                                 @FormDataParam("password") String password) throws URISyntaxException {
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
            return Response.seeOther(new URI("/studentlist.html")).build();
        else
            return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
