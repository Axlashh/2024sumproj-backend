package edu.njust.back_end.modules.mdt.dto;

import edu.njust.back_end.modules.mdt.entity.MdtMeetingEntity;
import lombok.Data;

import java.util.List;

@Data
public class MdtMeetingListWrapper {
    String mdtRecordId;
    List<MdtMeetingEntity> mdtMeetingList;
    boolean appointment;
}
