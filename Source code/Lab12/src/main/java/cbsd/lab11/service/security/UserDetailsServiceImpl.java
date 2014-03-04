package cbsd.lab11.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 3/3/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserDAO userDAO;
    /**
     * Locates the user based on the username. In the actual implementation, the search may possibly be case
     * insensitive, or case insensitive depending on how the implementation instance is configured. In this case, the
     * <code>UserDetails</code> object that comes back may have a username that is of a different case than what was
     * actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *          if the user could not be found or the user has no GrantedAuthority
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = null;
        try{
            User appUser = userDAO.findByUsername(username);
            user = new org.springframework.security.core.userdetails.User(
                    appUser.getUsername(),appUser.getPassword().toLowerCase(),
                    true,true,true,true,getAuthorities(appUser.getRole()));
        }catch (Exception e){
            throw new UsernameNotFoundException("Error in retrieving data");
        }
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities(Integer access) {
        // Create a list of grants for this user
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        // All users are granted with ROLE_USER access
        // Therefore this user gets a ROLE_USER by default

        authList.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        // Check if this user has admin access
        // We interpret Integer(1) as an admin user
        if ( access.compareTo(1) == 0) {
            // User has admin access
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        // Return list of granted authorities
        return authList;
    }
}
