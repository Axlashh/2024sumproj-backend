package edu.njust.back_end.modules.mdt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.njust.back_end.modules.mdt.dto.MdtRecordQuery;
import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;

import java.util.List;

public interface MdtRecordService extends IService<MdtRecordEntity> {
    public List<MdtRecordQuery> queryAll(MdtRecordQuery query);
}
