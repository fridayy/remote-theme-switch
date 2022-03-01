# remote-theme-switch

![Build](https://github.com/fridayy/remote-theme-switch/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)


<!-- Plugin description -->

Provides an http endpoint in intellij to switch themes using said endpoint.

Nothing fancy huh.

<!-- Plugin description end -->

## Example

`$ curl -v "http://localhost:63342/api/rts?q=rose-pine"`

- Returns `HTTP 200` if successful
- Returns `HTTP 404` if the requested theme is not installed
- Returns `HTTP 400` if supplied the wrong query parameter

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "remote-theme-switch"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/fridayy/remote-theme-switch/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
