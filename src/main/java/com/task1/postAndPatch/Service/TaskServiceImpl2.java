package com.task1.postAndPatch.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("taskServiceImpl2")
public class TaskServiceImpl2 implements  TaskService{


    @Override
    public String getService() {
        return "TaskService 2";
    }
}
