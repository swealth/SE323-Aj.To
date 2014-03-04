package cbsd.lab11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/9/13
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO dao;
    @Override
    @Transactional
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }
}
