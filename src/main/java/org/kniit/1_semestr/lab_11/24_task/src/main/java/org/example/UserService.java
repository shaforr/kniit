package org.example;

import java.util.regex.Pattern;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final UserDAO dao = new UserDAOImpl();

    public void registerUser(String name, String email) throws SQLException {
        if (dao.emailExists(email) || !Pattern.matches(emailPattern, email)) {
            throw new IllegalArgumentException("Email не валидный или уже существует");
        }
        dao.create(new User(name, email));
    }

    public List<User> listAllUsers() throws SQLException {
        return dao.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        if (dao.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
        dao.delete(id);
    }

    public void updateUser(int id, String name, String email) throws SQLException {
        User user = dao.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
        if (!user.getEmail().equals(email) && dao.emailExists(email)) {
            throw new IllegalArgumentException("Email уже используется");
        }
        user.setName(name);
        user.setEmail(email);
        dao.update(user);
    }
}
