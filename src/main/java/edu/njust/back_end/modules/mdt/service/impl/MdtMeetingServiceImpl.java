package edu.njust.back_end.modules.mdt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.mdt.dao.MdtMeetingDao;
import edu.njust.back_end.modules.mdt.dao.MdtRecordDao;
import edu.njust.back_end.modules.mdt.dto.MdtMeetingListWrapper;
import edu.njust.back_end.modules.mdt.entity.MdtMeetingEntity;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import edu.njust.back_end.modules.mdt.service.MdtMeetingService;
import edu.njust.back_end.modules.mdt.service.MdtRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MdtMeetingServiceImpl extends ServiceImpl<MdtMeetingDao, MdtMeetingEntity> implements MdtMeetingService {

    @Autowired
    MdtMeetingDao mdtMeetingDao;
    @Override
    public MdtMeetingListWrapper getMdtMeetingList(String mdtMeetingIds) {
        String[] idsArray = mdtMeetingIds.split(",");
        List<String> idList = new ArrayList<>(Arrays.stream(idsArray)
                .map(String::trim)
                .toList());
        List<MdtMeetingEntity> mdtMeetingEntities = new ArrayList<>();
        for (String id : idList) {
            MdtMeetingEntity mdtMeeting = mdtMeetingDao.selectById(id);
            if (mdtMeeting == null) continue;
            mdtMeetingEntities.add(mdtMeeting);
        }
        //照startTime排序，时间晚的排在前面
        mdtMeetingEntities.sort(Comparator.comparing(MdtMeetingEntity::getStartTime).reversed());
        MdtMeetingListWrapper mdtMeetingListWrapper = new MdtMeetingListWrapper();
        mdtMeetingListWrapper.setMdtMeetingList(mdtMeetingEntities);
        if (mdtMeetingEntities.isEmpty()) {
            mdtMeetingListWrapper.setAppointment(true);
        } else {
            mdtMeetingListWrapper.setAppointment(mdtMeetingEntities.get(0).getEndTime().before(new Date()));
        }
        return mdtMeetingListWrapper;
    }
}
