package app.sample.interview.samples;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.AdviceName;


@Aspect
@Component
public class LoggerAspect {


    @Before("execution(* com.sample.interview.service.*(..))")
    public  void   beforeComment() {
        System.out.println(" This is the before Aspect");
    }

    @Pointcut()
    public void allServiceMethods() {
        System.out.println( "  Method is ffininshed executing");
    }


    @After("allServiceMethods()")
    public void afterAdvice() {
        System.out.println( " This is after advice Execution");
    }

}
