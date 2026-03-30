package it.unibo.pps.polyglot.a05b

import it.unibo.pps.polyglot.a05b.Logics

import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:
  private val random = new Random()
  private val position: (Int, Int) = (this.random.nextInt(this.size - 2) + 1, this.random.nextInt(this.size - 2) + 1)
  private var tickCount: Int = 0

  override def tick(): Unit =
    this.tickCount = this.tickCount + 1

  override def isOver: Boolean =
    this.position._1 - this.tickCount < 0 || this.position._1 + this.tickCount >= this.size ||
      this.position._2 - this.tickCount < 0 || this.position._2 + this.tickCount >= this.size

  override def hasElement(x: Int, y: Int): Boolean =
    (x, y) == this.position ||
      (Math.abs(x - this.position._1) <= this.tickCount && Math.abs(y - this.position._2) <= this.tickCount &&
        (x == this.position._1 || y == this.position._2 || Math.abs(x - this.position._1) == Math.abs(y - this.position._2)))
