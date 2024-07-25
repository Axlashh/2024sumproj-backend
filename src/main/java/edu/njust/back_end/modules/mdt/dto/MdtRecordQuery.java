package edu.njust.back_end.modules.mdt.dto;

import edu.njust.back_end.modules.mdt.entity.MdtRecordEntity;
import org.springframework.beans.BeanUtils;

public class MdtRecordQuery extends MdtRecordEntity {
    public MdtRecordQuery() {

    }
    public MdtRecordQuery(MdtRecordEntity entity) {
        if (entity != null) {
            // 使用 Spring BeanUtils 复制属性
            BeanUtils.copyProperties(entity, this);
        }
    }

    public String patientName;
    public String mdtGroupName;
    public String applyDoctorName;
}
