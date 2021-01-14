object Generate_ProcessorTile extends App {
var initFile = "src/test/resources/main.txt"

  chisel3.Driver.execute(args, () => new ProcessorTile(initFile))
} 
