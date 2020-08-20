package org.shihe;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author admin
 * @Date 2020-08-19 17:32
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findUserByUsername(String name);
}
