package akkaquote.actor

import akka.actor.Actor
import akkaquote.message.{AddQuote, Quote, QuoteAdded, QuoteRequested, RequestQuote}

import scala.collection.mutable.ListBuffer
import scala.util.Random

class QuotesHandlerActor extends Actor {
      
  val quotes = new ListBuffer[Quote]

  def receive = {
    case AddQuote(quote) => {
      quotes += quote
      println(s"Given quote is :: ${quote.quote} author is: ${quote.author} been added." + quotes.toString())
      sender ! QuoteAdded
    }

    case RequestQuote(originalSender) => {
      val index = Random.nextInt(quotes.size)
      sender ! QuoteRequested(quotes(index), originalSender)
    }
  } 
}