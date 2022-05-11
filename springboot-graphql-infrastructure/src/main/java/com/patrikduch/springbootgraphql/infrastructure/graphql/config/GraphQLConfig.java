package com.patrikduch.springbootgraphql.infrastructure.graphql.config;

import com.coxautodev.graphql.tools.SchemaParser;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.post.PostFieldResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.author.AuthorQueryResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.hello_world.HelloWorldQueryResolver;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail.ProjectDetailQueryResolver;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        GraphQLSchema schema  = SchemaParser.newParser()
                .resolvers(
                        projectDetailQuery(),
                        helloWorldQuery(),
                        authorQuery(),
                        authorFieldQuery()
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
   public AuthorQueryResolver authorQuery() {
        return new AuthorQueryResolver();
   }

   @Bean
   public PostFieldResolver authorFieldQuery() {
        return new PostFieldResolver();
   }

   @Bean
   public ProjectDetailQueryResolver projectDetailQuery()
   {
        return new ProjectDetailQueryResolver();
   }
}