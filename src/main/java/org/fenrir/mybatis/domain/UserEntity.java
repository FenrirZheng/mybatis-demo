package org.fenrir.mybatis.domain;


public class UserEntity {

    private String uid;

    private String mobile;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid='" + uid + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
