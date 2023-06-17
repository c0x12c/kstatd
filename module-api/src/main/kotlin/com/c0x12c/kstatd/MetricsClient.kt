package com.c0x12c.kstatd

import java.io.Closeable

/**
 * A convenient interface that is more Kotlin-centric for sending metrics to a statsd server.
 */
interface MetricsClient : Closeable {
  /**
   * Cleanly shut down this client. This method may throw an exception if
   * the socket cannot be closed.
   */
  fun stop()

  /**
   * Stop the client
   *
   * @see .stop
   */
  override fun close()

  /**
   * Adjusts the specified counter by a given delta.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to adjust
   * @param delta the amount to adjust the counter by
   * @param dimensions array of dimensions to be added to the data
   */
  fun count(metric: Metric<*>, delta: Long, vararg dimensions: MetricDimension)

  /**
   * Adjusts the specified counter by a given delta.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to adjust
   * @param delta the amount to adjust the counter by
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun count(metric: Metric<*>, delta: Long, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Adjusts the specified counter by a given delta.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to adjust
   * @param delta the amount to adjust the counter by
   * @param dimensions array of dimensions to be added to the data
   */
  fun count(metric: Metric<*>, delta: Double, vararg dimensions: MetricDimension)

  /**
   * Adjusts the specified counter by a given delta.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to adjust
   * @param delta the amount to adjust the counter by
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun count(metric: Metric<*>, delta: Double, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Set the counter metric at the given time to the specified value.
   *
   * Values with an explicit timestamp are never aggregated and
   * will be recorded as the metric value at the given time.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to adjust
   * @param value the amount to adjust the counter by
   * @param timestamp timestamp of the value, as seconds from the epoch of 1970-01-01T00:00:00Z
   * @param dimensions array of dimensions to be added to the data
   */
  fun count(metric: Metric<*>, value: Long, timestamp: Long, vararg dimensions: MetricDimension)

  /**
   * Set the counter metric at the given time to the specified value.
   * Values with an explicit timestamp are never aggregated and
   * will be recorded as the metric value at the given time.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to adjust
   * @param value the amount to adjust the counter by
   * @param timestamp timestamp of the value, as seconds from the epoch of 1970-01-01T00:00:00Z
   * @param dimensions array of dimensions to be added to the data
   */
  fun count(metric: Metric<*>, value: Double, timestamp: Long, vararg dimensions: MetricDimension)

  /**
   * Increments the specified counter by one.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to increment
   * @param dimensions array of dimensions to be added to the data
   */
  fun increment(metric: Metric<*>, vararg dimensions: MetricDimension)

  /**
   * Increments the specified counter by one.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to increment
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun increment(metric: Metric<*>, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Decrements the specified counter by one.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to decrement
   * @param dimensions array of dimensions to be added to the data
   */
  fun decrement(metric: Metric<*>, vararg dimensions: MetricDimension)

  /**
   * Decrements the specified counter by one.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the counter to decrement
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun decrement(metric: Metric<*>, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Records the latest fixed value for the specified named gauge.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the gauge
   * @param value the new reading of the gauge
   * @param dimensions array of dimensions to be added to the data
   */
  fun gauge(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension)

  /**
   * Records the latest fixed value for the specified named gauge.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the gauge
   * @param value the new reading of the gauge
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun gauge(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Records the latest fixed value for the specified named gauge.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the gauge
   * @param value the new reading of the gauge
   * @param dimensions array of dimensions to be added to the data
   */
  fun gauge(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension)

  /**
   * Records the latest fixed value for the specified named gauge.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the gauge
   * @param value the new reading of the gauge
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun gauge(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Set the gauge metric at the given time to the specified value.
   *
   * Values with an explicit timestamp are never aggregated and
   * will be recorded as the metric value at the given time.
   *
   * @param metric the name of the gauge
   * @param value the new reading of the gauge
   * @param timestamp timestamp of the value, as seconds from the epoch of 1970-01-01T00:00:00Z
   * @param dimensions array of dimensions to be added to the data
   */
  fun gauge(metric: Metric<*>, value: Double, timestamp: Long, vararg dimensions: MetricDimension)

  /**
   * Set the gauge metric at the given time to the specified value.
   *
   * Values with an explicit timestamp are never aggregated and
   * will be recorded as the metric value at the given time.
   *
   * @param metric the name of the gauge
   * @param value the new reading of the gauge
   * @param timestamp timestamp of the value, as seconds from the epoch of 1970-01-01T00:00:00Z
   * @param dimensions array of dimensions to be added to the data
   */
  fun gauge(metric: Metric<*>, value: Long, timestamp: Long, vararg dimensions: MetricDimension)

  /**
   * Records an execution time in milliseconds for the specified named operation.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the timed operation
   * @param timeInMs the time in milliseconds
   * @param dimensions array of dimensions to be added to the data
   */
  fun time(metric: Metric<*>, timeInMs: Long, vararg dimensions: MetricDimension)

  /**
   * Records an execution time in milliseconds for the specified named operation.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the timed operation
   * @param timeInMs the time in milliseconds
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun time(metric: Metric<*>, timeInMs: Long, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named histogram.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the histogram
   * @param value the value to be incorporated in the histogram
   * @param dimensions array of dimensions to be added to the data
   */
  fun histogram(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named histogram.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the histogram
   * @param value the value to be incorporated in the histogram
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun histogram(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named histogram.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the histogram
   * @param value the value to be incorporated in the histogram
   * @param dimensions array of dimensions to be added to the data
   */
  fun histogram(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named histogram.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the histogram
   * @param value the value to be incorporated in the histogram
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun histogram(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named distribution.
   *
   *
   * This method is a DataDog extension, and may not work with other servers.
   *
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the distribution
   * @param value the value to be incorporated in the distribution
   * @param dimensions array of dimensions to be added to the data
   */
  fun distribution(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named distribution.
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the distribution
   * @param value the value to be incorporated in the distribution
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun distribution(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named distribution.
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the distribution
   * @param value the value to be incorporated in the distribution
   * @param dimensions array of dimensions to be added to the data
   */
  fun distribution(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension)

  /**
   * Records a value for the specified named distribution.
   *
   *
   * This method is a DataDog extension, and may not work with other servers.
   *
   *
   * This method is non-blocking and is guaranteed not to throw an exception.
   *
   * @param metric the name of the distribution
   * @param value the value to be incorporated in the distribution
   * @param sampleRate percentage of time metric to be sent
   * @param dimensions array of dimensions to be added to the data
   */
  fun distribution(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension)

  companion object {

    val NOOP = object : MetricsClient {
      override fun stop() {
        // NOOP
      }

      override fun close() {
        // NOOP
      }

      override fun count(metric: Metric<*>, delta: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun count(metric: Metric<*>, delta: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun count(metric: Metric<*>, delta: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun count(metric: Metric<*>, delta: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun count(metric: Metric<*>, value: Long, timestamp: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun count(metric: Metric<*>, value: Double, timestamp: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun increment(metric: Metric<*>, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun increment(metric: Metric<*>, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun decrement(metric: Metric<*>, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun decrement(metric: Metric<*>, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun gauge(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun gauge(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun gauge(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun gauge(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun gauge(metric: Metric<*>, value: Double, timestamp: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun gauge(metric: Metric<*>, value: Long, timestamp: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun time(metric: Metric<*>, timeInMs: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun time(metric: Metric<*>, timeInMs: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun histogram(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun histogram(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun histogram(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun histogram(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun distribution(metric: Metric<*>, value: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun distribution(metric: Metric<*>, value: Double, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun distribution(metric: Metric<*>, value: Long, vararg dimensions: MetricDimension) {
        // NOOP
      }

      override fun distribution(metric: Metric<*>, value: Long, sampleRate: Double, vararg dimensions: MetricDimension) {
        // NOOP
      }

    }
  }
}
