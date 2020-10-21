package com.example.Banking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        private long id;
        private String firstName;
        private String lastName;
        private Date dob;
        private String address;
        private String contactNumber;
        private String email;

}


