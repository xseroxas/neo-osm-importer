package domain.entity;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gjurgo@gmail.com  on 02/05/15.
 */

@NodeEntity
public class Node {
    @GraphId
    Long id;
    public String name;

    public Node() {}
    public Node(String name) { this.name = name; }

    @RelatedTo(type="TEAMMATE", direction= Direction.BOTH)
    public @Fetch
    Set<Node> connectedWith;

    public void connectedWith(Node person) {
        if (connectedWith == null) {
            connectedWith = new HashSet<Node>();
        }
        connectedWith.add(person);
    }

    public String toString() {
        String results = name + "'s teammates include\n";
        if (connectedWith != null) {
            for (Node person : connectedWith) {
                results += "\t- " + person.name + "\n";
            }
        }
        return results;
    }
}
