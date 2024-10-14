package com.test.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@Aspect
@Service
@Slf4j
public class AspectTest {


    // * = any type
    // .. = any type + any Args

    @Around(value = "@annotation(com.test.aspect.Retry) && @annotation(retry)", argNames = "pjp,retry")
    public Object retryAnnotationProcessor(ProceedingJoinPoint pjp,Retry retry) throws HttpClientErrorException {

        Class<?> exception = retry.exception();
        int retryAttempts = retry.attemptsTime();
        long interval = retry.intervalTimes();

        Object data = null;
         for (int i =0; i <= retryAttempts; i++){
             System.out.println("Method call retrying --- "+i);
             try {
                 data = pjp.proceed();
                 break;
             }catch (Throwable ex){
                  if (ex.getClass() == exception){
                      System.out.println();
                      sleep(interval);
                  }else{
                      break;
                  }
             }
         }
        return data;
    }

    private void sleep(long ls){
        try {
            Thread.sleep(ls);
        }catch (InterruptedException ignore){

        }
    }
   

//    @Pointcut("execution(* sum(..))")
//    @Pointcut("within(com.test..)")
//    public void logPointCut(){}

//    @Before("logPointCut()")
//    public void beforeLog(JoinPoint joinPoint){
//
//        System.out.println("This Pointcut Starting:: "+joinPoint.getSignature());
//    }

//    @After("logPointCut()")
//    public void afterLog(JoinPoint jp){
//        System.out.println("The pointcut ended :: "+jp.getThis().toString()+" -----  "+ jp.getTarget().toString() );
//    }

}
