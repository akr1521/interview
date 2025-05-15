import app.model.Person;
import app.functional.StreamExpo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
public class StreamExpoTest {

    @InjectMocks
    StreamExpo streamExpo;
    @Test
    void test_groupingBy_InStream(){
        Map<String, List<Person>> map = streamExpo.usingGroupingBy();
        Assertions.assertNotNull(map);
    }
}
