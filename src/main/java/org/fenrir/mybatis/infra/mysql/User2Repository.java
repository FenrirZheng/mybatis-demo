package org.fenrir.mybatis.infra.mysql;

import org.fenrir.mybatis.domain.UserEntity;

import java.util.List;

public interface User2Repository {

    List<UserEntity> getAll(Long id);

}
