package quarkus.example;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StudentsService {

    @Inject
    StudentRepository studentRepository;


    public StudentsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    public List<Students> getAllStudents() {
        return studentRepository.listAll();
    }

    @Transactional
    public void addNewStudentToDB(Students students) {
        studentRepository.persist(students);
    }

    @Transactional
    public void editStudentById(Long id, Students students) {
        Students studentToPut = studentRepository.findById(id);
        studentToPut.setName(students.getName());
        studentToPut.setStudentIdNumber(students.getStudentIdNumber());
        studentToPut.setSurname(students.getSurname());
        studentRepository.persist(studentToPut);
    }






}
