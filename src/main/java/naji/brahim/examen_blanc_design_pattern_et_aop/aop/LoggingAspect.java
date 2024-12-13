package naji.brahim.examen_blanc_design_pattern_et_aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(Log)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Exécute la méthode
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Execution of " + joinPoint.getSignature().getName() + " took " + duration + " ms");
        return result;
    }
}
