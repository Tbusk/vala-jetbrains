# Development

This guide is intended for developers who want to contribute to this project. It covers the setup process, build system,
grammar files, available Gradle tasks, and releasing the plugin.

Before you start, please read the guidelines found in [CONTRIBUTING.md](../CONTRIBUTING.md).

## Table of Contents

- [Setup](./Development.md#setup)
- [Build System](./Development.md#build-system)
- [Grammar](./Development.md#grammar)
- [Gradle Tasks](./Development.md#gradle-tasks)
- [Releasing](./Development.md#releasing)

## Setup

Prerequisites

- Java Version 21 or later
- A JetBrains IDE (CLion, IntelliJ IDEA, etc.) -> not needed for development per se since testing will download and run
  the IDE plugin, but helpful for manual testing

Helpful, but not required, IDE plugins:

- [Grammar-Kit](https://plugins.jetbrains.com/plugin/6606-grammar-kit)
- [Plugin DevKit](https://plugins.jetbrains.com/plugin/22851-plugin-devkit)
- [PsiViewer](https://plugins.jetbrains.com/plugin/227-psiviewer)

## Build System

This project uses Gradle (Groovy DSL) to build the plugin with extensions to streamline the development and release
process.

It is available in this repository already under [gradlew](../gradlew) so no installation is required.

Setup:

- Versions for plugins and libraries (such as JUnit and GrammarKit) are defined
  in [libs.versions.toml](../gradle/libs.versions.toml).
- Various properties are defined in [gradle.properties](../gradle.properties).
- The build configuration is defined in [build.gradle](../build.gradle).
- A small amount of additional configuration is defined in [settings.gradle](../settings.gradle).

To update the version used:

1. Find the version under [Gradle Releases](https://gradle.org/releases/)
2. Update the version in [gradle.properties](../gradle.properties) under the `gradleVersion` property.
3. Find the sha256 checksum under [Gradle Checksums](https://gradle.org/release-checksums/) under the `Binary-only`
   section
4. Run the following command twice to update the Gradle wrapper. The first time will download the wrapper, the second time will update it:

**Linux/MacOS:**

```shell
./gradlew :wrapper --gradle-distribution-sha256-sum=<checksum>
```

**Windows:**

```shell
gradlew.bat :wrapper --gradle-distribution-sha256-sum=<checksum>
```

Replace `<checksum>` with the checksum you found in step 3.

## Grammar

This project defines grammar files using JFlex (lexer) and GrammarKit (parser) which are used to generate the lexer and
parser code.

You will need to regenerate the lexer and parser code whenever you make changes to the grammar files.

- Lexer: [Vala.flex](../src/main/java/dev/vala/jetbrains/lexer/Vala.flex)
- Parser: [Vala.bnf](../src/main/java/dev/vala/jetbrains/parser/Vala.bnf)

The generated code is placed in the [src/main/gen](../src/main/gen) directory.

## Gradle Tasks

The following tasks are useful when developing the plugin

### Generate Lexer

Generate a lexer using JFlex from the [Vala.flex](../src/main/java/dev/vala/jetbrains/lexer/Vala.flex) file.

**Linux/MacOS:**

```shell
./gradlew generateLexer
```

**Windows:**

```shell
gradlew.bat generateLexer
```

See [generateLexer](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#generateLexer)
for more details.

### Generate Parser

Generate the parser and PSI using GrammarKit from the [Vala.bnf](../src/main/java/dev/vala/jetbrains/parser/Vala.bnf)
file.

**Linux/MacOS:**

```shell
./gradlew generateParser
```

**Windows:**

```shell
gradlew.bat generateParser
```

See [generateParser](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#generateParser)
for more details.

### Build Plugin

Build the plugin and prepare a ZIP archive for testing and distribution. It will be placed in
the [build/distributions](../build/distributions) directory.

Linux/MacOS:

```shell
./gradlew buildPlugin
```

Windows:

```shell
gradlew.bat buildPlugin
```

See [buildPlugin](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#buildPlugin)
for more details.

### Run IDE

Runs a fresh IDE instance with the plugin installed and ready to test with the version and product specified in
the [gradle.properties](../gradle.properties) file under the `IntelliJ Platform Properties` section.

**Linux/MacOS:**

```shell
./gradlew runIde
```

**Windows:**

```shell
gradlew.bat runIde
```

See [runIde](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#runIde) for
more details.

### Verify The Plugin

Verify the plugin for binary compatibility before publishing to the Marketplace
using [IntelliJ Plugin Verifier CLI](https://plugins.jetbrains.com/docs/intellij/verifying-plugin-compatibility.html) to
ensure that the plugin is compatible and adheres to the standards set by JetBrains in order to be approved.

**Linux/MacOS:**

```shell
./gradlew verifyPlugin
```

**Windows:**

```shell
gradlew.bat verifyPlugin
```

See [verifyPlugin](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#verifyPlugin)
for more details.

### Publish Plugin

Publishes the plugin to the marketplace via gradle task. You can also upload the plugin's ZIP manually to the
marketplace if you have access to the community plugin management page.

You will need to have the following environment variables set to publish the plugin:

- `PUBLISH_TOKEN` - the authorization token used for publishing
- `CERTIFICATE_CHAIN` - the certificate chain used for signing
- `PRIVATE_KEY` - the private key used for signing
- `PRIVATE_KEY_PASSWORD` - the password for the private key used for signing

**Linux/MacOS:**

```shell
./gradlew publishPlugin
```

**Windows:**

```shell
gradlew.bat publishPlugin
```

See [publishPlugin](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#publishPlugin)
for more details.

## Releasing

In order to release a new version of the plugin:

1. Update the version in [gradle.properties](../gradle.properties), following [Semantic Versioning](https://semver.org/)
   guidelines
2. Update the changelog to include the latest changes in [CHANGELOG.md](../CHANGELOG.md)
   following [Keep a Changelog](https://keepachangelog.com/) guidelines
3. Update the draft release details in [GitHub Releases](https://github.com/vala-lang/vala-jetbrains/releases) with the
   changes and publish the release.

CI/CD via GitHub Actions will automatically build and publish the plugin to the JetBrains Marketplace when a new release
is created, and likely will be available within 48 hours, pending approval by the JetBrains team.

## Marketplace Description

The description for the plugin on the Marketplace is written
in [MarketplaceDescription.md](../MarketplaceDescription.md).

It is written in Markdown and is converted to HTML by JetBrains KT Extension Kit in [build.gradle](../build.gradle)
under the `intellijPlatform`, `pluginConfiguration`, `description` property.