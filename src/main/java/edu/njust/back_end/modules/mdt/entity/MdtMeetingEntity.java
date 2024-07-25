package edu.njust.back_end.modules.mdt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("mdt_meeting")
@Data
public class MdtMeetingEntity extends BaseEntity implements Serializable {
    private String mdtMeetingId; // 联合会议id
    private Date startTime; // 会议开始时间
    private Date endTime; // 会议结束时间
    private String meetingMinutes; // 对于会议的记录
    private String treatmentFeedback; // 患者的疗效反馈
}
