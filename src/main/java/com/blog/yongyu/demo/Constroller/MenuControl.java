/**
 * created by
 * Date:2019/4/7
 **/
package com.blog.yongyu.demo.Constroller;

import com.blog.yongyu.demo.Entity.BaseClass.DataResult;
import com.blog.yongyu.demo.Entity.Menu;
import com.blog.yongyu.demo.Service.MenuService;
import com.blog.yongyu.demo.Utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuControl{

    @Autowired
    MenuService menuService;

    @RequestMapping("/all")
    public DataResult findAll() {
        List<Menu> all = menuService.findAll();
        return ResultUtils.success(all);
    }

    @RequestMapping("/add")
    public DataResult add(Menu menu) {
        Integer res = menuService.add(menu);
        if (res == 0) {
            return ResultUtils.success();
        }
        return ResultUtils.error(1, "不能为空");
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public DataResult remove(@RequestParam("id") Long id) {
        Integer res = menuService.remove(id);
        if (res == 0) {
            return ResultUtils.success();
        }
        return ResultUtils.error(1, "删除对象不存在");
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public DataResult modify(Menu menu) {
        Integer res = menuService.modify(menu);
        if (res == 0) {
            return ResultUtils.success();
        }
        return ResultUtils.error(1, "对象不能为空");
    }
}