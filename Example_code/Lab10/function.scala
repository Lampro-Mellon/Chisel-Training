// User type definition
type R = Int

// An example List
val uList = List(1, 2, 3, 4, 5)

// functional composition
def compose(g: R => R, h: R => R) =
  (x: R) => g(h(x))

// implement y = mx+c ( with m=2 and c =1)
def y1 = compose(x => x + 1, x => x * 2)
def y2 = compose(_ + 1, _ * 2)

val uList_map1 = uList.map(x => y1(x))
val uList_map2 = uList.map(y2(_))

println(s" Linearly mapped list 1 = $uList_map1 ")
println(s" Linearly mapped list 2 = $uList_map2 ")

// The output at the terminal
Linearly mapped list 1 = List (3, 5, 7, 9, 11)
Linearly mapped list 2 = List (3, 5, 7, 9, 11)
