package learn.spring.studentmanagementsystemcrud.Service;

import learn.spring.studentmanagementsystemcrud.Entity.Student;
import learn.spring.studentmanagementsystemcrud.dto.StudentRequest;
import learn.spring.studentmanagementsystemcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // letting it to be known as a service
public class StudentServiceImpl implements StudentService {
    // service implementation of StudentService

    // adding dependency injection of repository
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student create(StudentRequest request) {
        Student student = new Student(
                request.getfName(),
                request.getlName(),
                request.getEmail()
        );
        return repo.save(student);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student update(Long id, StudentRequest request) {
        Student student = getById(id);

        student.setfName(request.getfName());
        student.setlName(request.getlName());
        student.setEmail(request.getEmail());

        return repo.save(student);
    }

    public void delete(Long id) {
        Student student = getById(id);
        repo.delete(student);
    }
}
