package com.c0x12c.kstatd.datadog

import com.c0x12c.kstatd.MetricsClient
import com.timgroup.statsd.NonBlockingStatsDClientBuilder

/**
 * An implementation of [MetricsClient] that uses DataDog backend.
 * https://docs.datadoghq.com/tracing/metrics/
 * https://docs.datadoghq.com/developers/dogstatsd/?tab=containeragent
 *
 * @param hostname The hostname of the DataDog agent
 * @param port The port of the DataDog agent
 * @param prefix The prefix to prepend to all metrics
 * @param service The name of the service. For example: `service-rental`
 * @param deployable The name of the deployable which belongs to the service. For example: `api-rental`
 * @param environment The name of the environment. For example: `dev`, `staging`, `prod`
 */
fun MetricsClient.Companion.dataDog(
  hostname: String,
  port: Int,
  prefix: String = "",
  service: String,
  deployable: String,
  environment: String,
): MetricsClient {
  return DataDogMetricsClient(
    NonBlockingStatsDClientBuilder()
      .hostname(hostname)
      .port(port)
      .prefix(prefix)
      .constantTags(
        "deployable:$deployable",
        "service:$service",
        "environment:$environment",
      )
      .build()
  )
}
