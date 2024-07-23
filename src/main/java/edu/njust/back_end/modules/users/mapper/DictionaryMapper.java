package edu.njust.back_end.modules.users.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.njust.back_end.modules.users.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictionaryMapper extends BaseMapper<DictionaryEntity> {

}
