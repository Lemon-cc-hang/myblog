package com.myblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.entity.SetBlogLabel;
import com.myblog.service.SetBlogLabelService;
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
@Api(value = "SetBlogLabelController")
@RestController
@RequestMapping("/setBlogLabel")
public class SetBlogLabelController {

    static Logger logger = LoggerFactory.getLogger(SetBlogLabelController.class);

    @Autowired
    private SetBlogLabelService setBlogLabelService;

    /**
     * 查询所有SetBlogLabel
     * @return 实体
     */
    @ApiOperation("查询所有SetBlogLabel")
    @RequestMapping(value = "/findAll", method = {RequestMethod.GET})
    public RspData findAll() {
        return RspData.success(setBlogLabelService.list());
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
        return RspData.success(setBlogLabelService.getById(id));
    }

    /**
     * 增加或更新数据
     * @param setBlogLabel SetBlogLabel
     * @return 实体
     */
    @ApiOperation("增加或更新数据")
    @RequestMapping(value = {"/update", "/add"}, method = {RequestMethod.POST})
    public RspData update(@RequestBody @ApiParam(name = "SetBlogLabel对象",value = "传入JSON数据") SetBlogLabel setBlogLabel) {
        if (setBlogLabel == null) {
            logger.error("setBlogLabel is null");
            return RspData.invalidParameter();
        }
        if (!setBlogLabelService.saveOrUpdate(setBlogLabel)) {
            logger.error("update or add setBlogLabel error");
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
        if (setBlogLabelService.removeById(id)) {
           logger.error("delete setBlogLabel error");
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
    @ApiOperation(value = "SetBlogLabel条件分页查询",notes = "分页条件查询SetBlogLabel方法详情",tags = {"SetBlogLabelController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/{page}/{size}", method = {RequestMethod.GET})
    public RspData findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<SetBlogLabel> pages = new Page<>(page, size);
        return RspData.success(setBlogLabelService.page(pages));
    }

    /**
     * 分页查询
     * @param page 当前页面
     * @param size 每页显示的数量
     * @return 实体
     */
    @ApiOperation(value = "SetBlogLabel条件分页查询",notes = "分页条件查询SetBlogLabel方法详情",tags = {"SetBlogLabelController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public RspData findPage1(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<SetBlogLabel> pages = new Page<>(page, size);
        return RspData.success(setBlogLabelService.page(pages));
    }
}

