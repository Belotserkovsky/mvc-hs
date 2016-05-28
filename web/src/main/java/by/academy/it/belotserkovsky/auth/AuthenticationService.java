package by.academy.it.belotserkovsky.auth;

import by.academy.it.belotserkovsky.services.IUserService;
import by.academy.it.belotserkovsky.pojos.constants.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import by.academy.it.belotserkovsky.pojos.User;

/**
 * Created by K.Belotserkovsky
 */
@Service("authService")
public class AuthenticationService implements UserDetailsService {
    private static Logger log = Logger.getLogger(AuthenticationService.class);

    @Autowired
    private IUserService userService;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.getUserByUserName(userName);
        System.out.println("User : " + user);
        if (user == null) {
            log.error("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                Role.USER.getType().equals(user.getRole()), true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
