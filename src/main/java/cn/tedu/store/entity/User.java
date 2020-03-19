package cn.tedu.store.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * 用户数据的实体类
 */
@Setter
@Getter
@ToString
public class User extends BaseEntity {

    private static final long serialVersionUID = -3302907460554699349L;

    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private Integer gender;
    private String phone;
    private String email;
    private String avatar;
    private Integer isDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return uid.equals(user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
