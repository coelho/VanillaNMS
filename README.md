VanillaNMS
=============

Bukkit plugin that loads versioned NMS jars as a library for use during runtime.

### Building ###

We use maven to build the project.
```bash
$ mvn clean install
```

### Usage ###

1. Start the server once to generate the "plugins/VanillaNMS" folder.
2. Place your Minecraft Server jar files in the folder.
3. Start the server

If you are a developer, the output jar that you will build against will be "plugins/VanillaNMS/\<version\>.jar.refactored"

### Supported Versions ###

Minecraft Server 1.8: a028f00e678ee5c6aef0e29656dca091b5df11c7
