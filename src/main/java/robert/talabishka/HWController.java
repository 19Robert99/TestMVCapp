package robert.talabishka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Robert in 23.10.2018
 */
@RequestMapping("")
@Controller
public class HWController {
    @RequestMapping(method = RequestMethod.GET)
    public String printHW(ModelMap model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }
}
