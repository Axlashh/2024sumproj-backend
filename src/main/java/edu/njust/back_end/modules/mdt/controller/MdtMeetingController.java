package edu.njust.back_end.modules.mdt.controller;

import edu.njust.back_end.modules.mdt.dto.MdtMeetingListWrapper;
import edu.njust.back_end.modules.mdt.entity.MdtMeetingEntity;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import edu.njust.back_end.modules.mdt.service.MdtMeetingService;
import edu.njust.back_end.modules.mdt.service.MdtRecordService;
import edu.njust.back_end.modules.utils.AbstractController;
import edu.njust.back_end.modules.utils.R;
import edu.njust.back_end.modules.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/mdtMeeting")
public class MdtMeetingController extends AbstractController {
    @Autowired
    MdtRecordService mdtRecordService;

    @Autowired
    MdtMeetingService mdtMeetingService;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @PostMapping("/getMdtMeetingList")
    public R<?> getMdtMeetingList(@RequestBody MdtMeetingListWrapper mdtMeetingListWrapper) {
        MdtRecordEntity mdtRecord = mdtRecordService.getById(mdtMeetingListWrapper.getMdtRecordId());
        if (mdtRecord == null) {
            return R.error("MDT记录不存在");
        }
        mdtMeetingListWrapper = mdtMeetingService.getMdtMeetingList(mdtRecord.mdtMeetingIds);
        return R.ok(mdtMeetingListWrapper);
    }

    @PostMapping("/meetingTimeCommit")
    public R<?> meetingTimeCommit(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime, @RequestParam("mdtRecordId") String mdtRecordId) {
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, FORMATTER);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, FORMATTER);

        // 将 LocalDateTime 转换为 Date
        Date startDate = java.sql.Timestamp.valueOf(startDateTime);
        Date endDate = java.sql.Timestamp.valueOf(endDateTime);
        MdtMeetingEntity mdtMeeting = new MdtMeetingEntity();
        mdtMeeting.setMdtMeetingId(UuidUtil.randomUUID());
        mdtMeeting.setStartTime(startDate);
        mdtMeeting.setEndTime(endDate);
        mdtMeetingService.save(mdtMeeting);

        //更改mdtRecord的mdtMeetingIds
        MdtRecordEntity mdtRecord = mdtRecordService.getById(mdtRecordId);
        String mdtMeetingIds = mdtRecord.getMdtMeetingIds();
        String[] idsArray = mdtMeetingIds.split(",");
        List<String> idList = new ArrayList<>(Arrays.stream(idsArray)
                .map(String::trim)
                .toList());
        idList.add(mdtMeeting.getMdtMeetingId());
        String result = String.join(",", idList);
        if (result.startsWith(",")) {
            result = result.substring(1); // 删除第一个逗号
        }
        mdtRecord.setMdtMeetingIds(result);
        mdtRecordService.updateById(mdtRecord);
        return R.ok();
    }
}
