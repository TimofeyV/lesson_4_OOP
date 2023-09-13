import java.util.ArrayList;
import java.util.List;

public class TeacherService implements iPersonService<Teacher> {
    private int count;
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<Teacher>();
    }

    public boolean add(Teacher teacher) {
        if (teachers.contains(teacher)) return false;
        teachers.add(teacher);
        return true;
    }

    public void sortByFIO() {
        PersonComparator<Teacher> persComp = new PersonComparator<Teacher>();
        teachers.sort(persComp);
    }

    public void print() {
        sortByFIO();
        for (Teacher teacher : this.teachers) {
            System.out.println("Преподаватель: " + teacher.getName() +
                    "\nВозраст: " + teacher.getAge() +
                    "\nУчёная степень: " + teacher.getAcadDegree() + "\n");
        }
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "basic");
        count++;
        teachers.add(teacher);
    }

    public void create(String name, int age, String acadDegree) {
        Teacher teacher = new Teacher(name, age, acadDegree);
        count++;
        teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "TeacherService{" + "count=" + count + ", teachers=" + teachers + '}';
    }
}