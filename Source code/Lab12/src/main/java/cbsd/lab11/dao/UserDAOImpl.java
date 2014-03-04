package cbsd.lab11.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import cbsd.lab11.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/2/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Md5PasswordEncoder encoder;

    @Override
    public User findByUsername(String username) {
        User user = (User) sessionFactory.getCurrentSession().createQuery
                ("from User u where u.username ='"+ username +"'").uniqueResult();
        return user;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(encoder.encodePassword(user.getPassword(),null));
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
