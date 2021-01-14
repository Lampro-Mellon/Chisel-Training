class BaseClass{
  def print{ println("Base Class") }
}

trait Trait1 extends BaseClass{
    override def print(){ println("Trait 1") 
      super.print 
    }
}

trait Trait2 extends BaseClass{
    override def print(){ println("Trait 2") 
      super.print 
    }
}

trait Trait3 extends Trait1{
    override def print(){ println("Trait 3") 
      super.print 
    }
}

// Derived class extending base class and mixins with traits
class DerivedClass extends BaseClass with Trait2 with Trait3{
    override def print(){ println("Derived Class") 
      super.print 
    }
}

val printFun = new DerivedClass
printFun.print