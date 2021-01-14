package LM_diplomacy_TL

import Chisel.Decoupled
import chisel3._
import freechips.rocketchip.config.Parameters
import freechips.rocketchip.diplomacy._
import freechips.rocketchip.tilelink._
import testchipip.TLHelper

class MemReq extends Bundle {
  val data =  UInt(64.W)
  val addr =  UInt(64.W)
  val wen  =  Bool()
  val mask =  UInt(8.W)
}
class MemResp extends Bundle {
  val data = UInt(64.W)
  //val addr = Input(UInt(64.W))
}

class MyClient(implicit p: Parameters) extends LazyModule {
  val node = TLHelper.makeClientNode("my-client1", IdRange(0, 1))

  lazy val module = new LazyModuleImp(this) {
    val io = IO(new Bundle{
      val req  = Flipped(Decoupled(new MemReq))
      val resp = Decoupled(new MemResp)
    })
    val (tl_out, edge) = node.out.head
    val deq_ready = RegNext(~io.req.fire())
    io.req.ready := deq_ready
    when(io.req.fire()){
      tl_out.a.valid := tl_out.a.ready

      when(io.req.bits.wen) {
        tl_out.a.bits := edge.Put(0.U,io.req.bits.addr,2.U,io.req.bits.data,io.req.bits.mask)._2
      } .otherwise {
        tl_out.a.bits := edge.Get(0.U, io.req.bits.addr, 2.U)._2
      }
    } .otherwise {
      tl_out.a.valid := false.B
    }


    val tl_d_ready = RegNext(~tl_out.d.fire())
    tl_out.d.ready := tl_d_ready
    io.resp.bits.data := tl_out.d.bits.data
    when(tl_out.d.fire()) {
      io.resp.valid := (tl_out.d.bits.opcode === 1.U & io.resp.ready)
    }.otherwise {
      io.resp.valid := false.B
    }

    tl_out.c.valid := false.B
    tl_out.e.valid := false.B
    tl_out.b.ready := true.B
  }
}


class MyManager(beatBytes: Int)(implicit p: Parameters) extends LazyModule {
  val device = new SimpleDevice("my-device", Seq("tutorial,my-device0"))
  //val beatBytes = 8
  val node = TLHelper.makeManagerNode(beatBytes, TLManagerParameters(
    address = Seq(AddressSet(0x0000, 0xfff)),
    resources = device.reg,
    regionType = RegionType.UNCACHED,
    executable = true,
    supportsArithmetic = TransferSizes(1, beatBytes),
    supportsLogical = TransferSizes(1, beatBytes),
    supportsGet = TransferSizes(1, beatBytes),
    supportsPutFull = TransferSizes(1, beatBytes),
    supportsPutPartial = TransferSizes(1, beatBytes),
    supportsHint = TransferSizes(1, beatBytes),
    fifoId = Some(0)))

  lazy val module = new LazyModuleImp(this) {
    val (tl, edge) = node.in.head
    val mem = Mem(2048,UInt(32.W))

    val a_ready = RegNext(~tl.a.fire())
    tl.a.ready := a_ready

    when(tl.a.fire() && tl.a.bits.opcode =/= 4.U){
      mem(tl.a.bits.address) := tl.a.bits.data
    }

    when(tl.a.fire() && tl.a.bits.opcode =/= 4.U){
      mem(tl.a.bits.address) := tl.a.bits.data
      tl.d.valid := true.B
      tl.d.bits := edge.AccessAck(tl.a.bits)
    }.elsewhen(tl.a.fire() && tl.a.bits.opcode === 4.U){
      tl.d.valid := tl.d.ready
      tl.d.bits := edge.AccessAck(tl.a.bits, mem(tl.a.bits.address))
    }. otherwise{
      tl.d.valid := false.B
    }
  }
}


class MyClientManager(implicit p: Parameters) extends LazyModule {
  val client = LazyModule(new MyClient)
  val manager = LazyModule(new MyManager(4))

  manager.node :=* client.node

  lazy val module = new LazyModuleImp(this) {
    val io = IO(new Bundle {
      val req = Flipped(Decoupled(new MemReq))
      val resp = Decoupled(new MemResp)
    })
    io <> client.module.io
  }
}

object lm_tilelink3 extends App{
  val verilog = chisel3.Driver.emitVerilog(
    LazyModule(new MyClientManagerComplex3()(Parameters.empty)).module
  )
  println(s"```verilog\n$verilog```")
  chisel3.Driver.execute(Array("--target-dir", "generated-src", "--split-modules"), () =>
    LazyModule(new MyClientManagerComplex3()(Parameters.empty)).module
  )
}
