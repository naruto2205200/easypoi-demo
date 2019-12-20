package com.naruto.easypoidemo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.naruto.easypoidemo.entity.CourseEntity;
import com.naruto.easypoidemo.entity.StudentEntity;
import com.naruto.easypoidemo.entity.TeacherEntity;
import com.naruto.easypoidemo.utils.CourseEntityUtils;
import com.naruto.easypoidemo.utils.ExcelUtils;
import com.naruto.easypoidemo.utils.StudentListUtils;
import com.naruto.easypoidemo.vo.PersonExportVo;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/11/2510:10
 */
@Api(tags="接口所在的类")
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @ApiOperation(value = "导出excel4", notes = "合并单元格，列由实体vo 固定")
    @RequestMapping(value = "/export4", method = RequestMethod.GET)
    public void exportExcel4(HttpServletResponse response) throws IOException {
        Date now = new Date();
        List<CourseEntity> list = new ArrayList<>();
        CourseEntity c1 = new CourseEntity();
        c1.setName("语文");
        TeacherEntity t1 = new TeacherEntity();
        t1.setSubName("老师1");
        t1.setSubName("代课老师1");
        List<StudentEntity> sList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StudentEntity entity = new StudentEntity();
            entity.setName("张三"+i);
            entity.setRegistrationDate(now);
            entity.setBirthday(now);
            sList.add(entity);
        }
        c1.setStudents(sList);
        c1.setMathTeacher(t1);
        CourseEntity c2 = new CourseEntity();
        c2.setName("数学");
        TeacherEntity t2 = new TeacherEntity();
        t2.setSubName("老师2");
        t2.setSubName("代课老师2");
        List<StudentEntity> sList2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StudentEntity entity = new StudentEntity();
            entity.setName("李四"+i);
            entity.setRegistrationDate(now);
            entity.setBirthday(now);
            sList2.add(entity);
        }
        c2.setStudents(sList2);
        c2.setMathTeacher(t2);
        list.add(c1);
        list.add(c2);
        ExcelUtils.exportExcel(list, "课程信息表", "课程信息", CourseEntity.class, "课程信息", response);
    }

    /**
     * easypoi 按需导出指定列的方法
     *
     * List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();  //entity用来设置需要导出的字段
     * ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
     * excelentity.setNeedMerge(true);
     * entity.add(excelentity);
     * 也可以
     * entity.add(new ExcelExportEntity("性别", "sex"));
     * 如果有需要合并的列
     * ExcelExportEntity excelentity = new ExcelExportEntity(null, "students");
     * List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
     * temp.add(new ExcelExportEntity("姓名", "name"));
     * temp.add(new ExcelExportEntity("性别", "sex"));
     * excelentity.setList(temp);
     * 导出数据
     * List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
     * 数据放入一个Map<String, Object> 中，这里的map表示一条数据，如果这个map需要合并列，Object需要放一个 List<Map<String, Object>>
     * @param response
     * @throws IOException
     */
    @ApiOperation(value = "导出excel", notes = "动态导出需要的列，而不是固定列")
    @RequestMapping(value = "/export6", method = RequestMethod.GET)
    public void exportExcel6(HttpServletResponse response) throws IOException {
        List<ExcelExportEntity> beanList = new ArrayList();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 =new HashMap<>();
        map1.put("className","语文" );
        map1.put("teacherName","张三" );
        List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
        Map<String, Object> map11 =new HashMap<>();
        map11.put("name", "莉莉1");
        map11.put("sex", "男");
        map11.put("registrationDate", "2019-01-02");
        Map<String, Object> map12 =new HashMap<>();
        map12.put("name", "莉莉2");
        map12.put("sex", "男");
        map12.put("registrationDate", "2019-01-02");
        list2.add(map11);
        list2.add(map12);
        map1.put("students",list2 );
        list.add(map1);


        Map<String, Object> map3 =new HashMap<>();
        map3.put("className","语文" );
        map3.put("teacherName","张三2" );
        Map<String, Object> map31 =new HashMap<>();
        map31.put("name", "莉莉3");
        map31.put("sex", "男");
        map31.put("registrationDate", "2019-01-02");
        Map<String, Object> map32 =new HashMap<>();
        map32.put("name", "莉莉4");
        map32.put("sex", "男");
        map32.put("registrationDate", "2019-01-02");
        List<Map<String, Object>> list3 = new ArrayList<Map<String, Object>>();
        list3.add(map31);
        list3.add(map32);
        map3.put("students",list3);
        list.add(map3);

        Map<String, Object> map5 =new HashMap<>();
        map5.put("className","数学" );
        map5.put("teacherName","张三3" );
        Map<String, Object> map51 =new HashMap<>();
        map51.put("name", "莉莉");
        map51.put("sex", "男");
        map51.put("registrationDate", "2019-01-02");
        Map<String, Object> map52 =new HashMap<>();
        map52.put("name", "莉莉");
        map52.put("sex", "男");
        map52.put("registrationDate", "2019-01-02");
        List<Map<String, Object>> list5 = new ArrayList<Map<String, Object>>();
        list5.add(map51);
        list5.add(map52);
        map5.put("students",list5);
        list.add(map5);

        ExcelExportEntity excelExportEntity = new ExcelExportEntity("课程名称", "className");
        excelExportEntity.setNeedMerge(true);
        beanList .add(excelExportEntity);
        ExcelExportEntity excelExportEntity1 = new ExcelExportEntity("代课老师", "teacherName");
        excelExportEntity1.setNeedMerge(true);
        beanList .add(excelExportEntity1);
        //这里注意 需要单独列出来不是合并
        ExcelExportEntity excelentity = new ExcelExportEntity(null, "students");
        List<ExcelExportEntity> beanList1 = new ArrayList();
        beanList1.add(new ExcelExportEntity("学生姓名", "name"));
        beanList1.add(new ExcelExportEntity("学生性别", "sex"));
        beanList1.add(new ExcelExportEntity("进校日期", "registrationDate"));
        excelentity.setList(beanList1);
        beanList .add(excelentity);
        ExcelUtils.exportExcel(beanList,list,"title课程信息表", "sheet课程信息","file课程信息", response);
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!";
    }

    /**
     * 导出
     *
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        List<PersonExportVo> personList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = new PersonExportVo();
            personVo.setName("张三" + i);
            personVo.setUsername("张三" + i);
            personVo.setPhoneNumber("18888888888");
            personList.add(personVo);
        }
        logger.debug("导出excel所花时间：" + (System.currentTimeMillis() - start));
//        ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);
        ExcelExportUtil.exportExcel(new ExportParams(), PersonExportVo.class, personList);
    }

    /**
     * 导出
     *
     * @param response
     */
    @RequestMapping(value = "/export2", method = RequestMethod.GET)
    public void exportExcel2(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        List<PersonExportVo> personList = new ArrayList();
        PersonExportVo personVo = new PersonExportVo();
        personVo.setName("张三");
        personVo.setUsername("张三1");
        personVo.setPhoneNumber("18888888888");
        personList.add(personVo);

        PersonExportVo personVo2 = new PersonExportVo();
        personVo2.setName("张三");
        personVo2.setUsername("张三1");
        personVo2.setPhoneNumber("18888888888");
        personList.add(personVo2);

        PersonExportVo personVo3 = new PersonExportVo();
        personVo3.setName("张三");
        personVo3.setUsername("张三2");
        personVo3.setPhoneNumber("18888888888");
        personList.add(personVo3);

        PersonExportVo personVo4 = new PersonExportVo();
        personVo4.setName("张三");
        personVo4.setUsername("张三2");
        personVo4.setPhoneNumber("18888888888");
        personList.add(personVo4);

        PersonExportVo personVo5 = new PersonExportVo();
        personVo5.setName("张三");
        personVo5.setUsername("张三3");
        personVo5.setPhoneNumber("18888888888");
        personList.add(personVo5);

        PersonExportVo personVo6 = new PersonExportVo();
        personVo6.setName("李四");
        personVo6.setUsername("张三3");
        personVo6.setPhoneNumber("18888888888");
        personList.add(personVo6);

        PersonExportVo personVo7 = new PersonExportVo();
        personVo7.setName("王五");
        personVo7.setUsername("张三3");
        personVo7.setPhoneNumber("18888888888");
        personList.add(personVo7);

        logger.debug("导出excel所花时间：" + (System.currentTimeMillis() - start));
        ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);

    }

    /**
     * 导出
     *
     * @param response
     */
    @RequestMapping(value = "/export3", method = RequestMethod.GET)
    public void exportExcel3(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        List<PersonExportVo> personList = new ArrayList();
//        ExcelExportEntity
        logger.debug("导出excel所花时间：" + (System.currentTimeMillis() - start));
        ExcelUtils.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);

    }


    @ApiOperation(value = "导出excel10", notes = "导出一个list集合，对象是包含所有需要的信息的一个实体对象")
    @RequestMapping(value = "/export10", method = RequestMethod.GET )
    public void export10(HttpServletResponse response) throws IOException {
        List<StudentEntity> list = StudentListUtils.getStudentList();
//        ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"), StudentEntity.class, list);
        ExcelUtils.exportExcel(list,StudentEntity.class,"export10",new ExportParams("计算机一班学生", "学生", ExcelType.XSSF),response);
    }

    @ApiOperation(value = "导出excel11", notes = "导出一个list集合，对象包含相关一对多关系")
    @RequestMapping(value = "/export11", method = RequestMethod.GET )
    public void export11(HttpServletResponse response) throws IOException {
        List<CourseEntity> list = CourseEntityUtils.getCourseList();
//        ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"), StudentEntity.class, list);
        ExcelUtils.exportExcel(list,CourseEntity.class,"export10",new ExportParams("计算机一班学生", "学生", ExcelType.XSSF),response);
    }

}
