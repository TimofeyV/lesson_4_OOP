import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Тимофей", 18);
        Student s2 = new Student("Артём", 18);
        Student s3 = new Student("Иван", 20);
        Student s4 = new Student("Дмитрий", 21);
        Student s5 = new Student("Дана", 18);
        Student s6 = new Student("Елизавета", 17);


        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);

        StudentGroup group6 = new StudentGroup(list, 6);
        StudentGroup group7 = new StudentGroup(7);
        group7.add(new Student("Владимир", 19));
        group7.add(new Student("Даниил", 24));


        System.out.println(group6 + "\n");

        StudentSteam steam = new StudentSteam(5);
        steam.add(group6);
        steam.add(group7);

        System.out.println(steam + "\n");

        Collections.sort(steam.getGroups());
        System.out.println("Отсортированный поток: \n" + steam + "\n");

        steam.sortSteam();
        System.out.println("Поток отсортированный по группам: \n" + steam + "\n");

        TeacherService ts = new TeacherService();
        Teacher t1 = new Teacher("Мария", 56, "professor");

        ts.create("Татьяна", 40, "professor");
        ts.create("Светлана", 29);

        ts.add(t1);

        ts.print();


    }
}