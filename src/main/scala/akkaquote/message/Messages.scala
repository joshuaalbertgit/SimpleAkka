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

