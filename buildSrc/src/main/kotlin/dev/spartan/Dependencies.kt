package dev.spartan

object Dependencies {

  object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
  }

  object Metrics {
    const val dogStatsd = "com.datadoghq:java-dogstatsd-client:4.2.0"
  }

  object Testing {
    const val jupiter = "org.junit.jupiter:junit-jupiter:${Versions.junit5}"
    const val mockk = "io.mockk:mockk:1.12.4"
    const val strickt = "io.strikt:strikt-jvm:0.34.0"
  }
}
