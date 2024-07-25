package edu.njust.back_end.modules.mdt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("mdt_record")
@Data
public class MdtRecordEntity extends BaseEntity implements Serializable{
    private String mdtRecordId; // 记录的唯一id
    private String patientId; // 病人id
    private String applyDoctorId; // 申请医生id
    private String mdtFileIds; // 资料id的列表，用逗号分隔
    private String mdtMeetingIds; // 联合会议id的列表，用逗号分隔
    private String mdtGroupId; // 负责治疗的MDT团队id
    private String applyReason; // 申请MDT的原因
}