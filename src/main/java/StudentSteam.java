import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Класс описывает поток студентов.
 * Характеризуется номером потока и списком групп студентов.
 */
public class StudentSteam implements Iterable<StudentGroup>{
    private int steamNumber;
    private List<StudentGroup> groups;

    public StudentSteam(int steamNumber) {
        groups = new ArrayList<StudentGroup>();
        this.steamNumber = steamNumber;
    }

    public void add(StudentGroup group) {
        groups.add(group);
    }

    public boolean remove(StudentGroup group) {
        if (groups.contains(group)) {
            groups.remove(group);
            return true;
        }
        return false;
    }

    public List<StudentGroup> getGroups() {
        return groups;
    }

    public void sortSteam() {
        Collections.sort(groups);
        for (StudentGroup gr: groups)
            Collections.sort(gr.getGroup());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Номер потока: ");
        sb.append(this.steamNumber);
        sb.append(", количество групп: ");
        sb.append(this.groups.size());
        for (StudentGroup gr: groups) {
            for (Student s: gr) {
                sb.append("\n");
                sb.append(s.getName() + ", группа: " + gr.getIdGroup());
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new GroupIterator(groups);
    }


}