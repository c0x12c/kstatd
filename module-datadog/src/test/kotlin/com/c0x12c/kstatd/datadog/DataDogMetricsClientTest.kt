package com.c0x12c.kstatd.datadog

import com.c0x12c.kstatd.Metric
import com.c0x12c.kstatd.MetricDimension
import com.timgroup.statsd.StatsDClient
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class DataDogMetricsClientTest {

  private enum class OnboardingMetrics : Metric<OnboardingMetrics> {
    LOGIN_SUCCESS,
    LOGIN_FAILURE;
  }

  private val statsd = mockk<StatsDClient>(relaxed = true)
  private val client = DataDogMetricsClient(statsd)

  @Test
  fun `stop should call statsd stop`() {
    client.stop()
    verify(exactly = 1) {
      statsd.stop()
    }
  }

  @Test
  fun `close should call statsd close`() {
    client.close()
    verify(exactly = 1) {
      statsd.close()
    }
  }

  @Test
  fun `count with dimension`() {
    client.increment(OnboardingMetrics.LOGIN_SUCCESS, MetricDimension("k1", "v1"))
    verify(exactly = 1) {
      statsd.increment("login_success", "k1:v1", "metric_kind:count")
    }
  }
}
