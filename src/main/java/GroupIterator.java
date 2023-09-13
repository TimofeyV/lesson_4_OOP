import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GroupIterator implements Iterator<StudentGroup> {
    private int counter;
    /**
     * Список групп
     */
    private List<StudentGroup> groups;

    public GroupIterator(List<StudentGroup> groups) {
        this.groups = groups;
    }

    @Override
    public boolean hasNext() {
        return counter < groups.size();
    }

    @Override
    public StudentGroup next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return groups.get(counter++);
    }
}