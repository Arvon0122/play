package com.csj.ceshi.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

/**
 * excel帮助类
 * @author: weicl
 * @Date : 2018/12/3 9:35
 * @Modified By :
 */
public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 设置头部响应信息
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void setResponse(HttpServletResponse response, String excelName) {
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //中文乱码下载解决方法
        String fileName = null;
        try {
            fileName = URLEncoder.encode(excelName,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
    }


    /**
     * 关闭流
     * @param outputStream
     * @param workbook
     */
    public static void close(ServletOutputStream outputStream, Workbook workbook) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                LOGGER.error("报表导出关闭流失败");
            }
        }
        if(workbook != null){
            try {
                workbook.close();
            } catch (IOException e) {
                LOGGER.error("workbook关闭流失败");
            }
        }
    }

    /**
     * 报表导出
     * @param response   响应信息
     * @param sheetName  excel工作簿名称
     * @param clazz      数据实体类
     * @param collection 数据集
     */
    public static void export(HttpServletResponse response, String sheetName, Class<?> clazz, Collection<?> collection){
        export(response,"",sheetName,clazz,collection);
    }

    /**
     * 报表导出
     * @param response   响应信息
     * @param title      excel表头
     * @param sheetName  excel工作簿名称
     * @param clazz      数据实体类
     * @param collection 数据集
     */
    public static void export(HttpServletResponse response, String title, String sheetName, Class<?> clazz, Collection<?> collection){
        // 设置sheetName
        ExportParams exportParams = new ExportParams(null, sheetName);
        Workbook workbook = null;
        ServletOutputStream outputStream = null;
        try {
            if(CollectionUtils.isEmpty(collection)){
                return;
            }
            outputStream = response.getOutputStream();
            // 往表格中写入数据
            workbook = ExcelExportUtil
                .exportExcel(exportParams, clazz, collection);
            workbook.write(outputStream);
        } catch (IOException e) {
            LOGGER.error("报表导出失败，请检查原因", e);
            throw new RuntimeException("导出报表失败");
        } finally {
            // 关闭流
            close(outputStream,workbook);
        }
    }
}
