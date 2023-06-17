package com.c0x12c.kstatd.datadog

import com.c0x12c.kstatd.Metric
import com.c0x12c.kstatd.MetricKind
import com.c0x12c.kstatd.MetricDimension
import com.c0x12c.kstatd.MetricsClient
import com.timgroup.statsd.StatsDClient

/**
 * Default implementation of the MetricsClient interface based on [StatsDClient]
 */
internal class DataDogMetricsClient(
  private val client: StatsDClient
) : MetricsClient {

  companion object {
    private const val TAG_SEPARATOR = ":"

    private fun MetricDimension.asTag(): String {
      fun String.normalized(): String {
        return replace("|", "_").replace(":", "_")
      }
      return "${key.normalized()}$TAG_SEPARATOR${value.normalized()}"
    }

    private fun MetricKind.asTags(vararg dimensions: MetricDimension): Array<String> {
      return Array(dimensions.size + 1) { i ->
        if (i == dimensions.size) {
          dimension.asTag()
        } else {
          dimensions[i].asTag()
        }
      }
    }
  }

  override fun stop() {
    client.stop()
  }

  override fun close() {
    client.close()
  }

  override fun count(metric: Metric<*>, delta: Long, vararg dimensions: MetricDimension) {
    return client.count(metric.aspect, delta, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun count(metric: Metric<*>, delta: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.count(metric.aspect, delta, sampleRate, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun count(metric: Metric<*>, delta: Double, vararg dimensions: MetricDimension) {
    return client.count(metric.aspect, delta, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun count(metric: Metric<*>, delta: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.count(metric.aspect, delta, sampleRate, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun count(metric: Metric<*>, value: Long, timestamp: Long, vararg dimensions: MetricDimension) {
    return client.countWithTimestamp(metric.aspect, value, timestamp, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun count(metric: Metric<*>, value: Double, timestamp: Long, vararg dimensions: MetricDimension) {
    return client.countWithTimestamp(metric.aspect, value, timestamp, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun increment(metric: Metric<*>, vararg dimensions: MetricDimension) {
    return client.increment(metric.aspect, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun increment(metric: Metric<*>, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.increment(metric.aspect, sampleRate, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun decrement(metric: Metric<*>, vararg dimensions: MetricDimension) {
    return client.decrement(metric.aspect, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun decrement(metric: Metric<*>, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.decrement(metric.aspect, sampleRate, *MetricKind.COUNT.asTags(*dimensions))
  }

  override fun gauge(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension) {
    return client.gauge(metric.aspect, value, *MetricKind.GAUGE.asTags(*dimensions))
  }

  override fun gauge(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.gauge(metric.aspect, value, sampleRate, *MetricKind.GAUGE.asTags(*dimensions))
  }

  override fun gauge(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension) {
    return client.gauge(metric.aspect, value, *MetricKind.GAUGE.asTags(*dimensions))
  }

  override fun gauge(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.gauge(metric.aspect, value, sampleRate, *MetricKind.GAUGE.asTags(*dimensions))
  }

  override fun gauge(metric: Metric<*>, value: Double, timestamp: Long, vararg dimensions: MetricDimension) {
    return client.gaugeWithTimestamp(metric.aspect, value, timestamp, *MetricKind.GAUGE.asTags(*dimensions))
  }

  override fun gauge(metric: Metric<*>, value: Long, timestamp: Long, vararg dimensions: MetricDimension) {
    return client.gaugeWithTimestamp(metric.aspect, value, timestamp, *MetricKind.GAUGE.asTags(*dimensions))
  }

  override fun time(metric: Metric<*>, timeInMs: Long, vararg dimensions: MetricDimension) {
    return client.time(metric.aspect, timeInMs, *MetricKind.TIME.asTags(*dimensions))
  }

  override fun time(metric: Metric<*>, timeInMs: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.time(metric.aspect, timeInMs, sampleRate, *MetricKind.TIME.asTags(*dimensions))
  }

  override fun histogram(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension) {
    return client.histogram(metric.aspect, value, *MetricKind.HISTOGRAM.asTags(*dimensions))
  }

  override fun histogram(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.histogram(metric.aspect, value, sampleRate, *MetricKind.HISTOGRAM.asTags(*dimensions))
  }

  override fun histogram(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension) {
    return client.histogram(metric.aspect, value, *MetricKind.HISTOGRAM.asTags(*dimensions))
  }

  override fun histogram(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.histogram(metric.aspect, value, sampleRate, *MetricKind.HISTOGRAM.asTags(*dimensions))
  }

  override fun distribution(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension) {
    return client.distribution(metric.aspect, value, *MetricKind.DISTRIBUTION.asTags(*dimensions))
  }

  override fun distribution(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.distribution(metric.aspect, value, sampleRate, *MetricKind.DISTRIBUTION.asTags(*dimensions))
  }

  override fun distribution(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension) {
    return client.distribution(metric.aspect, value, *MetricKind.DISTRIBUTION.asTags(*dimensions))
  }

  override fun distribution(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
    return client.distribution(metric.aspect, value, sampleRate, *MetricKind.DISTRIBUTION.asTags(*dimensions))
  }
}
