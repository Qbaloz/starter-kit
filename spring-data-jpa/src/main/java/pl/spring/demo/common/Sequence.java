package pl.spring.demo.common;

import pl.spring.demo.entity.BookEntity;
import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public class Sequence {

    public long nextValue(Collection<BookEntity> bookEntity) {
        long result = bookEntity.size();
        return result + 1;
    }
}
