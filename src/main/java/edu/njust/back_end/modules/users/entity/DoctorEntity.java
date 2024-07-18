package edu.njust.back_end.modules.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseQuery;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@TableName("doctor")
@Data
public class DoctorEntity extends BaseQuery implements Serializable {
    private String doctorId; // 医生id
    private String userId; // 该医生对应的用户id
    private String idCardNumber; // 身份证号
    private Integer gender; // 性别(0为女 1为男)
    private Integer title; // 职称(具体对应关系根据字典表来查)
    private String name; // 姓名
    private String department; // 所属部门
    private String staffId; // 工号
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间

}
