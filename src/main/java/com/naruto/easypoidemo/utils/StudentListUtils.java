package com.naruto.easypoidemo.utils;

import com.naruto.easypoidemo.entity.StudentEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/12/2016:58
 */
public class StudentListUtils {

    public static List<StudentEntity> getStudentList(){
        Date birthday = new Date();
        List<StudentEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentEntity stu = new StudentEntity();
            stu.setId(""+i);
            stu.setName("stu"+i);
            stu.setSex(i%2);
            stu.setBirthday(birthday);
            stu.setRegistrationDate(birthday);
            list.add(stu);
        }
        return list;
    }
}
