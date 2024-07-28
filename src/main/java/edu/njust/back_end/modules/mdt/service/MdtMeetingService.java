package edu.njust.back_end.modules.mdt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.njust.back_end.modules.mdt.dto.MdtMeetingListWrapper;
import edu.njust.back_end.modules.mdt.entity.MdtMeetingEntity;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;

public interface MdtMeetingService extends IService<MdtMeetingEntity> {
    public MdtMeetingListWrapper getMdtMeetingList(String mdtMeetingIds);
}
