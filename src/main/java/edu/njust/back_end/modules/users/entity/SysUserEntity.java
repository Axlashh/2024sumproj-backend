package edu.njust.back_end.modules.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import edu.njust.back_end.modules.utils.BaseQuery;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@TableName("sys_user")
@Data
public class SysUserEntity extends BaseEntity implements Serializable {
    private String userId; // 用户id
    private String userName; // 用户名
    private String password; // 用户密码
    private String salt; // 盐值，用于加密
    private String phone; // 手机号
    private String email; // 邮箱号
}
