package task1.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


/*
<task>
    <id>123</id>
    <title>Title1</title>
    <description>Description1</description>
    <end_time>20:26</end_time>
</task>
*/
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task implements Comparable {
    private int id;
    private String title;
    private String description;
    @XmlElement(name = "end_time")
    private String time;

    public Task(int id, String title, String description, String time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId() == task.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Task {" +
                "id:" + id +
                ", title:" + title +
                ", description:" + description +
                ", time:" + time +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Task) {
            Task t = (Task) o;
            int i = t.getId() - getId();
            return i;
        }
        throw new RuntimeException("wrong type");
    }
}
