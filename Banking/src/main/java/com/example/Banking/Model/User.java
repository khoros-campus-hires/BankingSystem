package com.example.Banking.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User {
        @Id
        private long id;
        private String firstName;
        private String lastName;
        private Date dob;
        private int age;
        private String address;
        private long contact_number;
        private String email;



        @Override
        public String toString() {
            return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Date of Birth=" + dob +", /n" +
                    "age=" + age + "address=" + address +", contact_number=" + contact_number + ", email=" +email + "]";
        }





}

