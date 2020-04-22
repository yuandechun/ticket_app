package com.common.usermanage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.core.controller.BaseController;
import com.core.data.result.ResultBootstrapTable;
import com.core.data.result.ResultBootstrapTableUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.usermanage.pojo.SysUser;
import com.common.usermanage.service.SysUserService;

@Controller
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService SysUserService;

    /****
     * query sys user list
     *
     */
    @RequestMapping(method = RequestMethod.POST, value = "/load")
    @ResponseBody
    public ResultBootstrapTable loadSysUser(HttpServletRequest request, HttpServletResponse response,
                                            SysUser querySysUser, Integer pageSize, Integer pageNumber) {
        List<SysUser> userList = null;
        PageInfo<SysUser> pageInfo = null;
        try {
            // 1、设置分页信息，包括当前页数和每页显示的总计数
            PageHelper.startPage(pageNumber == null ? 1 : pageNumber, pageSize == null ? 10 : pageSize);
            // 2、执行查询
            userList = SysUserService.loadAllSysUser(querySysUser);
            // 3、获取分页查询后的数据
            pageInfo = new PageInfo<>(userList);
            logger.info("query all sys user success!");
        } catch (Exception e) {
            logger.error("query all sys user fail!");
            e.printStackTrace();
        }
        // 4.设置获取到的总记录数total
        Long sysUserCount = pageInfo.getTotal();
        return ResultBootstrapTableUtil.success(sysUserCount, userList);
    }

    /****
     * load sys user by id
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loadDetail")
    @ResponseBody
    public ResultBootstrapTable<?> loadSysUserById(HttpServletRequest request, HttpServletResponse response,
                                                   SysUser querySysUserDetail) {
        SysUser userDetail = null;
        Long total = 1L;
        try {
            // 执行查询
            userDetail = SysUserService.loadSysUserById(querySysUserDetail.getId());
            logger.info("query sys user detail success!");
        } catch (Exception e) {
            logger.error("query sys user detail fail!");
            e.printStackTrace();
        }
        // 2.设置获取到的总记录数total
        return ResultBootstrapTableUtil.success(total, userDetail);
    }

    /****
     * delete sys user by table id
     */
    @PostMapping("/delete")
    public void deleteSysUser(HttpServletRequest request, HttpServletResponse response, SysUser deleteSysUser) {
        try {
            // 执行删除
            SysUserService.deleteSysUserById(deleteSysUser.getId());
            logger.info("delete sys user success!");
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("delete sys user error! table id=" + deleteSysUser.getId());
            e.printStackTrace();
        }

    }

    @PostMapping("/update")
    public void updateSysUser(HttpServletRequest request, HttpServletResponse response, SysUser updateSysUser) {
        try {
            // 1、执行更新
            SysUserService.updateSysUser(updateSysUser);
            logger.info("edit sys user success!");
        } catch (Exception e) {
            logger.error("edit sys user fail!");
            e.printStackTrace();
        }
    }

    @PostMapping("/add")
    public void addSysUser(HttpServletRequest request, HttpServletResponse response, SysUser addSysUser) {
        try {
            // 1、执行新增
            SysUserService.addSysUser(addSysUser);
            logger.info("add sys user success!");
        } catch (Exception e) {
            logger.error("add sys user fail!");
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public SysUser loadSysUserById(HttpServletRequest request, @PathVariable("id") int id) {
        SysUser sysUser = null;
        try {
            sysUser = SysUserService.loadSysUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sysUser;
    }

}
