# Volt Stream Processing quickstart

## Working with the example pipelines

There are three steps required to run the examples:
1. building the jar file
1. building the docker image and pushing it to registry
1. deploying the pipelines using helm

Depending on the features of Volt(SP) that will be used you might also need a `license.xml` file, a kafka broker, and a voltdb cluster.

### 1. Building the jar file

Java 17 is required to compile and build Volt(SP) applications.  

```shell
mvn clean package
```

### 2. Building the docker image 

Package the jar file it into a docker image that can be deployed into a Kubernetes cluster:

```shell
export YOUR_DOCKER_REGISTRY=...

docker build                                  \
      --platform="linux/amd64"                \
      -t ${YOUR_DOCKER_REGISTRY}:voltsp-quickstart--latest \
      -f src/main/resources/Dockerfile .
      
docker push ${YOUR_DOCKER_REGISTRY}:voltsp-quickstart--latest
```

The result is a docker image that contains __all__ the example pipeline code. You can use it multiple times, with different `yaml` configuration files to create different Volt(SP) pipelines in a Kubernetes cluster(s).

Depending on the kubernetes setup that you are using you might need to tag and push the docker image to some registry
from where Kubernetes is able to fetch it.

### 3. Deploying the pipelines

There are two example pipelines and two configuration files to deploy them:

- `random-to-kafka-pipeline.yaml`
- `kafka-to-volt-pipeline.yaml`

They are missing kafka broker and voltdb cluster addresses that you need to fill.

```shell
helm install pipeline1 voltdb/volt-stream-chart                       \
  --set-file streaming.licenseXMLFile=...                             \
  --set image.repository=YOUR_DOCKER_REGISTRY                         \
  --set image.tag=voltsp-quickstart--latest                           \
  --values src/main/resources/random-to-kafka-pipeline.yaml
  
helm install pipeline2 voltdb/volt-stream-chart                       \
  --set-file streaming.licenseXMLFile=...                             \
  --set image.repository=YOUR_DOCKER_REGISTRY                         \
  --set image.tag=voltsp-quickstart--latest                           \
  --values src/main/resources/kafka-to-volt-pipeline.yaml
```
