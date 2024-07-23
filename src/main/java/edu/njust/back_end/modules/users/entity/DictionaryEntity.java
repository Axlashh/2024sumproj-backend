package edu.njust.back_end.modules.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseQuery;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("dictionary")
@Data
public class DictionaryEntity extends BaseQuery implements Serializable {
    String dictionaryId;
    String type;
    Integer code;
    String value;
    Integer order_num;
    String remark;
    Date createTime;
    Date updateTime;
}