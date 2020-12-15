package com.myblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myblog.entity.Comments;
import com.myblog.service.CommentsService;
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
@Api(value = "CommentsController")
@RestController
@RequestMapping("/comments")
public class CommentsController {

    static Logger logger = LoggerFactory.getLogger(CommentsController.class);

    @Autowired
    private CommentsService commentsService;

    /**
     * 查询所有Comments
     * @return 实体
     */
    @ApiOperation("查询所有Comments")
    @RequestMapping(value = "/findAll", method = {RequestMethod.GET})
    public RspData findAll() {
        return RspData.success(commentsService.list());
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
        return RspData.success(commentsService.getById(id));
    }

    /**
     * 增加或更新数据
     * @param comments Comments
     * @return 实体
     */
    @ApiOperation("增加或更新数据")
    @RequestMapping(value = {"/update", "/add"}, method = {RequestMethod.POST})
    public RspData update(@RequestBody @ApiParam(name = "Comments对象",value = "传入JSON数据") Comments comments) {
        if (comments == null) {
            logger.error("comments is null");
            return RspData.invalidParameter();
        }
        if (!commentsService.saveOrUpdate(comments)) {
            logger.error("update or add comments error");
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
        if (commentsService.removeById(id)) {
           logger.error("delete comments error");
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
    @ApiOperation(value = "Comments条件分页查询",notes = "分页条件查询Comments方法详情",tags = {"CommentsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/{page}/{size}", method = {RequestMethod.GET})
    public RspData findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<Comments> pages = new Page<>(page, size);
        return RspData.success(commentsService.page(pages));
    }

    /**
     * 分页查询
     * @param page 当前页面
     * @param size 每页显示的数量
     * @return 实体
     */
    @ApiOperation(value = "Comments条件分页查询",notes = "分页条件查询Comments方法详情",tags = {"CommentsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public RspData findPage1(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        if (page < 1) {
            page = 1;
        }
        Page<Comments> pages = new Page<>(page, size);
        return RspData.success(commentsService.page(pages));
    }
}

