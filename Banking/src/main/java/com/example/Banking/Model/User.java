package com.example.Banking.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    private long Id;
    private String FirstName;
    private int Age;

    public User() {

    }

    public User(String FirstName, int Age) {
        this.FirstName = FirstName;
        this.Age= Age;
    }

    @Column(name = "Id", nullable = false)
    public long getId() {
        return Id;
    }
    public void setId(long Id) {
        this.Id = Id;
    }

    @Column(name = "FirstName", nullable = false)
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    @Column(name = "Age", nullable = false)
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", FirstName=" + FirstName + ", Age=" + Age + "]";
    }

}

