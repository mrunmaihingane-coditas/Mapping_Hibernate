package web;


import dao.PersonDaoImpl;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, SQLException {
        Configuration configuration= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person_CommenJoin.class).addAnnotatedClass(Address_CommenJoin.class).
                addAnnotatedClass(Person.class).addAnnotatedClass(Address.class).addAnnotatedClass(Person_CommenJoin.class)
                .addAnnotatedClass(Address_CommenJoin.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class);

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();
//        //Foregin Key
//        Person person = new Person();
//        person.setName("John Doe");
//
//        Address address = new Address();
//        address.setStreet("123 Main St");
//        address.setCity("Anytown");
//
//
//        person.setAddress(address);
//        address.setPerson(person);
//
//        session.save(person);
//
//        // Joinbtable
//
//        Person_CommenJoin person1 = new Person_CommenJoin();
//        person1.setName("Akansha");
//
//        Address_CommenJoin address2= new Address_CommenJoin();
//        address2.setStreet("123 Main St");
//        address2.setCity("Anytown");
//        address2.setState("CA");
//        address2.setZipcode("12345");
//
//        person1.setAddress(address2);
//        address2.setPerson(person1);
//        session.save(person);
//        //Primary key
//        Person_PrimaryShared personPrimaryShared = new Person_PrimaryShared();
//        personPrimaryShared.setName("John Doe");
//
//        Address_primaryShared addressPrimaryShared = new Address_primaryShared();
//        addressPrimaryShared.setId(personPrimaryShared.getId());
//        addressPrimaryShared.setStreet("123 Main St");
//        addressPrimaryShared.setCity("Anytown");
//        addressPrimaryShared.setState("CA");
//        addressPrimaryShared.setZipcode("12345");
//
//        person.setAddress(address);
//        address.setPerson(person);
//
//        session.save(person);
        //many to many
        Student student = new Student();
        student.setName("John Doe");

        Course course = new Course();
        course.setTitle("Introduction to Hibernate");

        student.getCourses().add(course);
        course.getStudents().add(student);

        session.save(student);
        session.save(course);








    }
}
