package com.wuxi.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String path = req.getParameter("path");
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        String filename = req.getParameter("filename");
        System.out.println(path + filename);
        File file = new File(path + filename);
        if (file.exists() && file.isFile()) {
            FileInputStream inputStream = new FileInputStream(file);
            //注释下面两个header则是文件预览
            resp.setHeader("Content-type", "text/plain");
            resp.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes("utf-8"), "ISO-8859-1"));
            ServletOutputStream outputStream = resp.getOutputStream();
            byte[] tmp = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(tmp)) != -1) {
                outputStream.write(tmp, 0, len);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } else {
            System.out.println("文件不存在！");
        }

    }


}
