package com.task1.postAndPatch.CustomAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint)  {

        long startTime= System.currentTimeMillis();
        try{
            joinPoint.proceed();
        }catch (Throwable e)
        {
            System.out.println(e.getMessage() + "some error occured while executing the function");
        }
        finally {
            long endTime= System.currentTimeMillis();
            long totalTime= endTime-startTime;
            System.out.println("Time taken by the function to execute "+ totalTime + " milli-seconds...");
        }


    }
}
