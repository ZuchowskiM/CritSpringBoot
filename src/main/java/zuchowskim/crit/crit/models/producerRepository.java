package zuchowskim.crit.crit.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

public interface producerRepository extends CrudRepository<producerModel, Integer> {

    List<producerModel> findByName(String Name);

    producerModel findById(int id);

}
