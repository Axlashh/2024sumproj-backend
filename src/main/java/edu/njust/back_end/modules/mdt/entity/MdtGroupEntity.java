package edu.njust.back_end.modules.mdt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("mdt_group")
@Data
public class MdtGroupEntity extends BaseEntity implements Serializable {

    private String mdtGroupId; // MDT团队id
    private String mdtSecretaryId; // 秘书的id，要求为DoctorEntity的id
    private String mdtMemberIds; // 团队成员的id列表，要求为DoctorEntity的id，用逗号分隔
    private String primaryConditionTreated; // 主治病症
    private String description; // 描述
    private String name;
}
