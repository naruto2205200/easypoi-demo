package com.naruto.easypoidemo.utils;

import com.naruto.easypoidemo.entity.CourseEntity;
import com.naruto.easypoidemo.entity.StudentEntity;
import com.naruto.easypoidemo.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/12/2017:44
 */
public class CourseEntityUtils {

    public static List<CourseEntity> getCourseList() {
        List<CourseEntity> list = new ArrayList<>();
        Date birthday = new Date();

        /********添加测试数据*********/
        CourseEntity entity1 = new CourseEntity();
        entity1.setId("1");
        entity1.setName("语文");
        entity1.setMathTeacher(new TeacherEntity("1","张胜利"));
        List<StudentEntity> stuList1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            stuList1.add(stu);
        }
        entity1.setStudents(stuList1);

        CourseEntity entity2 = new CourseEntity();
        entity2.setId("2");
        entity2.setName("数学");
        entity2.setMathTeacher(new TeacherEntity("2","李慧萍"));
        List<StudentEntity> stuList2 = new ArrayList<>();
        for (int i = 4; i < 8; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            stuList2.add(stu);
        }
        entity2.setStudents(stuList2);

        CourseEntity entity3 = new CourseEntity();
        entity3.setId("3");
        entity3.setName("英语");
        entity3.setMathTeacher(new TeacherEntity("3","马王思"));
        List<StudentEntity> stuList3 = new ArrayList<>();
        for (int i = 8; i < 11; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            stuList3.add(stu);
        }
        entity3.setStudents(stuList3);

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        /********添加测试数据*********/

        return list;
    }
}
