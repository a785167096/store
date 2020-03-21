package cn.tedu.store.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户数据的实体类
 */
@Setter
@Getter
@ToString
//@EqualsAndHashCode
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}



}
