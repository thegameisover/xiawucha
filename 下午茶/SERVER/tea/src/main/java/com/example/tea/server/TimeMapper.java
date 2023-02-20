package com.example.tea.server;

import com.example.tea.dao.TimePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TimeMapper implements TimePicture {
    @Autowired
    private TimePicture time;
    @Override
    @Cacheable(value = "cashHome", key = "#TimePicture")
    public List<Map<String, Object>> timePicture(String TimePicture) {
        return time.timePicture(TimePicture);
    }
}
