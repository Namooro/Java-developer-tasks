package nosql.dao;

import nosql.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TaskRepository extends MongoRepository<Task, Integer> {

    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    Task findByName(final String taskName);


}
