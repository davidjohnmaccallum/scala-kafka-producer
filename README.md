# Scala Kafka Producer

A minimal Scala Kafka producer.

See messages on topic:

```shell
bin/kafka-console-consumer.sh --topic davidstopic --from-beginning --bootstrap-server localhost:9092 --property print.timestamp=true --property print.key=true
```

