package edu.njust.back_end.modules.mdt.controller;

import edu.njust.back_end.modules.mdt.entity.MdtGroupEntity;
import edu.njust.back_end.modules.mdt.service.MdtGroupService;
import edu.njust.back_end.modules.utils.AbstractController;
import edu.njust.back_end.modules.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mdtGroup")
public class MdtGroupController extends AbstractController {
    @Autowired
    MdtGroupService mdtGroupService;

    @GetMapping("/list")
    public R<?> getMdtGroupList() {
        List<MdtGroupEntity> mdtGroupEntityList = mdtGroupService.list();
        return R.ok(mdtGroupEntityList);
    }
}
