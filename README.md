# Vala Language for JetBrains IDEs

![Build](https://github.com/vala-lang/vala-jetbrains/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/27464-vala-language.svg)](https://plugins.jetbrains.com/plugin/27464-vala-language)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/27464-vala-language.svg)](https://plugins.jetbrains.com/plugin/27464-vala-language)

Adds Vala language support for JetBrains IDEs, including:

- Syntax highlighting
- Diagnostics
- Go to definition
- Hover documentation
- Code completion
- Code formatting
- New project wizard for Meson and non-Meson projects
- Code style configurability
- Vala-Lint support

## Requirements

Many features require the [vala-language-server](https://github.com/vala-lang/vala-language-server), which must be installed separately. See the [Language Server](./docs/LanguageServer.md) documentation for more details.

CLion is the only IDE with native Meson project support, so if you use another IDE, you must run Meson build commands manually.

## Installation

- Using the IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Vala
  Language"</kbd> >
  <kbd>Install</kbd>

- Using JetBrains Marketplace:

  Go to [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/27464-vala-language) and install it by clicking
  the <kbd>Install to ...</kbd> button in case your IDE is running.

  You can also download the [latest release](https://plugins.jetbrains.com/plugin/27464-vala-language/versions) from
  JetBrains Marketplace and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

- Manually:

  Download the [latest release](https://github.com/vala-lang/vala-jetbrains/releases/latest) and install it manually
  using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Screenshots

<img src="images/image_one.png" width="600" alt="image one"/>
<img src="images/image_two.png" width="600" alt="image two"/>
<img src="images/image_three.png" width="600" alt="image three"/>
<img src="images/image_four.png" width="600" alt="image four"/>
<img src="images/image_five.png" width="600" alt="image five"/>
<img src="images/image_six.png" width="600" alt="image six"/>

## Development

Thanks for your interest in the project! To get started, check out the [Development](./docs/Development.md)
and [Contributing](./CONTRIBUTING.md) guides. You can find information on how to build the project, parser, lexer,
release a new version, and more.

## Contact

If you have any questions, feel free to open an issue here or reach out on the [Vala Discord](https://discord.gg/CXbPv2MT98) server.