
package fv.monster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Controller
public class TransferController {
    
    @GetMapping("/pages/transfer")
    public String transfer() {
        return "pages/transfer";
    }

}
