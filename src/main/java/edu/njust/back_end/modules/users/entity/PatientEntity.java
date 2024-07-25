package edu.njust.back_end.modules.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import edu.njust.back_end.modules.utils.BaseQuery;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@TableName("patient")
@Data
public class PatientEntity extends BaseEntity implements Serializable {
    private String patientId; // 患者id
    private String userId; // 该患者对应的用户id
    private String idCardNumber; // 身份证号
    private int gender; // 性别(0为女 1为男)
    private String name; // 姓名
    private String description; // 对该患者的简单描述

}
