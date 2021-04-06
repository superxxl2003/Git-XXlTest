package com.xxlspringboot.usermanage.repository;

import com.xxlspringboot.usermanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public List<User> findByName(String name);

    public User findById(long id);

    public User findByEmail(String email);

    public List<User> findByAddressCity(String city);

    public User save(User user);
}

