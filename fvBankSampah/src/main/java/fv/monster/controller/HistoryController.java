
package fv.monster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Controller
public class HistoryController {
    
    // @PreAuthorize("hasAuthority('RO_ADMINISTRATOR')")
    @GetMapping("/pages/history")
    public String history() {
        return "pages/history";
    }

}
