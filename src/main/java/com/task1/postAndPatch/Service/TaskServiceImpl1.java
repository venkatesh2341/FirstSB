package com.task1.postAndPatch.Service;

import com.task1.postAndPatch.CustomAnnotation.TimeMonitor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("taskServiceImple1")
public class TaskServiceImpl1 implements TaskService{

    @Override
    @TimeMonitor
    public String getService()
    {

        return "TaskService 1";
    }
}
