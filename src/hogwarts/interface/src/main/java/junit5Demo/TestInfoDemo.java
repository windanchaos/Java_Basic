package junit5Demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;


@DisplayName("TestInfo Demo")
class TestInfoDemo {
    TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }

    @Nested

    class TestReporterDemo {
        @DisplayName("TEST 1")
        @Test
        void reportSingleValue(TestReporter testReporter) {
            testReporter.publishEntry("a status message");
        }
        @DisplayName("TEST 1")
        @Test
        void reportKeyValuePair(TestReporter testReporter) {
            testReporter.publishEntry("a key", "a value");
        }
        @DisplayName("TEST 1")
        @Test
        void reportMultipleKeyValuePairs(TestReporter testReporter) {
            Map<String, String> values = new HashMap<>();
            values.put("user name", "dk38");
            values.put("award year", "1974");

            testReporter.publishEntry(values);
        }

    }

}