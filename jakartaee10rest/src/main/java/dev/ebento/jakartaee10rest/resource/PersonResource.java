package dev.ebento.jakartaee10rest.resource;

import dev.ebento.jakartaee10rest.dto.PersonDTO;
import dev.ebento.jakartaee10rest.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    private PersonService personService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Accepts JSON input
    @Produces(MediaType.APPLICATION_JSON) // Returns JSON output
    public PersonDTO save(PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getAll() {
        return personService.findAll();
    }

    @GET
    @Path("/{id}") // Specify the path to avoid conflict
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO getOne(@PathParam("id") Long id) {
        return personService.findOne(id);
    }
}