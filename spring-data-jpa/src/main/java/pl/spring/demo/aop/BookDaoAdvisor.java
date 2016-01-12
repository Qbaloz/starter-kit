package pl.spring.demo.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.IdAware;

@Aspect
@Component
public class BookDaoAdvisor {

	@Before("@annotation(pl.spring.demo.annotation.NullableId) && args(idAware,..)")
	private void checkNotNullId(IdAware idAware){
		if(idAware.getId() != null){
			throw new BookNotNullIdException();
		}
	}
}
