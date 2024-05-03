package com.task1.postAndPatch.CustomAnnotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @After("@annotation(TimeMonitor)")
    public void logtime()
    {
        System.out.println("Logging time");
    }
}
