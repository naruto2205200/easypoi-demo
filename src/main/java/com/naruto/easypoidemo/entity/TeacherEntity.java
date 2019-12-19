package com.naruto.easypoidemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/11/2514:43
 */
@Data
@ExcelTarget("teacherEntity")
public class TeacherEntity implements java.io.Serializable {
    private String id;
    /** name */
    @Excel(name = "代课老师",orderNum = "2",needMerge = true, isImportField = "true_major,true_absent")
    private String subName;
}
