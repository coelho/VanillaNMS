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

* Minecraft Server 1.8: a028f00e678ee5c6aef0e29656dca091b5df11c7
* Minecraft Server 1.7.10: 952438ac4e01b4d115c5fc38f891710c4941df29
* Minecraft Server 1.6.4: 050f93c1f3fe9e2052398f7bd6aca10c63d64a87
* Minecraft Server 1.5.2: f9ae3f651319151ce99a0bfad6b34fa16eb6775f
* Minecraft Server 1.4.7: 2f0ec8efddd2f2c674c77be9ddb370b727dec676
* Minecraft Server 1.3.2: 3de2ae6c488135596e073a9589842800c9f53bfe
* Minecraft Server 1.2.5: d8321edc9470e56b8ad5c67bbd16beba25843336
