package edu.njust.back_end.modules.sys.controller;

import edu.njust.back_end.modules.sys.entity.DictionaryEntity;
import edu.njust.back_end.modules.sys.service.DictionaryService;
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

    @GetMapping("/list")
    public ResponseEntity<List<DictionaryEntity>> getList() {
        List<DictionaryEntity> dictionaries = dictionaryService.getAllDictionaries();
        return ResponseEntity.ok(dictionaries);
    }

    // 如果需要，根据业务需求添加更多的查询方法
}
