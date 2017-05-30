package fv.monster.repository;

import fv.monster.model.Account;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Iterable<Account> findByIdIn(Collection<Long> ids);

    @Query("SELECT a FROM Account a where a.role = 'RO_ADMINISTRATOR'")
    List<Account> findAllAdmin();

    Account findOneByUserName(String name);

    Account findOneByEmail(String email);

    Account findOneByUserNameOrEmail(String username, String email);

    Account findOneByToken(String token);

    Account getProductById(Long id);

}
