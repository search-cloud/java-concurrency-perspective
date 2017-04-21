package io.asion.concurrent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Asion.
 * @since 2017/4/21.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestJoin.class,
        TestPriority.class,
        TestRunnableSleep.class,
        TestYield.class
})
public class TestAll {}
