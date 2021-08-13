package com.lee.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {

    /**
     * log4j的log.info()类上加上注解可以直接使用

     */
    protected static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * https://blog.csdn.net/weixin_34072637/article/details/91827912
     * 1）execution(public * *(..))——表示匹配所有public方法
     * 2）execution(* set*(..))——表示所有以“set”开头的方法
     * 3）execution(* com.xyz.service.AccountService.*(..))——表示匹配所有AccountService接口的方法
     * 4）execution(* com.xyz.service.*.*(..))——表示匹配service包下所有的方法
     * 5）execution(* com.xyz.service..*.*(..))——表示匹配service包和它的子包下的方法
     *
     * this(com.xyz.service.AccountService)
     */
    @Pointcut("execution(public * com.lee.controller..*.*(..))")
    public void exePointCut(){}

    /**
     *
     * https://www.cnblogs.com/wangshen31/p/9379197.html
     * within:某个类里面
     * 前置通知（@Before）：在目标方法调用之前调用通知
     * 后置通知（@After）：在目标方法完成之后调用通知
     * 环绕通知（@Around）：在被通知的方法调用之前和调用之后执行自定义的方法
     * 返回通知（@AfterReturning）：在目标方法成功执行之后调用通知
     * 异常通知（@AfterThrowing）：在目标方法抛出异常之后调用通知
     *
     * Logback
     * https://www.cnblogs.com/bigdataZJ/p/springboot-log.html
     *
     * @param joinPoint
     */
    @Before("within(com.lee.controller.aop.*)")
    public void printStartLog(JoinPoint joinPoint){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        logger.info("controller start:"+ LocalDateTime.now());
        logger.info(request.getRequestURI());
    }

    @After("within(com.lee.controller.aop.*)")
    public void printEndLog(JoinPoint joinPoint){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        logger.info("controller end:" + LocalDateTime.now());
        logger.info(request.getRequestURI());
    }

    /**
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
     *             throws-pattern?)
     *
     * execution(方法修饰符(可选)  返回类型  类路径 方法名  参数  异常模式(可选))
     * @param proceedingJoinPoint
     */
    @Around("exePointCut()")
    public void printExeLog(ProceedingJoinPoint proceedingJoinPoint){

        try {

            logger.info(LocalDateTime.now() + "Start, Class:" + proceedingJoinPoint.getTarget().toString());

            System.out.println("***************" + proceedingJoinPoint.getTarget().toString() + " start! ***************");
            proceedingJoinPoint.proceed();

            System.out.println("***************" + proceedingJoinPoint.getTarget().toString() + " end! ***************");
            logger.info(LocalDateTime.now() + "End, Class:" + proceedingJoinPoint.getTarget().toString());

        } catch (Throwable t) {
            logger.error(LocalDateTime.now() + " Error:" + t.getCause());

            t.printStackTrace();
        }
    }




}
