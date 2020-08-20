package org.shihe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author admin
 * @Date 2020-08-19 17:33
 * @Version 1.0
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
