import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.spring.aspects.ApplicationConfig;
import com.spring.aspects.service.SampleService;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class SampleServiceTest {

	@Autowired
	private SampleService service;
	
	@Test
	void test() {
		service.show(1, "HNT", DayOfWeek.SATURDAY);
		service.showWithLog(2, "TZA", DayOfWeek.SUNDAY);
	}
	
}
