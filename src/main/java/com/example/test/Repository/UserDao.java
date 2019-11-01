package com.example.test.Repository;

import com.example.test.Model.User;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String username);

    @Query(value = "select * FROM user where active = true", nativeQuery = true)
    public List<User> getActiveUsers();
}
