package hello;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	Logger logger = Logger.getLogger(GreetingController.class);

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        for(String s:greeting.getNames()){
        	logger.info(s);
        }
        return "result";
    }
    
    @RequestMapping(value="/greeting", params={"addRow"})
    public String addRow(final Greeting greeting, final BindingResult bindingResult) {
    	greeting.getNames().add(new String());
        return "greeting";
    }

    @RequestMapping(value="/greeting", params={"removeRow"})
    public String removeRow(
            final Greeting greeting, final BindingResult bindingResult, 
            final HttpServletRequest req) {
        final int rowId = Integer.valueOf(req.getParameter("removeRow"));
        logger.info("removing"+rowId);
        greeting.getNames().remove(rowId);
        return "greeting";
    }

}
