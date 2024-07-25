package edu.njust.back_end.modules.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Aspect
@Component
public class SetTimeAspect {
    @Pointcut("@annotation(edu.njust.back_end.modules.utils.Create)")
    public void createPointCut() {
    }

    @Pointcut("@annotation(edu.njust.back_end.modules.utils.Update)")
    public void updatePointCut() {

    }

    @Before("createPointCut()")
    public void updateCreateTime(JoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        BaseEntity entity = (BaseEntity) args[0];
        Date currentDate = new Date(System.currentTimeMillis());
        entity.setCreateTime(currentDate);
        entity.setUpdateTime(currentDate);
    }

    @Before("createPointCut()")
    public void updateUpdateTime(JoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        BaseEntity entity = (BaseEntity) args[0];
        Date currentDate = new Date(System.currentTimeMillis());
        entity.setUpdateTime(currentDate);
    }
}
