package assignments.assignment3.aspect;

import assignments.assignment3.domain.MyException;
import assignments.assignment3.domain.Logger;
import assignments.assignment3.domain.User;
import assignments.assignment3.repository.ExceptionRepo;
import assignments.assignment3.repository.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    LoggerRepo loggerRepo;

    @Autowired
    ExceptionRepo exceptionRepo;

    @Pointcut("@annotation(assignments.assignment3.aspect.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint){
        long start = System.nanoTime();
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
            Object[] id = proceedingJoinPoint.getArgs();
            long finish = System.nanoTime();
            System.out.println(proceedingJoinPoint.getSignature().getName() + " takes: " + (finish - start) + " ns");
            Logger logger = new Logger((long)id[0], LocalDate.now(), (int)(finish - start), User.principle, proceedingJoinPoint.getSignature().getName());
            loggerRepo.save(logger);
        }
        catch(Throwable t){
            Object[] id = proceedingJoinPoint.getArgs();
            long finish = System.nanoTime();
            MyException exception = new MyException((long)id[0],LocalDate.now(),(int)(finish-start),User.principle, proceedingJoinPoint.getSignature().getName(), t.getClass().getSimpleName());
            exceptionRepo.save(exception);
        }
        return result;
    }
}


