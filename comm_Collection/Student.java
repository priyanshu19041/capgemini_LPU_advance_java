public class Student{
    private Integer id;
    private String name;
    private String branch;
    private String percentage;

    public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getBranch() {
    return branch;
}

public void setBranch(String branch) {
    this.branch = branch;
}

public String getPercentage() {
    return percentage;
}

public void setPercentage(String percentage) {
    this.percentage = percentage;
}

    public Student(Integer id, String name, String getBranch, String percentage){
        this.id=id;
        this.name=name;
        this.branch=branch;
        this.percentage=percentage;
        
    }

    // Override
public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", branch='" + branch + '\'' +
            ", percentage='" + percentage + '\'' +
            '}';
}

}

