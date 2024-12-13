package naji.brahim.examen_blanc_design_pattern_et_aop.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Around("@annotation(securedBy)")
    public Object checkSecurity(ProceedingJoinPoint joinPoint, SecuredBy securedBy) throws Throwable {
        String[] roles = securedBy.roles();
        String currentUserRole = getCurrentUserRole();

        boolean hasPermission = false;
        for (String role : roles) {
            if (role.equals(currentUserRole)) {
                hasPermission = true;
                break;
            }
        }

        if (!hasPermission) {
            throw new SecurityException("Accès refusé. Rôle insuffisant.");
        }

        return joinPoint.proceed();
    }

    private String getCurrentUserRole() {
        return "role1";
    }
}
