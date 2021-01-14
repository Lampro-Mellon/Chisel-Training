val xseq = Seq(2 -> 'a', 5 -> 'b', 3 -> 'c')

println(xseq(1))
println(xseq.apply(0))
println(xseq.length)
println(xseq.toList)

// following is printed to the terminal window 
(5,b)
(2,a)
3
List((2,a), (5,b), (3,c))