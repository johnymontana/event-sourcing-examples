package net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by lyonwj on 2/26/16.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers.QuerySideCustomerNeo4jRepository")
@EnableTransactionManagement
public class QuerySideCustomerNeo4jConfiguration extends Neo4jConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public Neo4jServer neo4jServer() {
        String neo4jURI = env.getProperty("SPRING_DATA_NEO4J_URI");
        //return new RemoteServer("http://localhost:7474");
        return new RemoteServer(neo4jURI);
    }

    @Bean
    public SessionFactory getSessionFactory() {
        // FIXME: with domain entity base packages
        return new SessionFactory("net.chrisrichardson.eventstore.javaexamples.banking.backend.queryside.customers.QuerySideNeo4jCustomer");
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }
}
