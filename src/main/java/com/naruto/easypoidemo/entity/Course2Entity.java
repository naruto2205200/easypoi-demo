package com.naruto.easypoidemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/11/2514:42
 */
@Data
@ExcelTarget("course2Entity")
public class Course2Entity implements Serializable {
    /** 主键 */
    private String id;
    /**
     * @Excel 注解表示需要导出在excel的字段，
     * name表示要在excel显示的表头，
     * orderNum表示排序列，
     * needMerge表示是否需要合并单元格
     * isImportField 表示是否导出，默认为true，如果不想导出可以不写@Excel注解
     **/
    @Excel(name = "课程名称", orderNum = "1",needMerge = true)
    private String name;
//    @ExcelEntity(id = "absent")
    @ExcelCollection(name = "", orderNum = "2")
    private List<TeacherAndStuEntity> mathTeacherList;


}
