package dao;

import model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    void insertPerson(Person person) throws SQLException, IOException;

    List<Person> selectAllTodos();

    boolean deleteTodo( int id) throws SQLException;

    int updateTodo(int id, Person updatedBook) throws SQLException, IOException;
}
