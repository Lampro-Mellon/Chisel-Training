// Derived class extending base class and mixins with traits
class DerivedClass extends BaseClass with Trait2 with Trait3{
    override def print(){ println("Derived Class") 
      super.print 
    }
}

// The output at the terminal
Derived Class
Trait 3
Trait 1
Trait 2
Base Class

// Derived class extending base class and mixins with traits
class DerivedClass extends BaseClass with Trait3 with Trait2{
    override def print(){ 
      println("Derived Class") 
      super.print 
    }
}

// The output at the terminal
Derived Class
Trait 2
Trait 3
Trait 1
Base Class