package cn.tedu.store.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 */
@Setter
@Getter
@ToString
abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -3122958702938259476L;

    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;


}
