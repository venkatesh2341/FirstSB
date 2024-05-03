package com.task1.postAndPatch.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TaskServiceImpl2 implements  TaskService{


    @Override
    public String getService() {
        return "TaskService 2";
    }
}
