import com.epam.jwd.hardziyevich.text_app.TextStorage.TextStorage;
import com.epam.jwd.hardziyevich.text_app.composition.Text;
import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

import org.junit.jupiter.api.Test;


public class MainTest {
    @Test
    public void test() {
        String text = TextStorage.initText("F:\\Work\\JWD\\TextApp\\src\\main\\resources\\Text.txt");
        System.out.println("Text from file: ");
        System.out.println(text);

        TextComponent root = new Text();
        root.setValue(text);
        root.add(root);
        System.out.println("\nOriginal text with calculated expressions: ");
        System.out.println(root.build());
    }
}
