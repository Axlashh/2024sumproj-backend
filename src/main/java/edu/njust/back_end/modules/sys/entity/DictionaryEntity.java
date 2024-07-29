package edu.njust.back_end.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import edu.njust.back_end.modules.utils.BaseQuery;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("dictionary")
@Data
public class DictionaryEntity extends BaseEntity implements Serializable {
    String dictionaryId;
    String type;
    Integer code;
    String value;
    Integer orderNum;
    String remark;
}