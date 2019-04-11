package com.wuxi.service;

public class AbstractImportData implements ImportData {

    @Override
    public void importData() {
        System.out.println("import data");
    }

    public void readData() {
        System.out.println("read data");
    }

}
