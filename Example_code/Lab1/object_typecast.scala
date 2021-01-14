class Parent { 
  val countP = 10
  def display(): Unit = {
  println("Parent counter : " + countP); 
  }
}
class Child extends Parent { 
  val countC = 12
  def displayC(): Unit = {
  println("Child counter : " + countC);
  }
}

object Top {
   def main(args: Array[String]): Unit = 
   {   
	var  pObject = new Parent()                      // parent object
	var  cObject = new Child()                       // child object
	var  castedObject = cObject.asInstanceOf[Parent] // object cast
      pObject.display()
      cObject.display()
      cObject.displayC()
      castedObject.display()
    } 
}