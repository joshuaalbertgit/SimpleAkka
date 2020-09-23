package akkaquote.message

import akka.actor.ActorRef

class Quote(val quote: String, val author: String)

case class AddQuote(quote: Quote)
case object QuoteAdded

case class QuoteRequested(quote: Quote, originalSender: ActorRef)
case class RequestQuote(originalSender: ActorRef)

case object PrintRandomQuote
case object QuotePrinted


// for HOME operations
class Home (val price: Double, val location: String)
case class AddHome(home : Home)
case object HomeAdded

//create a topic
class CreateTopic
case class createTopic(name: String)
case object TopicCreated

//send a message to a TOPIC
class CreateProducer
case class createRecord(topicName: String)
case class sendMsgToProducer(recordName: String)

//consume the message from a TOPIC
class CreateConsumer
case class subscribe(topicName: String)
case class getMessages(recordName: List[String])
