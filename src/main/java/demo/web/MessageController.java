package demo.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 3/2/15
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MessageController {
  private static Logger logger = LoggerFactory.getLogger(MessageController.class);

  @RequestMapping("/")
  public String getAllMessages(Locale locale, Model model, HttpServletResponse response){
    List<Message> list = new ArrayList<>();
    list.add(new Message("yev hello"));
    list.add(new Message("yev test"));
    model.addAttribute("messages", list);
    return "index";
  }

  @RequestMapping(value = "/lang/**")
  public String changeLocale(Model model, RedirectAttributes attr){
    logger.error("change locale = ");
    attr.addAttribute("flashMes", "Your language has been changed to ");
    if (attr.containsAttribute("flashMes")){
     logger.error("show mes");
      model.addAttribute("flashMes","Your language has been changed to ");
    }

    return "redirect:/  ";
  }

}
