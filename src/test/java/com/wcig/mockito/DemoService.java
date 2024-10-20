package com.wcig.mockito;

public class DemoService {
    private DemoDao demoDao;

    public DemoService(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    public int total() {
        return demoDao.total();
    }
}
