import java.util.*;
public class Main{
    public static void main(String args[]){
        // Student s1=new Student(1,"Rohit","CSE","85%");
        // Student s2=new Student(2,"Suresh","ECE","80%");
        // Student s3=new Student(3,"Mahesh","MECH","75%");

        // ArrayList<Student> al=new ArrayList<>();

        // al.add(new Student(1,"Rohit","CSE","85%"));
        // al.add(new Student(2,"Suresh","ECE","80%"));
        // al.add(new Student(3,"Mahesh","MECH","75%"));
        // al.add(new Student(4,"Ramesh","CSE","90%"));
        // al.add(new Student(5,"Suresh","ECE","82%"));
        // al.add(new Student(6,"Mahesh","MECH","78%"));
        // List<Student> s=getStudentList();
        List<Student> al=getStudentList();
        System.out.println("Before Sorting");
        al.forEach(s->System.out.println(s));
        System.out.println("After Sorting");
        // Collections.sort(al,(s1,s2)->{return s2.getId()-s1.getId();});
        // al.forEach(s->System.out.println(s));

        Optional<Student> res=al.stream().max((s1,s2)->{return s1.getId()-s2.getId();});
        System.out.println(res);


    }

    public static List<Student> getStudentList(){
        ArrayList<Student> al=new ArrayList<>();

        al.add(new Student(1,"Rohit","CSE","85%"));
        al.add(new Student(2,"Suresh","ECE","80%"));
        al.add(new Student(3,"Mahesh","MECH","75%"));
        al.add(new Student(4,"Ramesh","CSE","90%"));
        al.add(new Student(5,"Suresh","ECE","82%"));
        al.add(new Student(6,"Mahesh","MECH","78%"));
        return al;
    }
}