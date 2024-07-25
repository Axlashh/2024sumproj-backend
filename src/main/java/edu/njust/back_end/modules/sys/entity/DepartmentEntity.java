package edu.njust.back_end.modules.sys.entity;

import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DepartmentEntity extends BaseEntity implements Serializable {

    private String departmentId; // 部门id
    private String name; // 部门名称
    private String description; // 部门描述
    private String manager; // 部门主管id
}
