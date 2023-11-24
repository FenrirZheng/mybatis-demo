package org.fenrir.mybatis.infra.mysql;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.fenrir.mybatis.domain.UserEntity;

import java.util.List;

public interface UserRepository {

    @Select("SELECT uid, mobile FROM game_main.user_list")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "mobile", column = "mobile")
    })
    List<UserEntity> getAll();

}