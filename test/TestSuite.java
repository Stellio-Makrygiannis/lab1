
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCarGetters.class,
        TestGasAndBreak.class,
        TestTruckMethods.class,
        TestCarTransport.class,
})
public class TestSuite {
}