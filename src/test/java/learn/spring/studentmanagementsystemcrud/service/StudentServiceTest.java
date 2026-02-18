package learn.spring.studentmanagementsystemcrud.service;

import learn.spring.studentmanagementsystemcrud.Entity.Student;
import learn.spring.studentmanagementsystemcrud.repository.StudentRepository;
import learn.spring.studentmanagementsystemcrud.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void testGetAllStudents() {
        List<Student> mockStudents = Arrays.asList(
                new Student("John", "Doe", "john@example.com"),
                new Student("Jane", "Smith", "jane@example.com")
        );
        when(studentRepository.findAll()).thenReturn(mockStudents);

        List<Student> students = studentService.getAllStudents();
        assertEquals(2, students.size());
        verify(studentRepository, times(1)).findAll();
    }
}
