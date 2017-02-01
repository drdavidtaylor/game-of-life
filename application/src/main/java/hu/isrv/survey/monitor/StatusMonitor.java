package hu.isrv.survey.monitor;

import hu.isrv.survey.processor.impl.Structure;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Aspect
@Component
public class StatusMonitor {
    private final static Logger log = LoggerFactory.getLogger(StatusMonitor.class);

    @AfterReturning(pointcut = "execution(* hu.isrv.survey.*LifeGameProcessor.*(..))", returning = "structure")
    public void stopTimer(JoinPoint joinPoint, Structure structure) {
        log.info("STRUCTURE PROCESSED: " + structure.getItems().size() + " items.");
    }
}

