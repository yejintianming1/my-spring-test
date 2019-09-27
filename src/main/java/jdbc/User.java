package jdbc;

public class User {

    private Long id;
    private String name;
    private int age;
    private Byte sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public User(Long id, String name, int age, Byte sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
