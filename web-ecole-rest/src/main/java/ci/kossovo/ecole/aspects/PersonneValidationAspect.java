package ci.kossovo.ecole.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PersonneValidationAspect {
//	private static final Logger log = LoggerFactory.getLogger(LogPersonneMetier.class);
			
	
	@Pointcut("execution(* ci.kossovo.ecole.metier.PersonneMetierImpl.creer(..))")
	private void valide() {};
	
	
}
