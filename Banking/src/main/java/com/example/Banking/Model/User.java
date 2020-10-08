package com.example.Banking.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Useeee")
public class User {
        private long id;
        private String firstName;
        private int m_no;

        public User() {

        }

        public User(String firstName, int m_no) {
            this.firstName = firstName;
            this.m_no= m_no;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
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

        @Column(name = "m_no", nullable = false)
        public int getM_no() {
            return m_no;
        }
        public void setM_no(int m_no) {
            this.m_no = m_no;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", firstName=" + firstName + ", m_no=" + m_no + "]";
        }





}

