package org.fenrir.mybatis.infra.mysql;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.fenrir.mybatis.domain.PageInfoQuery;
import org.fenrir.mybatis.domain.UserEntity;

import java.util.List;

public interface UserRepository {

    @Select("SELECT uid, mobile FROM game_main.user_list")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "mobile", column = "mobile")
    })
    List<UserEntity> getAll();

    /**
     *
     * @param pageInfo mybatis query object只能帶一個
     * @return
     */
    @SelectProvider(type = UserPageProvider.class, method = "select")
    List<UserEntity> selectPage(PageInfoQuery pageInfo);

    @SelectProvider(type = UserPageProvider.class, method = "count")
    Integer count();

    class UserPageProvider {

        public String count() {
            return new SQL() {{
                SELECT("count(id)");
                FROM("game_main.user_list");
            }}.toString();
        }

        public String select() {
            return new SQL() {{
                SELECT("uid, mobile");
                FROM("game_main.user_list");
                WHERE();
                LIMIT("#{offset}, #{pageSize}");
            }}.toString();
        }
    }

}