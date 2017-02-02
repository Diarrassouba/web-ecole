package ci.kossovo.ecole.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogPersonneMetier {
	private static final Logger log = LoggerFactory.getLogger(LogPersonneMetier.class);
	long t1,t2;
	@Pointcut("execution(* ci.kossovo.ecole.metier.IPersonnetMetier.*(..))")
	public void log1() {};

	@Before("log1()")
	public void avant(JoinPoint thisJoinPoint) {
		
		log.info("... DEBUT...");
		log.info("Methode: "+thisJoinPoint.getSignature().getName());
		log.info("Cible: "+Arrays.toString(thisJoinPoint.getArgs()));
	t1=System.currentTimeMillis();
	}
	
	@After("log1()")
	public void apres() {
		t2=System.currentTimeMillis();
		log.info("DUREE ="+(t2-t1));
		log.info("... FIN...");
	}

}
