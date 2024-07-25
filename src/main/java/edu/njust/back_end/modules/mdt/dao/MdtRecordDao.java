package edu.njust.back_end.modules.mdt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.njust.back_end.modules.mdt.dto.MdtRecordQuery;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;

import java.util.List;

public interface MdtRecordDao extends BaseMapper<MdtRecordEntity> {
    List<MdtRecordQuery> queryAll(MdtRecordQuery query);
}
