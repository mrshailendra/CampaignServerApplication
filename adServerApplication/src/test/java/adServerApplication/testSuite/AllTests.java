package adServerApplication.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import adServerApplication.adServerApplicationTest.AdServiceTest;

@RunWith(Suite.class)
@SuiteClasses({AdServiceTest.class})
public class AllTests {

}
