package edu.njust.back_end.modules.mdt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import edu.njust.back_end.modules.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@TableName("mdt_file")
@Data
public class MdtFileEntity extends BaseEntity implements Serializable {
    private String mdtFileId; // 资料id
    private String fileName; // 文件名称
    private String fileDesc; // 文件描述
    private String fileUrl; // 文件存储的路径
    private String fileType; // 文件类型
}
