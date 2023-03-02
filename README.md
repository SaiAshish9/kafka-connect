https://kafka.apache.org/documentation/#connect

```
Let's say we've multiple data sources (in) to ingest data into kafka cluster (multiple target data store(out)) from where we need
to write data to kafka cluster.

Producer have lot of sources and consumers have different targets.
```

<img width="857" alt="Screenshot 2023-03-02 at 10 51 56 PM" src="https://user-images.githubusercontent.com/43849911/222504277-1c987640-9775-4cef-a4c8-1d79746e378c.png">

```
For a developer it will be made to write the code for n number of custom ports and n number of destination systems (postgres, snowflake and elaticsearch).

And lets say we need to consume textfile via postgres, some other developers might have already done that job.

If a engineer worked on that kind of source and destination. We can reuse their code via certain config changes.

That's where kafka connect comes into picture. 

kafka connect is robust, scalable, low and no port configuration driven approach using which we can pool data from 
various source systems and publish to kafka cluster.

Similarly, we can consume data in different target systems.

If some developer is already worked on that source and destination topic, we can make use of their reusable code and modify 
certain configuration. This is known as configuration driven approach.

Kafak connects solves one of our major problem. If we've different sources and targets then consuming the data from kafka cluster
and publishing to kafka cluster to different target systems, we can use reusable a configuration driven helper called kafka connect.

So its basically a jar file which different developers can edit.
```
