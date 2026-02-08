package com.springboot.demo.model;

import com.springboot.demo.bean.Gender;
import com.springboot.demo.bean.StudentStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private Integer age;
    private Gender gender;
    private String emailAddress;
    private String address;
    private String parentName;
    private String mobileNumber;
    private StudentStatus status;


//    public Student(String id, String name, Integer age, Gender gender, String emailAddress,
//                   String address, String parentName, String mobileNumber, StudentStatus status) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.emailAddress = emailAddress;
//        this.address = address;
//        this.parentName = parentName;
//        this.mobileNumber = mobileNumber;
//        this.status = status;
//    }
//
//    public Student() {}
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getParentName() {
//        return parentName;
//    }
//
//    public void setParentName(String parentName) {
//        this.parentName = parentName;
//    }
//
////    public String getMobileNumber() {
////        return mobileNumber;
////    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public StudentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(StudentStatus status) {
//        this.status = status;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", address='" + address + '\'' +
//                ", parentName='" + parentName + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", status=" + status +
//                '}';
//    }
}
