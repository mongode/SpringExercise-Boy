package cn.mongode.boy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    
    @Pointcut("execution(public * cn.mongode.boy.controller..BoyController.*(..))")
    public void log() {}
    
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("HttpAspect Method - doBefore();");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}", request.getRequestURL());
        logger.info("ip={}", request.getRemoteHost());
        logger.info("method={}", request.getMethod());
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringType()
                + "." + joinPoint.getSignature().getName());
        logger.info("class_args={}", joinPoint.getArgs());
    }
    
    @After("log()")
    public void doAfter() {
        logger.info("HttpAspect Method - doAfter();");
    }
    
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterRunnig(Object object) {
        logger.info("response={}", object.toString());
    }
}
