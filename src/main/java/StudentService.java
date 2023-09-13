import java.util.ArrayList;
import java.util.List;

public class StudentService implements iPersonService<Student> {
    private int count;
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public void sortByFIO()
    {
        PersonComparator<Student> persComp = new PersonComparator<Student>();
        students.sort(persComp);
    }


    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void create(String name, int age) {
        Student stud = new Student(name, age);
        count++;
        students.add(stud);
    }

}