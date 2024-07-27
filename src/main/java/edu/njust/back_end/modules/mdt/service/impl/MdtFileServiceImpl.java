package edu.njust.back_end.modules.mdt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.mdt.dao.MdtFileDao;
import edu.njust.back_end.modules.mdt.entity.MdtFileEntity;
import edu.njust.back_end.modules.mdt.service.MdtFileService;
import edu.njust.back_end.modules.mdt.service.MdtRecordService;
import org.springframework.stereotype.Service;

@Service
public class MdtFileServiceImpl extends ServiceImpl<MdtFileDao, MdtFileEntity> implements MdtFileService{
}
