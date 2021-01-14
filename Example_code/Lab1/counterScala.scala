class Counter(counterBits: Int) {
val max = (1 << counterBits) - 1
var count = 0

if(count == max) {count = 0}
else {count = count + 1}
println(s"counter created with max value $max")
}
