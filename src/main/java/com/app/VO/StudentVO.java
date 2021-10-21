package com.app.VO;

import javax.persistence.*;


@Entity
@Table(name="student")
public class StudentVO {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private long stdId;
        @Column
        private String stdName;
        @Column
        private String stdCourse;
        @Column
        private double stdFee;
        @Column
        private String stdEmail;
        @Column
        private String password;

        public long getStdId() {
            return stdId;
        }

        public void setStdId(long stdId) {
            this.stdId = stdId;
        }

        public String getStdName() {
            return stdName;
        }

        public void setStdName(String stdName) {
            this.stdName = stdName;
        }

        public String getStdCourse() {
            return stdCourse;
        }

        public void setStdCourse(String stdCourse) {
            this.stdCourse = stdCourse;
        }

        public double getStdFee() {
            return stdFee;
        }

        public void setStdFee(double stdFee) {
            this.stdFee = stdFee;
        }

        public String getStdEmail() {
            return stdEmail;
        }

        public void setStdEmail(String stdEmail) {
            this.stdEmail = stdEmail;
        }

        public String getPassword() {
        return password;
        }

        public void setPassword(String password) {
        this.password = password;
        }
}


