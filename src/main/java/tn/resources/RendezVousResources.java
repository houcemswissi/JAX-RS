package tn.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.businesses.LogementBusiness;
import tn.businesses.RendezVousBusiness;
import tn.entities.RendezVous;




@Path("rendezvous")
public class RendezVousResources {

    private static RendezVousBusiness RB=new RendezVousBusiness();
    public static LogementBusiness logementMetier=new LogementBusiness();
    RendezVous r= new RendezVous(1, "31-10-2015","15:30",
            logementMetier.getLogementsByReference(4), "55214078");



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public   Response     getListRDV()
    {
        if(RB.getListeRendezVous().size()!=0)
            return Response.status(Status.OK).entity(RB.getListeRendezVous()).build();

        return Response.status(Status.NOT_FOUND).entity("La liste est vide").build();

    }
//
//    @GET
//    @Path("RendezVous/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getRendezVousById(@PathParam("id") int id)
//    {
//        RendezVous rendezVous=RB.getRendezVousById(id);
//        if(rendezVous!=null)
//            return Response.status(Status.OK).entity(rendezVous).build();
//        return Response.status(Status.NOT_FOUND).entity("RendezVous non trouvé").build();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addRendezVous(RendezVous rendezVous)
//    {
//        if(RB.addRendezVous(rendezVous))
//            return Response.status(Status.CREATED).entity(rendezVous).build();
//        return Response.status(Status.NOT_ACCEPTABLE).entity("RendezVous non ajouté").build();
//    }
//
////    @PUT
////    @Path("RendezVous/{id}")
////    @Consumes(MediaType.APPLICATION_JSON)
////    @Produces(MediaType.APPLICATION_JSON)
////    public Response updateRendezVous(@PathParam("id") int id, RendezVous rendezVous)
////    {
////        if(RB.updateRendezVous(id, rendezVous))
////            return Response.status(Status.OK).entity(rendezVous).build();
////        return Response.status(Status.NOT_MODIFIED).entity("RendezVous non modifié").build();
////    }
//
//    @DELETE
//    @Path("/RendezVous")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteRendezVous(@QueryParam("id") int id)
//    {
//        if(RB.deleteRendezVous(id))
//            return Response.status(Status.OK).entity("RendezVous supprimé").build();
//        return Response.status(Status.NOT_FOUND).entity("RendezVous non trouvé").build();
//    }


}
