package com.cadastro.frameWork.annotions;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogRestAspect {

    @Around("@annotation(LogRest)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Object procedimento = joinPoint.proceed();

        System.out.println("Método: " + joinPoint.getSignature());
        System.out.println("Request: " + (joinPoint.getArgs().length > 0 ? joinPoint.getArgs()[0].toString() : null));
        System.out.println("Response: " + procedimento.toString()); // "new Gson().toJson(procedimento)"

        return procedimento;

    }

}
