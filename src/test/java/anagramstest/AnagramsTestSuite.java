package anagramstest;

import filescannertest.FileScannerTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import servicetest.AnagramsMatcherImplTest;

/**
 *
 * @author haran
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AnagramsMatcherImplTest.class, FileScannerTest.class})
public class AnagramsTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

}
