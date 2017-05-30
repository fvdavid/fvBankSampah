
package fv.monster.controller;

import fv.monster.model.Transfer;
import fv.monster.repository.TransferRepository;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@RestController
@RequestMapping("/api/transfer")
public class TransferRestController {
    
    @Autowired
    private TransferRepository transferRepository;
    
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Transfer>> findAllTransfer(Pageable pageable, HttpServletRequest req) {
        Page<Transfer> page = transferRepository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransfer(@RequestBody @Valid Transfer transfer, Authentication currentUser) {
        transfer.setUsername(currentUser.getName());
        transfer.setWaktuTransfer(new Date());
        transferRepository.save(transfer);
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transfer> getTransfer(@PathVariable Long id, HttpServletRequest req) {
        Transfer transfer = transferRepository.findOne(id);
        return new ResponseEntity<>(transfer, HttpStatus.OK);
    }
    
    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateJual(@RequestBody Transfer transfer) {
        transferRepository.save(transfer);
    }

    @PreAuthorize("hasAuthority('RO_ADMINISTRATOR')")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteJual(@PathVariable Long id) {
        transferRepository.delete(id);
    }
}
