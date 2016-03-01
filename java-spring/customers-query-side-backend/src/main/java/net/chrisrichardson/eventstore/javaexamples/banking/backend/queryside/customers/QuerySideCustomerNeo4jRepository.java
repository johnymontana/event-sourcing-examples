package net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lyonwj on 2/26/16.
 */

@Repository
public interface QuerySideCustomerNeo4jRepository extends GraphRepository<QuerySideNeo4jCustomer> {
    // FIXME: define (find?) queries here
}
