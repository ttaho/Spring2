package hello.hellospirng.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    // @Around => hello.hellospirng 하위에 모두다 적용해라
    // @Around("execution(* hello.hellospirng..*(..))")
    // @Around => hello.hellospirng.service 하위에 모두다 적용해라
    @Around("execution(* hello.hellospirng.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() +" " + timeMs + "ms");
        }

    }
}
