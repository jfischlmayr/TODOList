package at.thejano.service;

import at.thejano.entity.TODO;
import at.thejano.repository.DBRepo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/todo")
public class TODOService {

    @Inject
    DBRepo dbRepo;

    @Path("welcome")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Welcome to the TODO-List";
    }

    @PostConstruct
    public void init() {
        dbRepo.initDB();
    }


    @Path("findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TODO> findAll() {
        return dbRepo.findAll();
    }


    @Path("find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TODO findAll(@PathParam("id") long id) {
        return dbRepo.find(id);
    }


    @Path("delete/{id}")
    @DELETE
    public void deleteTODO(@PathParam("id") long id) {
        dbRepo.delete(id);
    }


    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTODO(TODO todo) {
        dbRepo.create(todo);
    }


    @Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTODO(TODO todo) {
        dbRepo.update(todo);
    }
}
