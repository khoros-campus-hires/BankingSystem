package com.example.Banking.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        private long id;
        private String firstName;
        private String lastName;
        //private Date dob;
        private int age;
        private String address;
        private long contact_number;
        private String email;









}

