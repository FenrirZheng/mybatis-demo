package org.fenrir.mybatis.service;


import jakarta.annotation.PostConstruct;
import org.fenrir.mybatis.domain.PageUtils;
import org.fenrir.mybatis.domain.UserEntity;
import org.fenrir.mybatis.infra.mysql.User2Repository;
import org.fenrir.mybatis.infra.mysql.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;

@Component
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    private final UserRepository userMapper;

    private final User2Repository user2Repository;

    @Value("${org.fenrir.mybatis.demo.simple}")
    private boolean isDemoSimple;

    @Value("${org.fenrir.mybatis.demo.page-select}")
    private boolean isPageSelect;

    public TestService(UserRepository userMapper, User2Repository user2Repository) {
        this.userMapper = userMapper;
        this.user2Repository = user2Repository;
    }

    @PostConstruct
    public void construct() {
        var executor = Executors.newFixedThreadPool(8);
        if (isDemoSimple) {
            var a = new Thread(this::runProgram);
            a.start();
        }
        if (isPageSelect) {
            executor.execute(this::demoPageSelect);
        }
    }

    private void demoPageSelect() {
        var total = userMapper.count();
        logger.info("total is {}", total);
        var pageInfo = PageUtils.getPageInfo(0, 2, total);
        logger.info("page info {}", pageInfo);
        List<UserEntity> userEntities = userMapper.selectPage(pageInfo);
        logger.info("result is : {}", userEntities);
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
