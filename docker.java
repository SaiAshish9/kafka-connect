```
version: '2'

services: 
  kafka-cluster:
    image: landoop/fast-data-dev:cp3.3.0
    environment:
      ADV_HOST: 127.0.0.1
      RUNTESTS: 0
    ports:
      - 2181:2181
      - 3030:3030
      - 8081-8083:8081-8083
      - 9581-9585:9581-9585
      - 9092:9092

  elasticsearch:
      image: itzg/elasticsearch:2.4.3
      environment:
        PLUGINS: appbaseio/dejavu
        OPTS: -Dindex.number_of_shards=1 -Dindex.number_of_replicas=0
      ports:
        - "9200:9200"
  
```
