package com.example.Banking.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Users")
public class User {
        private long id;
        private String firstName;
        private String lastName;
        private Date dob;
        private int age;
        private String address;
        private long contact_number;
        private String email;


        public User() {

        }

        public User(String firstName, String lastName, Date dob, int age, String address, long contact_number,String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dob=dob;
            this.age = age;
            this.address=address;
            this.contact_number = contact_number;
            this.email = email;
        }

        @Id
        @Column(name = "id", nullable=false)
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        @Column(name = "first_name", nullable = false)
        public String getfirstName() {
            return firstName;
        }
        public void setfirstName(String firstName) {
            this.firstName = firstName;
        }

        @Column(name = "last_name", nullable = false)
        public String getlastName() {
        return lastName;
    }
        public void setlastName(String lastName) {
        this.lastName = lastName;
    }

        @Column(name="dob", nullable = false)
        public Date getDob() { return dob;}
        public void setDob(Date dob) { this.dob = dob; }

        @Column(name = "age", nullable = false)
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Column(name = "address", nullable = false)
        public String getAddress() {
        return address;
    }
        public void setAddress(String address) {
        this.address = address;
    }

        @Column(name = "contact_number", nullable = false)
        public long getContact_number() { return contact_number; }
        public void setContact_number(long contact_number) { this.contact_number = contact_number; }

        @Column(name = "email", nullable = false)
        public String getEmail() {
        return email;
    }
        public void setEmail(String email) {
        this.email = email;
    }

        @Override
        public String toString() {
            return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Date of Birth=" + dob +", /n" +
                    "age=" + age + "address=" + address +", contact_number=" + contact_number + ", email=" +email + "]";
        }





}

