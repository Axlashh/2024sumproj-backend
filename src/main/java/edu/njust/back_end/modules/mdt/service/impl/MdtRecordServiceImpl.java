package edu.njust.back_end.modules.mdt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.njust.back_end.modules.mdt.dao.MdtRecordDao;
import edu.njust.back_end.modules.mdt.dto.MdtRecordQuery;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import edu.njust.back_end.modules.mdt.service.MdtRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MdtRecordServiceImpl extends ServiceImpl<MdtRecordDao, MdtRecordEntity> implements MdtRecordService {
    @Override
    public List<MdtRecordQuery> queryAll(MdtRecordQuery query) {
        return baseMapper.queryAll(query);
    }
}
