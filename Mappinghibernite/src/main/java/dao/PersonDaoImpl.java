package dao;

import model.Address;
import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PersonDaoImpl implements PersonDao{
    Scanner scanner = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Configuration CONFIGURATION = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Person.class).addAnnotatedClass(Address.class);
    private static final SessionFactory SESSION_FACTORY = CONFIGURATION.buildSessionFactory();

    @Override
    public void insertPerson(Person person) throws SQLException, IOException {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("ENTER PID");
        person.setId(Integer.parseInt(br.readLine()));

        System.out.println("ENTER NAME ");
        person.setName(br.readLine());

        System.out.println("ENTER ADDERSESS\n");
        Address address = new Address();

        System.out.println("ENTER AID");
        address.setId(Integer.parseInt(br.readLine()));

        System.out.println("ENTER CITY");
        address.setCity(br.readLine());

        System.out.println("ENTER STREET");
        address.setStreet(br.readLine());

        System.out.println("ENTER PERSONID");
        address.setPerson(person);

        session.save(address);
        System.out.println("PERSON ADDRESS SAVE");
        //IMP
        session.save(person);
        System.out.println("PERSON ADDRESS SAVE");

        transaction.commit();
        session.close();


    }

    @Override
    public List<Person> selectAllTodos() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();

        return null;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public int updateTodo(int id, Person updatedBook) throws SQLException, IOException {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();

        return 0;
    }
}
