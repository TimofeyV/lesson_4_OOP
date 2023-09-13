import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup> {
    private List<Student> group;

    private Integer idGroup;

    public StudentGroup(Integer idGroup) {
        this(new ArrayList<Student>(), idGroup);
    }

    public StudentGroup(List<Student> group, Integer idGroup) {
        this.group = group;
        this.idGroup = idGroup;
    }

    public List<Student> getGroup() {
        return group;
    }

    public boolean add(Student student) {
        if (group.contains(student))
            return false;
        group.add(student);
        return true;
    }

    public boolean remove(Student student) {
        if (group.contains(student)) {
            group.remove(student);
            return true;
        }
        return false;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Группа: ");
        sb.append(idGroup);
        sb.append(" количество студентов: ");
        sb.append(group.size());
        for (Student s : group) {
            sb.append("\n");
            sb.append(s.getName());
        }
        return sb.toString();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(group);
    }

    @Override
    public int compareTo(StudentGroup o) {
        if (group.size() > o.group.size())
            return 1;
        else if (group.size() < o.group.size())
            return -1;

        if (this.idGroup > o.getIdGroup())
            return 1;
        else if (idGroup < o.getIdGroup())
            return -1;

        return 0;
    }

}