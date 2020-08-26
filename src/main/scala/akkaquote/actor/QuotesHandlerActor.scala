package akkaquote.actor

import akka.actor.Actor
import akkaquote.message.{AddHome, AddQuote, Home, HomeAdded, Quote, QuoteAdded, QuoteRequested, RequestQuote}

import scala.collection.mutable.ListBuffer
import scala.util.Random

class QuotesHandlerActor extends Actor {
      
  val quotes = new ListBuffer[Quote]
  val homes = new ListBuffer[Home]

  def receive = {

    case AddHome(home) => {
      homes += home
      println(s"Given price is :: ${home.price} location is: ${home.location} been added." + homes.toString())
      if (homes.length >0)
        sender() ! HomeAdded
      else
        sender() ! "Home not added"
    }
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