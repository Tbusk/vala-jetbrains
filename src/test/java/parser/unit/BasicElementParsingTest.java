package parser.unit;

import com.intellij.testFramework.ParsingTestCase;
import dev.vala.jetbrains.ValaParserDefinition;

public class BasicElementParsingTest extends ParsingTestCase {

    public BasicElementParsingTest() {
        super("", "vala", new ValaParserDefinition());
    }

    public void testSampleNamespace() {
        doTest(true);
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}
