// TODO
package akka.cw.tracer
import akka.actor._
import java.util._
import akka.routing._
//
// Make this an actor and write a message handler for at least the
// set method.
//
object Coordinator extends App{
  def init(im: Image, of: String) = {
    image = im
    outfile = of
    waiting = im.width * im.height
  }

  // Number of pixels we're waiting for to be set.
  var waiting = 0
  var outfile: String = null
  var image: Image = null

  

  def print = {
    assert(waiting == 0)
    image.print(outfile)
  }
  
  case class MessageFromScene(x:Int, y:Int, c:Colour){
    
  }
    
   def set(x: Int, y: Int, c: Colour) = {
    image(x, y) = c
    waiting -= 1
    //println("printing waiting " + waiting)
   }
    // TODO: make set a message
 
  
  class CoordinatorActor extends Actor{
    def receive ={
      case MessageFromScene(x,y,c) => {
        println("setting 'set' with colour " + c)
        set(x,y,c)
      }
    }
    
  }
  

}
