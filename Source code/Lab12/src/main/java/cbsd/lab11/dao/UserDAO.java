package cbsd.lab11.dao;

import cbsd.lab11.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/2/13
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    public User findByUsername(String username);
    public void addUser(User user);
}
