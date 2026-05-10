# JWebMP Local Storage Security

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/localstorage)](https://central.sonatype.com/artifact/com.jwebmp.plugins/localstorage)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

Provides access to read and write into the browser's local storage for device identification and session management. Creates unique identifiers in local storage for device tracking across Ajax and WebSocket connections.

Built on JWebMP · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.security.localstorage` · Java 25+

## Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>localstorage</artifactId>
  <version>2.0.0-SNAPSHOT</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:localstorage:2.0.0-SNAPSHOT")
```
</details>

## Quick Start

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 21+** (auto-integrated via JWebMP)

### Basic Usage

The plugin auto-registers via ServiceLoader SPI. It automatically:
- Creates a unique device identifier in the browser's local storage
- Transports local storage variables via Ajax calls and WebSocket connections
- Provides `@Named("localstorage") UUID` and `@Named("localstorage") String` injection

```java
@Inject
@Named("localstorage")
private UUID deviceId;
```

## Features

- **Zero Configuration** — Auto-registered via ServiceLoader SPI
- **Device Identification** — Unique UUID per browser instance via local storage
- **Ajax Integration** — Local storage variables transported via Ajax interceptor
- **WebSocket Integration** — Session management via WebSocket message receiver
- **Guice Injection** — `@Named("localstorage")` UUID and String providers
- **JPMS Module** — Fully modular with explicit dependencies

## Configuration

The plugin is automatically configured when present on the classpath. No manual registration needed.

## Testing

```bash
mvn clean test
```

## Links

- **GitHub Repository**: https://github.com/JWebMP/LocalStorage
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/localstorage
- **JWebMP Home**: https://jwebmp.com/

## License

Licensed under the [Apache License 2.0](LICENSE).

---

**Made with JWebMP**
