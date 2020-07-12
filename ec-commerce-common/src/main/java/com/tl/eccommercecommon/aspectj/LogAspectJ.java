package com.tl.eccommercecommon.aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 切面，记录日志
 * created by linTan 2020/6/26
 */

@Aspect
@Component
public class LogAspectJ {


    private static Logger logger= LoggerFactory.getLogger(LogAspectJ.class);


    /**
     * 切点，匹配使用了Log注解的方法
     */
    @Pointcut(value = "@annotation(com.tl.eccommercecommon.aspectj.annotation.Log)")
    public void pointcut(){

    }

    /**
     * 前置通知，方法执行前，记录方法执行前状态
     * @param joinPoint
     */
    @Before(value = "pointcut() &&args(param,count)")
    public void beforeExecute(JoinPoint joinPoint ,String param,int count){
        System.out.println("黑名单ip:"+param +"attack times" + count);
        logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        System.out.println("before....");
    }

    /**
     * 环绕通知，打印方法执行参数
     * @param proceedingJoinPoint
     */
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){

        try {
            System.out.println("around 1..");
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("around 1..");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


    /**
     * 异常处理
     * @param throwable
     */
    @AfterThrowing(pointcut = "pointcut()",throwing = "throwable")
    public void afterThrower(Throwable throwable){

        logger.error(throwable.toString());
    }



}
