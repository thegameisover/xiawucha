package com.example.tea.dao;

import java.util.List;

public interface history {
    /*写入历史记录*/
    public void Write(String name,int id);
    /*读历史记录*/
    public List GetHistory(int id);
    /*删除历史记录*/
    public void deleteHistory(String name,int id);

}
