package org.shihe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShiheSpringbootSecurityJpaApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("shihe");
        user.setPassword("123456");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        List<Role> roles =new ArrayList<>();
        roles.add(new Role("ROLE_admin","管理员"));

        user.setRoles(roles);

        userDao.save(user);

        User user1 = new User();
        user1.setUsername("lisi");
        user1.setPassword("123456");
        user1.setAccountNonExpired(true);
        user1.setAccountNonLocked(true);
        user1.setCredentialsNonExpired(true);
        user1.setEnabled(true);

        List<Role> roles1 =new ArrayList<>();
        roles1.add(new Role("ROLE_user","普通用户"));

        user1.setRoles(roles1);

        userDao.save(user1);

    }

}
