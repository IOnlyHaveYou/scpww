package com.trxk.scpww.pojo;

public class FenYe
{
    private String id;
    private int nowPage;
    private int showCount;

    public FenYe()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(int nowPage)
    {
        this.nowPage = nowPage;
    }

    public int getShowCount()
    {
        return showCount;
    }

    public void setShowCount(int showCount)
    {
        this.showCount = showCount;
    }

    @Override
    public String toString()
    {
        return "FenYe{" +
                "id='" + id + '\'' +
                ", nowPage=" + nowPage +
                ", showCount=" + showCount +
                '}';
    }
}
