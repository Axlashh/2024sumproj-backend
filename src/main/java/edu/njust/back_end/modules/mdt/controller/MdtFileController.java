package edu.njust.back_end.modules.mdt.controller;

import edu.njust.back_end.modules.mdt.dto.MdtFileQuery;
import edu.njust.back_end.modules.mdt.dto.MdtRecordQuery;
import edu.njust.back_end.modules.mdt.entity.MdtFileEntity;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import edu.njust.back_end.modules.mdt.service.MdtFileService;
import edu.njust.back_end.modules.mdt.service.MdtRecordService;
import edu.njust.back_end.modules.utils.AbstractController;
import edu.njust.back_end.modules.utils.Create;
import edu.njust.back_end.modules.utils.R;
import edu.njust.back_end.modules.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/mdtFile")
public class MdtFileController extends AbstractController {
    @Autowired
    MdtFileService mdtFileService;

    @Autowired
    MdtRecordService mdtRecordService;

    @PostMapping("/list")
    public R<?> getFileList(@RequestBody MdtRecordEntity mdtRecord) {
        String[] idsArray = mdtRecord.getMdtFileIds().split(",");

        List<String> idList = Arrays.stream(idsArray)
                .map(String::trim)
                .collect(Collectors.toList());

        List<MdtFileEntity> mdtFileEntityList = mdtFileService.listByIds(idList);
        return R.ok(mdtFileEntityList);
    }

    @PostMapping("/commitFile")
    @Create
    public R<?> commitFile(@RequestBody MdtFileEntity mdtFileEntity) {
        mdtFileEntity.setMdtFileId(UuidUtil.randomUUID());
        mdtFileService.save(mdtFileEntity);
        return R.ok();
    }

    @PostMapping("/getPatientFile")
    public R<?> getPatientFile(@RequestBody MdtFileQuery mdtFileQuery) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("patient_id", mdtFileQuery.patientId);
        List<MdtFileEntity> mdtFileEntityList = mdtFileService.listByMap(map);
        List<MdtFileQuery> patientFileList = new ArrayList<>();
        String[] idsArray = mdtFileQuery.getMdtFileIds().split(",");
        List<String> idList = Arrays.stream(idsArray)
                .map(String::trim)
                .toList();
        for (MdtFileEntity item : mdtFileEntityList) {
            MdtFileQuery newItem = new MdtFileQuery();
            BeanUtils.copyProperties(item, newItem);
            newItem.setIsSyn(idList.contains(item.getMdtFileId()));
            patientFileList.add(newItem);
        }
        return R.ok(patientFileList);
    }

    @PostMapping("/synFile")
    public R<?> synOneFile(@RequestBody MdtRecordQuery mdtRecordQuery) {
        String[] idsArray = mdtRecordQuery.getMdtFileIds().split(",");
        List<String> idList = new ArrayList<>(Arrays.stream(idsArray)
                .map(String::trim)
                .toList());
        idList.add(mdtRecordQuery.mdtFileId);
        String result = String.join(",", idList);
        MdtRecordEntity mdtRecord = new MdtRecordEntity();
        BeanUtils.copyProperties(mdtRecordQuery, mdtRecord);
        mdtRecord.setMdtFileIds(result);
        mdtRecordService.save(mdtRecord);
        return R.ok();
    }
}
