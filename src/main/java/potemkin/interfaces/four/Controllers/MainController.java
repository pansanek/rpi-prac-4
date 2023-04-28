package potemkin.interfaces.four.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//http://localhost:8081/api/upload-string/HelloWorld
@Controller
@RequestMapping("/api")
public class MainController {
    @GetMapping("/upload-string/{data}")
    public String getResult(@PathVariable String data, Model model) {
        char[] charArray = data.toCharArray();
        int upper = 0;
        int lower = 0;
        int digit = 0;
        int others = 0;
        int totalChars = data.length();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isUpperCase(charArray[i])) {
                upper++;
            } else if (Character.isLowerCase(charArray[i])) {
                lower++;
            } else if (Character.isDigit(charArray[i])) {
                digit++;
            } else {
                others++;
            }
        }
        String answ = "Total length of the string: " + totalChars + "; Upper case: " + upper
                + "; Percentage of upper case letters: " + (upper * 100) / totalChars +
                "; Lower case: " + lower + "; Percentage of lower case letters: " +
                (lower * 100) / totalChars + "; Digit: " + digit + "; Percentage of digits: " +
                (digit * 100) / totalChars + "; Others: " + others + "; Percentage of other characters: "
                + (others * 100) / totalChars;

        model.addAttribute("info", answ);
        return "answer";
    }
}
