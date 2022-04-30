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
    public void testGetLinksFile() throws Exception {
        Path fileName = Path.of(("test-file.md"));
        String content = Files.readString(fileName);
        String[] str = {"https://something.com", "some-thing.html"};
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str));
        assertEquals(MarkdownParse.getLinks(content), arr);

    }

    @Test
    public void testGetLinksBrackets() throws Exception {
        Path fileName = Path.of(("test-brackets.md"));
        String content = Files.readString(fileName);
        ArrayList<String> arr = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(content), arr);
    }

    @Test
    public void testGetLinksBreak() throws Exception {
        Path fileName = Path.of(("test-break.md"));
        String content = Files.readString(fileName);
        String[] str = {"https://docs.microsoft.com/en-us/previous-versions/windows/internet-explorer/ie-developer/platform-apis/aa752574(v=vs.85)?redirectedfrom=MSDN"};
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(str));
        assertEquals(MarkdownParse.getLinks(content), arr);
    }

    @Test
    public void testGetLinksEmpty() throws Exception {
        Path fileName = Path.of(("test-empty.md"));
        String content = Files.readString(fileName);
        ArrayList<String> arr = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(content), arr);
    }

    @Test
    public void testFail(){
        assertEquals(1, 1+2);
    }
}