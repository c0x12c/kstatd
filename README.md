kstatd
=======
The **kstatd** library provides a Kotlin-centric interface for sending metrics to a StatsD server.
This library simplifies the process of recording various types of metrics, including counters, gauges, execution times,
histograms, and distributions. It is designed to be non-blocking, ensuring smooth metric recording without exceptions.
With **kstatd**, you can add dimensions to your metrics to provide valuable context to your data.

## Features

- Kotlin-centric interface for StatsD metrics.
- Non-blocking methods for efficient metric recording.
- Support for various metric types and dimensions.
- Easy integration with StatsD servers, such as Datadog.

## Download

```groovy
repositories {
  mavenCentral()
}

dependencies {
  implementation("com.c0x12c.kstatd:1.0.0")
}
```

## Usage

```kt
import com.c0x12c.kstatd.MetricsClient
import com.c0x12c.kstatd.data.MetricsClientFactory.Companion.dataDog

// Initialize the MetricsClient
val client = MetricsClient.Companion.dataDog(
  host = "localhost",
  port = 8125,
  prefix = "my-company",
  service = "service-foo",
  deployable = "api-bar",
  environment = "production"
)

// Record a counter metric
client.count("requests.total", 1)

// Record a gauge metric
client.gauge("temperature", 25.5)

// Record an execution time
client.time("database.query.time", 150)

```
