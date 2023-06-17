package com.c0x12c.kstatd

/**
 * [Metric] is a contract that conform to enum pattern which
 * can be used to reinforce [aspect] uniqueness.
 */
interface Metric<E : Metric<E>> {
  val name: String

  /**
   * Aspect is the name of the metric in lowercase.
   */
  val aspect: String
    get() {
      return name.lowercase()
    }
}
