package proj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @Column(name = "idquestion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name="subject",referencedColumnName="idsubject")
    private Subject subject;
    @Column(name = "form")
    private String form;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name="teacher",referencedColumnName="idteacher")
    private Teacher teacher;
    @Column(name = "name")
    private String name;
    @Column(name = "answer_1")
    private String answer_1;
    @Column(name = "answer_2")
    private String answer_2;
    @Column(name = "answer_3")
    private String answer_3;
    @Column(name = "answer_4")
    private String answer_4;
    @Column(name = "right_answer")
    private int right_answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getAnswer_4() {
        return answer_4;
    }

    public void setAnswer_4(String answer_4) {
        this.answer_4 = answer_4;
    }

    public int getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(int right_answer) {
        this.right_answer = right_answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", subject=" + subject +
                ", form='" + form + '\'' +
                ", teacher=" + teacher +
                ", name='" + name + '\'' +
                ", answer_1='" + answer_1 + '\'' +
                ", answer_2='" + answer_2 + '\'' +
                ", answer_3='" + answer_3 + '\'' +
                ", answer_4='" + answer_4 + '\'' +
                ", right_answer='" + right_answer + '\'' +
                '}';
    }
    public Question(){

    }
}
