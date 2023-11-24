package org.fenrir.mybatis.service;


import jakarta.annotation.PostConstruct;
import org.fenrir.mybatis.domain.UserEntity;
import org.fenrir.mybatis.infra.mysql.User2Repository;
import org.fenrir.mybatis.infra.mysql.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    private final UserRepository userMapper;

    private final User2Repository user2Repository;

    public TestService(UserRepository userMapper, User2Repository user2Repository) {
        this.userMapper = userMapper;
        this.user2Repository = user2Repository;
    }

    @PostConstruct
    public void construct() {
        var a = new Thread(this::runProgram);
        a.start();
    }


    public void runProgram() {
        try {
            List<UserEntity> v = userMapper.getAll();
            logger.info("user list is , {}", v);
            List<UserEntity> all = user2Repository.getAll(37L);
            logger.info("user list (xm_mapper) is , {}", all);
        } catch (Exception e) {
            logger.error("failed on run program", e);
        }
    }
}
