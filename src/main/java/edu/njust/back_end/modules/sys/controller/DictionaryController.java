package edu.njust.back_end.modules.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.njust.back_end.modules.mdt.dto.MdtRecordQuery;
import edu.njust.back_end.modules.sys.entity.DictionaryEntity;
import edu.njust.back_end.modules.sys.service.DictionaryService;
import edu.njust.back_end.modules.utils.Create;
import edu.njust.back_end.modules.utils.PageUtils;
import edu.njust.back_end.modules.utils.R;
import edu.njust.back_end.modules.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/{id}")
    public DictionaryEntity getDictionaryById(@PathVariable String id) {
        return dictionaryService.getById(id);
    }

    @PostMapping("/list")
    public R<?> getList(@RequestBody DictionaryEntity dictionaryEntity) {
        PageHelper.startPage(dictionaryEntity.getPage(), dictionaryEntity.getLimit());
        List<DictionaryEntity> dictionaries = dictionaryService.queryAll(dictionaryEntity);
        PageInfo<DictionaryEntity> page = new PageInfo<>(dictionaries);
        PageUtils<DictionaryEntity> pageUtil = new PageUtils<>(page);
        return R.ok(pageUtil);
    }

    @PostMapping("addDict")
    @Create
    public R<?> addDict(@RequestBody DictionaryEntity dictionaryEntity) {
        dictionaryEntity.setDictionaryId(UuidUtil.randomUUID());
        dictionaryService.save(dictionaryEntity);
        return R.ok();
    }

    @PostMapping("deleteDict")
    @Create
    public R<?> deleteDict(@RequestBody DictionaryEntity dictionaryEntity) {
        dictionaryService.removeById(dictionaryEntity);
        return R.ok();
    }
}
