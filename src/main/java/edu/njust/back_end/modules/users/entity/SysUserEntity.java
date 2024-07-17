package edu.njust.back_end.modules.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseQuery;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@TableName("sys_user")
@Data
public class SysUserEntity  extends BaseQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String userId; // 用户id
    private String userName; // 用户名
    private String password; // 用户密码
    private String salt; // 盐值，用于加密
    private String phone; // 手机号
    private String email; // 邮箱号
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}
