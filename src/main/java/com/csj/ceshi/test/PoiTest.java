package com.csj.ceshi.test;

import com.csj.ceshi.pojo.Student;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PoiTest {
//    private static List<Student> getStudent() throws Exception {
//        List list = new ArrayList();
//        Student user1 = new Student(1, "小红", 16);
//        Student user2 = new Student(2, "小明", 17);
//        Student user3 = new Student(3, "小花", 26);
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        return list;
//    }
//    public static void main(String[] args) throws Exception {
//        // 第一步，创建一个webbook，对应一个Excel文件
//        HSSFWorkbook wb = new HSSFWorkbook();
//        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet("学生表一");
//       // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
//        HSSFRow row = sheet.createRow((int) 0);
//       // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
//        HSSFCell cell = row.createCell((short) 0);
//        cell.setCellValue("学号");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 1);
//        cell.setCellValue("姓名");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 2);
//        cell.setCellValue("年龄");
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 3);
//        cell.setCellValue("生日");
//        cell.setCellStyle(style);
//       // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
//        List list = PoiTest.getStudent();
//        for (int i = 0; i < list.size(); i++){
//            row = sheet.createRow((int) i + 1);
//            Student stu = (Student) list.get(i);
//        // 第四步，创建单元格，并设置值
//            row.createCell((short) 0).setCellValue((double) stu.getStuid());
//            row.createCell((short) 1).setCellValue(stu.getStuname());
//            row.createCell((short) 2).setCellValue((double) stu.getSage());
//            cell = row.createCell((short) 3);
//       //            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getBirthday()));
//        }
//      // 第六步，将文件存到指定位置
//        try{
//            FileOutputStream fout = new FileOutputStream("E:/students1.xls");
//            wb.write(fout);
//            fout.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    }


