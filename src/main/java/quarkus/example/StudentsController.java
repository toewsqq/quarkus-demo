package quarkus.example;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/students")
public class StudentsController {

    @Inject
    StudentsService studentsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Students> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNewStudent(Students students){
        studentsService.addNewStudentToDB(students);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        studentsService.deleteStudent(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void editStudent(@PathParam("id") Long id, Students students ){
        studentsService.editStudentById(id, students);
    }



}
