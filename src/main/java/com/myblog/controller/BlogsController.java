package com.myblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.entity.Blogs;
import com.myblog.service.BlogsService;
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
@Api(value = "BlogsController")
@RestController
@RequestMapping("/blogs")
public class BlogsController {

    static Logger logger = LoggerFactory.getLogger(BlogsController.class);

    @Autowired
    private BlogsService blogsService;

    /**
     * 查询所有Blogs
     * @return 实体
     */
    @ApiOperation("查询所有Blogs")
    @RequestMapping(value = "/findAll", method = {RequestMethod.GET})
    public RspData findAll() {
        return RspData.success(blogsService.list());
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
        return RspData.success(blogsService.getById(id));
    }

    /**
     * 增加或更新数据
     * @param blogs Blogs
     * @return 实体
     */
    @ApiOperation("增加或更新数据")
    @RequestMapping(value = {"/update", "/add"}, method = {RequestMethod.POST})
    public RspData update(@RequestBody @ApiParam(name = "Blogs对象",value = "传入JSON数据") Blogs blogs) {
        if (blogs == null) {
            logger.error("blogs is null");
            return RspData.invalidParameter();
        }
        if (!blogsService.saveOrUpdate(blogs)) {
            logger.error("update or add blogs error");
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
        if (blogsService.removeById(id)) {
           logger.error("delete blogs error");
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
    @ApiOperation(value = "Blogs条件分页查询",notes = "分页条件查询Blogs方法详情",tags = {"BlogsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/{page}/{size}", method = {RequestMethod.GET})
    public RspData findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<Blogs> pages = new Page<>(page, size);
        return RspData.success(blogsService.page(pages));
    }

    /**
     * 分页查询
     * @param page 当前页面
     * @param size 每页显示的数量
     * @return 实体
     */
    @ApiOperation(value = "Blogs条件分页查询",notes = "分页条件查询Blogs方法详情",tags = {"BlogsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public RspData findPage1(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<Blogs> pages = new Page<>(page, size);
        return RspData.success(blogsService.page(pages));
    }
}

