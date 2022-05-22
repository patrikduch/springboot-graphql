package com.patrikduch.springbootgraphql.infrastructure.graphql.config;

import com.coxautodev.graphql.tools.SchemaParser;
import com.patrikduch.springbootgraphql.core.interfaces.daos.AuthorDao;
import com.patrikduch.springbootgraphql.core.interfaces.daos.PostDao;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author.AuthorFieldResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author.AuthorQueryResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.hello_world.HelloWorldQueryResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post.PostFieldResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post.PostQueryResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail.ProjectDetailQueryResolver;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.SimpleGraphQLServlet;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GraphQLConfig {

    private final AuthorDao authorDao;
    private final PostDao postDao;

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        GraphQLSchema schema  = SchemaParser.newParser()
                .resolvers(
                        projectDetailQuery(),
                        helloWorldQuery(),
                        authorQuery(),
                        authorFieldQuery(),
                        postQuery(),
                        postFieldQuery()

                )
                .file("graphql/query.graphqls")
                .file("graphql/project-detail.graphqls")
                .file("graphql/post.graphqls")
                .file("graphql/comment.graphqls")
                .file("graphql/message.graphqls")
                .file("graphql/author.graphqls")
                .build().makeExecutableSchema();
        ExecutionStrategy executionStrategy = new AsyncExecutionStrategy();
        GraphQLServlet servlet = new SimpleGraphQLServlet(schema, executionStrategy);
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/graphql");
        return bean;
    }

   @Bean
   public HelloWorldQueryResolver helloWorldQuery() {
        return new HelloWorldQueryResolver();
   }

   @Bean
   public AuthorFieldResolver authorFieldQuery() {
        return new AuthorFieldResolver(authorDao);
   }

   @Bean
   public AuthorQueryResolver authorQuery() {
        return new AuthorQueryResolver(this.authorDao);
   }

   @Bean
   public PostQueryResolver postQuery() {
        return new PostQueryResolver();
   }

   @Bean
   public PostFieldResolver postFieldQuery() {
        return new PostFieldResolver(this.postDao);
   }

   @Bean
   public ProjectDetailQueryResolver projectDetailQuery()
   {
        return new ProjectDetailQueryResolver();
   }
}