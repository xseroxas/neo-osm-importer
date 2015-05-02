package domain.repository.neo;

import domain.entity.Node;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gjurgo@gmail.com on 02/05/15.
 */
public interface NodeRepository extends CrudRepository<Node, String> {

    Node findByName(String name);

    Iterable<Node> findByConnectedWithName(String name);
}
