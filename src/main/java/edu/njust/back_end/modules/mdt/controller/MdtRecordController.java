package edu.njust.back_end.modules.mdt.controller;

import edu.njust.back_end.modules.mdt.dao.MdtRecordDao;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import edu.njust.back_end.modules.utils.AbstractController;
import edu.njust.back_end.modules.utils.Create;
import edu.njust.back_end.modules.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mdt")
public class MdtRecordController extends AbstractController {

    @Autowired
    MdtRecordDao mdtRecordDao;

    @Create
    @PostMapping("/appointmentApply")
    public R<?> appointmentApply(@RequestBody MdtRecordEntity mdtRecord) {
        HashMap<String, Object> map = new HashMap<>();
        if (mdtRecord.getPatientId() == null || mdtRecord.getPatientId().isEmpty()
        ||  mdtRecord.getMdtGroupId() == null || mdtRecord.getMdtGroupId().isEmpty()) {
            return R.error("请求的患者和团队不能为空");
        }
        map.put("patient_id", mdtRecord.getPatientId());
        map.put("mdt_group_id", mdtRecord.getMdtGroupId());
        List<MdtRecordEntity> list = mdtRecordDao.selectByMap(map);
        if (list != null && !list.isEmpty()) {
            //列表中已有该患者与该mdt团队的记录，申请不通过
            return R.error("已有申请记录");
        }
        //插入该条记录
        mdtRecordDao.insert(mdtRecord);
        return R.ok();
    }
}
