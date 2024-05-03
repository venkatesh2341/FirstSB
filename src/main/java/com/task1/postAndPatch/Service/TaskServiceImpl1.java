package com.task1.postAndPatch.Service;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl1 implements TaskService{

    @Override
    public String getService()
    {
        return "TaskService 1";
    }
}
