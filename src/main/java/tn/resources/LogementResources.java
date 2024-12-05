package tn.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.businesses.LogementBusiness;
import tn.entities.Logement;

@Path("logements")
public class LogementResources {


    public static LogementBusiness LB=new LogementBusiness();


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  GetAll()
    {

        if(LB.getLogements()!=null)
            return Response.status(Status.OK).entity(LB.getLogements()).build();

        else

            return Response.status(Status.NOT_FOUND).entity("liste vide" ).build();
    }

    @POST
    @Path("addXml")
    //@Consumes("application/xml")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addLogement(Logement l) {
        if(LB.getLogements().add(l))
            return  Response.status(Status.CREATED).build();
        return  Response.status(Status.NOT_FOUND).build();
    }
//
//    @GET
//    @Path("logements/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getLogementById(@PathParam("id") int id) {
//        Logement l = LB.getLogementsByReference(id);
//        if (l != null) {
//            return Response.status(Status.OK).entity(l).build();
//        }
//        return Response.status(Status.NOT_FOUND).entity("Logement non trouvé").build();
//    }


}
