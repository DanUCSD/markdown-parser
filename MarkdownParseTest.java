import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws Exception {
        Path fileName = Path.of(("test-file.md"));
        String content = Files.readString(fileName);
        String[] str = {"https://something.com", "some-page.html"};
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str));
        assertEquals(MarkdownParse.getLinks(content), arr);
    }
}