package com.c0x12c.kstatd

enum class MetricKind {
  COUNT,
  GAUGE,
  TIME,
  HISTOGRAM,
  DISTRIBUTION;

  /**
   * A dimension for the metric kind which is attached to every metric as metadata.
   */
  val dimension: MetricDimension
    get() {
      return MetricDimension("metric_kind", name.lowercase())
    }
}
