package com.naruto.easypoidemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/11/2514:42
 */
@Data
@ExcelTarget("course3Entity")
public class Course3Entity implements Serializable {
    /** 主键 */
    private String id;
    /**
     * @Excel 注解表示需要导出在excel的字段，
     * name表示要在excel显示的表头，
     * orderNum表示排序列，
     * needMerge表示是否需要合并单元格
     * isImportField 表示是否导出，默认为true，如果不想导出可以不写@Excel注解
     **/
    @Excel(name = "课程名称", orderNum = "1")
    private String name;

    @Excel(name = "代课老师",orderNum = "2", isImportField = "true_major,true_absent")
    private String subName;

    @Excel(name = "学生姓名", groupName = "学生",orderNum = "3",isImportField = "true_st")
    private String stuName;
    /**
     * @Excel 注解表示需要导出在excel的字段，
     * name表示要在excel显示的表头，
     * replace 表示替换，如果是0会替换成男，1会替换成女，
     * suffix 替换之后加的后缀
     * needMerge表示是否需要合并单元格
     * isImportField 表示是否导出，默认为true，如果不想导出可以不写@Excel注解
     **/
    @Excel(name = "学生性别", replace = { "男_0", "女_1" }, suffix = "生",groupName = "学生",orderNum = "4", isImportField = "true_st")
    private int sex;

    /**
     * @Excel 注解表示需要导出在excel的字段，
     * name 表示要在excel显示的表头，
     * databaseFormat 导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string 类型,这个需要设置这个数据库格式,用以转换时间格式输出
     * format 导入和导出的时间格式
     * isImportField 表示是否导出，默认为true，如果不想导出可以不写@Excel注解
     **/
    @Excel(name = "出生日期", databaseFormat="yyyyMMddHHmmss",format = "yyyy-MM-dd",groupName = "学生",orderNum = "5", isImportField = "true_st")
    private Date birthday;
    /**
     * @Excel 注解表示需要导出在excel的字段，
     * name 表示要在excel显示的表头，
     * format 导入和导出的时间格式
     * isImportField 表示是否导出，默认为true，如果不想导出可以不写@Excel注解
     **/
    @Excel(name = "进校日期", groupName = "学生",format = "yyyy-MM-dd",orderNum = "6")
    private Date registrationDate;
}
