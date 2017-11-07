package com.example.aopdemo.newMethod;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.commons.lang.time.StopWatch;

import java.util.Collection;

@Component
@Aspect
public class HelloAspectNew {
    private final static Logger logger = LoggerFactory.getLogger(HelloAspectNew.class);
    @Around("execution(public * com.example.aopdemo.newMethod.TestService.getStr(*))")
//    @Around("@annotation(com.example.aopdemo.newMethod.InvokeTimeCount)")
    public Object doTimeCount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result =proceedingJoinPoint.proceed();
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = proceedingJoinPoint.getArgs();
        String logStr = buildLog(className,methodName, parameterNames,args,stopWatch.getTime(),null);
        logger.info(logStr);
        return result;
    }

    private static String buildLog(String className,String methodName,String[] parameterNames,Object[] args,long costTime,Object value){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("methed:");
        stringBuilder.append(className + "." + methodName);
        stringBuilder.append(",args:");
        boolean hasArgs = false;
        if(parameterNames != null && parameterNames.length > 0){
            hasArgs = true;
            for (int i = 0; i < parameterNames.length; i++) {
                Object arg = args[i];
                if(arg instanceof Collection){
                    Collection list = (Collection)arg;
                    stringBuilder.append(parameterNames[i]);
                    stringBuilder.append("=");
                    stringBuilder.append(list.size());
                    stringBuilder.append("(size),");
                    continue;
                }
                stringBuilder.append(parameterNames[i]);
                stringBuilder.append("=");
                stringBuilder.append(args[i]);
                stringBuilder.append(",");
            }
        }
        if(hasArgs){
            stringBuilder.append("costTime:");
        }else {
            stringBuilder.append(",costTime:");
        }
        stringBuilder.append(costTime);
        stringBuilder.append(",value:" + value);
        return stringBuilder.toString();
    }
}
