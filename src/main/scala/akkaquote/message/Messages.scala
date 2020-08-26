package akkaquote.message

import akka.actor.ActorRef

class Quote(val quote: String, val author: String)
class Home (val price: Double, val location: String)

case class AddQuote(quote: Quote)
case class AddHome(home : Home)

case class RequestQuote(originalSender: ActorRef)
case object PrintRandomQuote

case object QuoteAdded
case object HomeAdded
case class QuoteRequested(quote: Quote, originalSender: ActorRef)
case object QuotePrinted