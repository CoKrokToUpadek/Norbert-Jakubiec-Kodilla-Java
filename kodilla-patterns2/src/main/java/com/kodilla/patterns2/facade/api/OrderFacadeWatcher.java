package com.kodilla.patterns2.facade.api;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {

    int invokeCounter=0;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    void countMethodInvoke(JoinPoint joinPoint){
        invokeCounter++;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LOGGER.info("Method "+signature.getMethod().getName()+" was invoked "+invokeCounter +" time"+(invokeCounter > 1 ? "s" : ""));
    }


}
