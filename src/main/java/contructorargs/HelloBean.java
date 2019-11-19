package contructorargs;

public class HelloBean {

    private String name;

    private String content;

    public HelloBean() {
    }

    public HelloBean(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
