package edu.njust.back_end.modules.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.njust.back_end.modules.sys.entity.MenuEntity;
import edu.njust.back_end.modules.sys.service.MenuService;
import edu.njust.back_end.modules.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/list")
    public R<?> getList(@RequestBody MenuEntity menuEntity) {
        PageHelper.startPage(menuEntity.getPage(), menuEntity.getLimit());
        List<MenuEntity> dictionaries = menuService.queryAll(menuEntity);
        PageInfo<MenuEntity> page = new PageInfo<>(dictionaries);
        PageUtils<MenuEntity> pageUtil = new PageUtils<>(page);
        return R.ok(pageUtil);
    }

    @PostMapping("addMenu")
    @Create
    public R<?> addMenu(@RequestBody MenuEntity menuEntity) {
        menuEntity.setMenuId(UuidUtil.randomUUID());
        menuService.save(menuEntity);
        return R.ok();
    }

    @PostMapping("deleteMenu")
    @Create
    public R<?> deleteMenu(@RequestBody MenuEntity menuEntity) {
        menuService.removeById(menuEntity);
        return R.ok();
    }

    @PostMapping("updateMenu")
    @Update
    public R<?> updateMenu(@RequestBody MenuEntity menuEntity) {
        menuService.updateById(menuEntity);
        return R.ok();
    }
}
