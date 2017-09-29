package proj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "result")
public class Result implements Serializable {
    @Id
    @Column(name = "idresult")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name="student",referencedColumnName="idstudent")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name="question",referencedColumnName="idquestion")
    private Question question;
    @Column(name = "mark")
    private int mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", student=" + student +
                ", question=" + question +
                ", mark=" + mark +
                '}';
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    public Result(){

    }
}

