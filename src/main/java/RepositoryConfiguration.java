import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Created by gjurgo@gmail.com on 02/05/15.
 */

@Configuration
@EnableNeo4jRepositories(basePackages = "domain.repository.neo")
public class RepositoryConfiguration extends Neo4jConfiguration {

    public RepositoryConfiguration() {
        setBasePackage("domain.repository.neo");
    }

}
