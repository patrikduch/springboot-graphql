# SpringBoot GraphQL 

<p><i>Example usage of GraphQL inside SpringBoot backend application.</i> </p>


## Main features

<ul>
    <li>multiple-datasources with JDBC</li>
    <li>graphQL</li>
    <li>migrations with Flyway</li>
</ul>


## Maintenance

### Port cleanup

```bash
sudo kill `sudo lsof -t -i:3000`
```


## Docker

docker buildx build --platform=linux/amd64 -f docker/Dockerfile.local  -t springboot-graphql:v1.0.0 .
