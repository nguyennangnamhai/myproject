package com.macsenh.crudproject.entity;

import com.macsenh.SpringBootProject.entity.User;
import com.macsenh.SpringBootProject.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
     void testAddNew(){
        User user = User.builder().email("macsenh@gmail.com")
                        .password("hai123456")
                        .firstName("Nam")
                        .lastName("Hai")
                        .build();
        User savedUser = userRepository.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
     void testListAll(){
        List<User> userList = userRepository.findAll();
        Assertions.assertThat(userList).hasSizeGreaterThan(0);
        System.out.println(userList);
    }

    @Test
     void testUpdate(){
        Integer userId = 20;
        User user = userRepository.findById(userId).get();
        user.setPassword("van654321");
        userRepository.save(user);

        User updatedUser = userRepository.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("van654321");
    }

    @Test
     void testGet(){
        Integer userId = 20;
        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser);
    }

    @Test
     void testDelete(){
        Integer userId = 3;
        userRepository.deleteById(userId);
        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }


}

