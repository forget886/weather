package com.wuxi.service.Impl;

import com.wuxi.service.AbstractImportData;
import com.wuxi.service.ImportData;

public class FtpImportData extends AbstractImportData {

    @Override
    public void importData() {
        System.out.println("import data");
    }

    @Override
    public void readData() {
        System.out.println("read data");
    }

    public static void main(String[] args) {
        FtpImportData ftpImportData = new FtpImportData();

        System.out.println(ftpImportData instanceof FtpImportData);
        System.out.println(ftpImportData instanceof AbstractImportData);
        System.out.println(ftpImportData instanceof ImportData);


        System.out.println(ImportData.class.isAssignableFrom(AbstractImportData.class));
        System.out.println(ImportData.class.isAssignableFrom(FtpImportData.class));
    }

}
