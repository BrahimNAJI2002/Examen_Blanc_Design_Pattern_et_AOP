package naji.brahim.examen_blanc_design_pattern_et_aop.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CachingAspect {

    private Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(Cachable)")
    public Object cacheMethodResult(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for " + key);
            return cache.get(key);
        }
        Object result = joinPoint.proceed(); // Exécute la méthode
        cache.put(key, result);
        return result;
    }
}
