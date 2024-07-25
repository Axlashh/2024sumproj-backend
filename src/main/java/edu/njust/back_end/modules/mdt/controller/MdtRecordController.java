package edu.njust.back_end.modules.mdt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.njust.back_end.modules.mdt.dao.MdtGroupDao;
import edu.njust.back_end.modules.mdt.dao.MdtRecordDao;
import edu.njust.back_end.modules.mdt.dto.MdtRecordQuery;
import edu.njust.back_end.modules.mdt.entity.MdtGroupEntity;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import edu.njust.back_end.modules.mdt.service.MdtRecordService;
import edu.njust.back_end.modules.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mdt")
public class MdtRecordController extends AbstractController {

    @Autowired
    MdtRecordDao mdtRecordDao;

    @Autowired
    MdtRecordService mdtRecordService;

    @Autowired
    MdtGroupDao mdtGroupDao;

    @Create
    @PostMapping("/appointmentApply")
    public R<?> appointmentApply(@RequestBody MdtRecordEntity mdtRecord) {
        HashMap<String, Object> map = new HashMap<>();
        if (mdtRecord.getPatientId() == null || mdtRecord.getPatientId().isEmpty()
        ||  mdtRecord.getMdtGroupId() == null || mdtRecord.getMdtGroupId().isEmpty()) {
            return R.error("请求的患者和团队不能为空");
        }
        List<MdtRecordQuery> list = mdtRecordService.queryAll(new MdtRecordQuery(mdtRecord));
        if (list != null && !list.isEmpty()) {
            //列表中已有该患者与该mdt团队的记录，申请不通过
            return R.error("已有申请记录");
        }
        mdtRecord.setMdtRecordId(UuidUtil.randomUUID());
        //插入该条记录
        mdtRecordDao.insert(mdtRecord);
        return R.ok();
    }

    @PostMapping("/getMdtRecordList")
    public R<?> getMdtRecordList(@RequestBody MdtRecordQuery mdtRecordQuery) {
        PageHelper.startPage(mdtRecordQuery.getPage(), mdtRecordQuery.getLimit());
        List<MdtRecordQuery> mdtRecordQueryList = mdtRecordService.queryAll(mdtRecordQuery);
        PageInfo<MdtRecordQuery> page = new PageInfo<>(mdtRecordQueryList);
        PageUtils<MdtRecordQuery> pageUtil = new PageUtils<>(page);
        return R.ok(pageUtil);
    }

    @GetMapping("/getMdtGroupList")
    public R<?> getMdtGroupList() {
        List<MdtGroupEntity> mdtGroupEntityList = mdtGroupDao.selectByMap(new HashMap<>());
        return R.ok(mdtGroupEntityList);
    }
}
