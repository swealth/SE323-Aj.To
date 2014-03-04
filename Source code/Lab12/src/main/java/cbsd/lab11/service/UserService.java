package cbsd.lab11.service;


import cbsd.lab11.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/9/13
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public User findByUsername(String username);
    public void addUser(User user);
}
