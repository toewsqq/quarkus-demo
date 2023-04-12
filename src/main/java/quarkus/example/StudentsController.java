package quarkus.example;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
