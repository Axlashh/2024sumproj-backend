package edu.njust.back_end.modules.mdt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.mdt.dao.MdtFileDao;
import edu.njust.back_end.modules.mdt.dao.MdtGroupDao;
import edu.njust.back_end.modules.mdt.entity.MdtFileEntity;
import edu.njust.back_end.modules.mdt.entity.MdtGroupEntity;
import edu.njust.back_end.modules.mdt.service.MdtFileService;
import edu.njust.back_end.modules.mdt.service.MdtGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MdtGroupServiceImpl extends ServiceImpl<MdtGroupDao, MdtGroupEntity> implements MdtGroupService {
}
