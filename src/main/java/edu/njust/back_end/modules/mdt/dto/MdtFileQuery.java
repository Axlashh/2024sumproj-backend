package edu.njust.back_end.modules.mdt.dto;

import edu.njust.back_end.modules.mdt.entity.MdtFileEntity;
import lombok.Data;

@Data
public class MdtFileQuery extends MdtFileEntity {
    public String patientId;
    public String mdtFileIds;
    public Boolean isSyn;
}
