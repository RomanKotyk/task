package test.Task.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.Task.entity.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
