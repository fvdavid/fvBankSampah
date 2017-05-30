
package fv.monster.controller;

import fv.monster.model.Jual;
import fv.monster.repository.JualRepository;
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
@RequestMapping("/api/jual")
public class JualRestController {
    
    @Autowired
    private JualRepository jualRepository;
    
    // @PreAuthorize("hasAuthority('TRANSAKSI_VIEW')")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Jual>> findAllJual(Pageable pageable, HttpServletRequest req) {
        Page<Jual> page = jualRepository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    // @PreAuthorize("hasAuthority('TRANSAKSI_EDIT')")
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createJual(@RequestBody @Valid Jual jual, Authentication currentUser) {
        jual.setUsername(currentUser.getName());
        jual.setWaktuJual(new Date());
        jualRepository.save(jual);
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Jual> getJual(@PathVariable Long id, HttpServletRequest req) {
        Jual jual = jualRepository.findOne(id);
        return new ResponseEntity<>(jual, HttpStatus.OK);
    }
    
    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateJual(@RequestBody Jual jual) {
        jualRepository.save(jual);
    }

    @PreAuthorize("hasAuthority('RO_ADMINISTRATOR')")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteJual(@PathVariable Long id) {
        jualRepository.delete(id);
    }

}
