package com.naruto.easypoidemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/11/2514:43
 */
@Data
@ExcelTarget("TeacherAndStuEntity2")
public class TeacherAndStuEntity2 implements Serializable {
    public TeacherAndStuEntity2(){

    }

    public TeacherAndStuEntity2(String id, String subName) {
        this.id=id;
        this.subName = subName;
    }
    private String id;
    /**
     * @Excel 注解表示需要导出在excel的字段，
     * name 表示要在excel显示的表头，
     * orderNum 表示排序列，
     * needMerge 表示是否需要合并单元格
     * isImportField 表示是否导出，默认为true，如果不想导出可以不写@Excel注解
     **/
    @Excel(name = "代课老师",orderNum = "2",needMerge = true, isImportField = "true_major,true_absent")
    private String subName;

    /**
     * @ExcelCollection 表示一对多的一个集合
     * name表示要在excel显示的表头
     * orderNum表示排序列
     */
    @ExcelCollection(name = "", orderNum = "3")
    private List<StudentEntity> students;
}