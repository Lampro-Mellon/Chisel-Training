// Exception checking in rocket core
def checkExceptions(x: Seq[(Bool, UInt)]): (Bool, UInt) =  
// Seq of exception flags, cause of exception
    (x.map(_._1).reduce(_||_), PriorityMux(x))

// Hazard checking in rocket core
def checkHazards(targets: Seq[(Bool, UInt)], cond: UInt => Bool): Bool =
    targets.map(h => h._1 && cond(h._2)).reduce(_||_)


