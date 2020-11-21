package controllers

import java.util.Properties
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import org.apache.kafka.clients.producer._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index = Action {

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val message = Json.obj("message" -> "Hello World!", "details" -> "Coding tradition.")
    val record = new ProducerRecord[String, String]("davidstopic", "key", Json.prettyPrint(message))
    producer.send(record)
    producer.close()

    Ok(message)

  }

}
