package com.example.tea.server;

import com.example.tea.dao.history;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class historyMapper implements history {
    @Autowired
    public history history1;
    @Override
    public void Write(String name, int id) {
        history1.Write(name,id);
    }

    @Override
    public List GetHistory(int id) {
        return history1.GetHistory(id);
    }

    @Override
    public void deleteHistory(String name, int id) {
        history1.deleteHistory(name,id);
    }
}
