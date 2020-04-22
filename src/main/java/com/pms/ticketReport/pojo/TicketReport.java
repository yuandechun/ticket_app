package com.pms.ticketReport.pojo;


public class TicketReport {

    private String month;
    private int createCount;
    private int closeCount;
    private int assignCount;
    private int resolveCount;
    private int openCount;
    private int wipCount;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getCreateCount() {
        return createCount;
    }

    public void setCreateCount(int createCount) {
        this.createCount = createCount;
    }

    public int getCloseCount() {
        return closeCount;
    }

    public void setCloseCount(int closeCount) {
        this.closeCount = closeCount;
    }

    public int getAssignCount() {
        return assignCount;
    }

    public void setAssignCount(int assignCount) {
        this.assignCount = assignCount;
    }

    public int getResolveCount() {
        return resolveCount;
    }

    public void setResolveCount(int resolveCount) {
        this.resolveCount = resolveCount;
    }

    public int getOpenCount() {
        return openCount;
    }

    public void setOpenCount(int openCount) {
        this.openCount = openCount;
    }

    public int getWipCount() {
        return wipCount;
    }

    public void setWipCount(int wipCount) {
        this.wipCount = wipCount;
    }
}
