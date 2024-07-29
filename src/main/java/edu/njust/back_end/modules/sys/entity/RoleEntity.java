package edu.njust.back_end.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("role")
public class RoleEntity extends BaseEntity implements Serializable {

    private String roleId; // 角色id
    private String roleName; // 角色名
    private String remark; // 备注
}
