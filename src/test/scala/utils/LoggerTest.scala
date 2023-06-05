package utils

import org.scalatest.funsuite.AnyFunSuite

class LoggerTest extends AnyFunSuite {
  test("Console logger test") {
    assert(ConsoleLogger.inf("") === ())
    assert(ConsoleLogger.wrn("") === ())
    assert(ConsoleLogger.err("") === ())
  }

  test("Void logger test") {
    assert(VoidLogger.inf("") === ())
    assert(VoidLogger.wrn("") === ())
    assert(VoidLogger.err("") === ())
  }
}
