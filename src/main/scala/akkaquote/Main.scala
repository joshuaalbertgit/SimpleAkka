package akkaquote

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import akkaquote.actor.QuotesHandlerActor
import akkaquote.message.{AddHome, Home}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Main extends App {

  val system = ActorSystem("AkkaQuote")
  val quoteActorRef = system.actorOf(Props[QuotesHandlerActor], "quotesActor")
  //quoteActorRef ! AddQuote(new Quote("Hello world", "Various book authors"))

  //implicit val timeout = Timeout(10 seconds)
  //val future1 = quoteActorRef ? AddQuote(new Quote("Hello world", "Various book authors"))
  //Await.result(future1, timeout.duration)


  //quoteActorRef ! AddHome(new Home(1000, "Kerala"))
  //quoteActorRef ! AddHome(new Home(10000, "Hyderabad"))

  implicit val timeout = Timeout(10 seconds)
  val f1 =  quoteActorRef ? AddHome(new Home(1000, "Kerala"))
  val f2 = quoteActorRef ? AddHome(new Home(10000, "Hyderabad"))

  Await.result(f1, timeout.duration)
  Await.result(f2, timeout.duration)
  println(s"future 1 :: $f1")
  println(s"future 2 :: $f2")

  /*
  implicit val timeout = Timeout(10 seconds)
  val future1 = quoteActorRef ? AddQuote(new Quote("Hello world", "Various book authors"))
  val future2 = quoteActorRef ? AddQuote(new Quote("To be or not to be", "W. Shakespeare"))
  val future3 = quoteActorRef ? AddQuote(new Quote("In the middle of difficulty lies opportunity", "A. Einstein"))
  Await.result(future1, timeout.duration)
  Await.result(future2, timeout.duration)
  Await.result(future3, timeout.duration)
  println(s"future1 :: $future1")

  val quotePrinterActorRef = system.actorOf(Props(new QuotePrinterActor(quoteActorRef)), "quotesPrinterActor")
  val future4 = quotePrinterActorRef ? PrintRandomQuote
  Await.result(future4, timeout.duration)
  println(s"future4 :: $future4")
  */


  /*
  implicit val timeout = Timeout(10 seconds)
  val future1 = quoteActorRef ? AddQuote(new Quote("Hello world", "Various book authors"))
  val future2 = quoteActorRef ? AddQuote(new Quote("To be or not to be", "W. Shakespeare"))
  val future3 = quoteActorRef ? AddQuote(new Quote("In the middle of difficulty lies opportunity", "A. Einstein"))

  Await.result(future1, timeout.duration)
  Await.result(future2, timeout.duration)
  Await.result(future3, timeout.duration)  

  val future4 = quotePrinterActorRef ? PrintRandomQuote
  Await.result(future4, timeout.duration)
  */

  system.terminate()
}