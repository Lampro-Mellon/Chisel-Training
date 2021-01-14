// An example Map using (key, value) pairs
val uMap = Map('a' -> 2, 'b' -> 4, 'c' -> 6)

// Applying .mapValues to Map 
val uMap_mapValues = uMap.mapValues(v => v*2)
println(s"Map values doubled using .mapValues = $uMap_mapValues")
 
def h(k:Int, v:Int) =  Some(k->v*2) 

// Applying .map to Map
val uMap_map = uMap.map { case (k,v) => h(k,v) }
println(s"Map values doubled using .map = $uMap_map")

// Applying .flatMap to Map
val uMap_flatMap = uMap.flatMap { case (k,v) => h(k,v) }
println(s"Map values doubled using .flatMap = $uMap_flatMap")

// The output at the terminal 
Map values doubled using .mapValues = Map(a -> 4, b -> 8, c -> 12)
Map values doubled using .map = List(Some((97,4)), Some((98,8)), Some((99,12)))
Map values doubled using .flatMap = Map(97 -> 4, 98 -> 8, 99 -> 12)