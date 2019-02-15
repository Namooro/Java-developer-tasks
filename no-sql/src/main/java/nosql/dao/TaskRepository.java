package nosql.dao;

import nosql.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, Integer> {

    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    Optional<Task> findByName(final String taskName);

    @Query("{ 'description': {$regex: ?0, $options: 'i' }}")
    List<Task> findByDescription(final String description);

    @Query("{ 'category': {$regex: ?0, $options: 'i'}}")
    List<Task> findByCategory(final String category);

}
