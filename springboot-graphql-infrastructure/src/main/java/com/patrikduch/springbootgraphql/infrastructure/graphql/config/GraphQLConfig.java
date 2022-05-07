package com.patrikduch.springbootgraphql.infrastructure.graphql.config;

import com.coxautodev.graphql.tools.SchemaParser;
import com.patrikduch.springbootgraphql.infrastructure.graphql.resolvers.projectdetail.HelloWorldQueryResolver;
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
                .resolvers(projectDetailQuery(), helloWorldQuery())
                .file("graphql/query.graphqls")
                .file("graphql/project-detail.graphqls")
                .file("graphql/post.graphql")
                .file("graphql/comment.graphql")
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
    public ProjectDetailQueryResolver projectDetailQuery() {
        return new ProjectDetailQueryResolver();
    }
}