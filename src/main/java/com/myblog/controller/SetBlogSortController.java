package com.myblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.entity.SetBlogSort;
import com.myblog.service.SetBlogSortService;
import com.myblog.common.lang.RspData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemoncc
 * @since 2020-12-15
 */
@Api(value = "SetBlogSortController")
@RestController
@RequestMapping("/setBlogSort")
public class SetBlogSortController {

    static Logger logger = LoggerFactory.getLogger(SetBlogSortController.class);

    @Autowired
    private SetBlogSortService setBlogSortService;

    /**
     * 查询所有SetBlogSort
     * @return 实体
     */
    @ApiOperation("查询所有SetBlogSort")
    @RequestMapping(value = "/findAll", method = {RequestMethod.GET})
    public RspData findAll() {
        return RspData.success(setBlogSortService.list());
    }

    /**
     * 根据id查询
     * @param id id
     * @return 实体
     */
    @ApiOperation("根据id查询")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public RspData findById(@PathVariable("id") Long id) {
        if (id == null) {
            logger.error("id is null");
            return RspData.invalidParameter();
        }
        return RspData.success(setBlogSortService.getById(id));
    }

    /**
     * 增加或更新数据
     * @param setBlogSort SetBlogSort
     * @return 实体
     */
    @ApiOperation("增加或更新数据")
    @RequestMapping(value = {"/update", "/add"}, method = {RequestMethod.POST})
    public RspData update(@RequestBody @ApiParam(name = "SetBlogSort对象",value = "传入JSON数据") SetBlogSort setBlogSort) {
        if (setBlogSort == null) {
            logger.error("setBlogSort is null");
            return RspData.invalidParameter();
        }
        if (!setBlogSortService.saveOrUpdate(setBlogSort)) {
            logger.error("update or add setBlogSort error");
            return RspData.error(RspData.RSP_CODE__ERROR);
        }
        return RspData.success();
    }

    /**
     * 删除数据
     * @param id id
     * @return 实体
     */
    @ApiOperation("删除数据")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @RequestMapping(value = {"/delete/{id}"}, method = {RequestMethod.GET})
    public RspData delete(@PathVariable("id") Long id) {
        if (id == null) {
            logger.error("id is null");
            return RspData.invalidParameter();
        }
        if (setBlogSortService.removeById(id)) {
           logger.error("delete setBlogSort error");
            return RspData.error(RspData.RSP_CODE__ERROR);
        }
        return RspData.success();
    }

    /**
     * 分页查询
     * @param page 当前页面
     * @param size 每页显示的数量
     * @return 实体
     */
    @ApiOperation(value = "SetBlogSort条件分页查询",notes = "分页条件查询SetBlogSort方法详情",tags = {"SetBlogSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/{page}/{size}", method = {RequestMethod.GET})
    public RspData findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<SetBlogSort> pages = new Page<>(page, size);
        return RspData.success(setBlogSortService.page(pages));
    }

    /**
     * 分页查询
     * @param page 当前页面
     * @param size 每页显示的数量
     * @return 实体
     */
    @ApiOperation(value = "SetBlogSort条件分页查询",notes = "分页条件查询SetBlogSort方法详情",tags = {"SetBlogSortController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public RspData findPage1(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<SetBlogSort> pages = new Page<>(page, size);
        return RspData.success(setBlogSortService.page(pages));
    }
}

