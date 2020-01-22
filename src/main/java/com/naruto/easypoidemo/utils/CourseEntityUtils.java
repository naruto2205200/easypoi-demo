package com.naruto.easypoidemo.utils;

import com.naruto.easypoidemo.entity.*;

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

        CourseEntity entity4 = new CourseEntity();
        entity4.setId("1");
        entity4.setName("语文");
        entity4.setMathTeacher(new TeacherEntity("2","李慧萍"));
        List<StudentEntity> stuList4 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            stuList4.add(stu);
        }
        entity4.setStudents(stuList4);

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
        list.add(entity4);
        list.add(entity2);
        list.add(entity3);
        /********添加测试数据*********/

        return list;
    }


    public static List<Course2Entity> getCourseList2() {
        List<Course2Entity> list = new ArrayList<>();
        Date birthday = new Date();

        /********添加测试数据*********/
        Course2Entity entity1 = new Course2Entity();
        entity1.setId("1");
        entity1.setName("语文");
        List<TeacherAndStuEntity> teacherAndStuEntityList1 = new ArrayList<>();
        TeacherAndStuEntity teacherAndStuEntity1 = new TeacherAndStuEntity("1", "张胜利");
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
        teacherAndStuEntity1.setStudents(stuList1);
        teacherAndStuEntityList1.add(teacherAndStuEntity1);

        TeacherAndStuEntity teacherAndStuEntity2 = new TeacherAndStuEntity("2", "李慧萍");
        List<StudentEntity> stuList2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            stuList2.add(stu);
        }
        teacherAndStuEntity2.setStudents(stuList2);
        teacherAndStuEntityList1.add(teacherAndStuEntity2);

        entity1.setMathTeacherList(teacherAndStuEntityList1);

        Course2Entity entity2 = new Course2Entity();
        entity2.setId("2");
        entity2.setName("数学");
        List<TeacherAndStuEntity> teacherAndStuEntityList2 = new ArrayList<>();
        TeacherAndStuEntity teacherAndStuEntity3 = new TeacherAndStuEntity("2", "李慧萍");
        List<StudentEntity> stuList3 = new ArrayList<>();
        for (int i = 4; i < 8; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            stuList3.add(stu);
        }
        teacherAndStuEntity3.setStudents(stuList3);
        teacherAndStuEntityList2.add(teacherAndStuEntity3);
        entity2.setMathTeacherList(teacherAndStuEntityList2);

//        Course2Entity entity3 = new Course2Entity();
//        entity3.setId("3");
//        entity3.setName("英语");
//        List<TeacherEntity> teacherEntityList3= new ArrayList<>();
//        teacherEntityList3.add(new TeacherEntity("3", "马王思"));
//        entity3.setMathTeacherList(teacherEntityList3);
////        entity3.setMathTeacher(new TeacherEntity("3","马王思"));
//        List<StudentEntity> stuList3 = new ArrayList<>();
//        for (int i = 8; i < 11; i++) {
//            StudentEntity stu = new StudentEntity();
//            stu.setId(""+i);
//            stu.setName("stu"+i);
//            stu.setSex(i%2);
//            stu.setBirthday(birthday);
//            stu.setRegistrationDate(birthday);
//            stuList3.add(stu);
//        }
//        entity3.setStudents(stuList3);

        list.add(entity1);
        list.add(entity2);
//        list.add(entity3);
        /********添加测试数据*********/

        return list;
    }

    public static List<Course3Entity> getCourseList3() {
        List<Course3Entity> list = new ArrayList<>();
        Date birthday = new Date();

        /********添加测试数据*********/
        Course3Entity entity1 = new Course3Entity();
        entity1.setId("1");
        entity1.setName("语文");
        entity1.setSubName("张胜利");
        entity1.setStuName("stu1");
        entity1.setSex(1);
        entity1.setBirthday(birthday);
        entity1.setRegistrationDate(birthday);

        Course3Entity entity2 = new Course3Entity();
        entity2.setId("2");
        entity2.setName("数学");
        entity2.setSubName("张试试");
        entity2.setStuName("stu2");
        entity2.setSex(2);
        entity2.setBirthday(birthday);
        entity2.setRegistrationDate(birthday);

        list.add(entity1);
        list.add(entity2);
        /********添加测试数据*********/

        return list;
    }
}
