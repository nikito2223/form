### Blocks & Items
The mod adds new things, a planet, items, blocks and turrets

### Create Windows

1. Install JDK **17**.
2. Run `gradlew jar` [1].
3. Your mod jar will be in the `build/libs` directory. **Only use this version for testing on desktop. It will not work with Android.**
To build an Android-compatible version, you need the Android SDK. You can either let Github Actions handle this, or set it up yourself. See steps below.

## Adding Dependencies

Please note that all dependencies on Mindustry, Arc or its submodules **must be declared as compileOnly in Gradle**. Never use `implementation` for core Mindustry or Arc dependencies. 

- `implementation` **places the entire dependency in the jar**, which is, in most mod dependencies, very undesirable. You do not want the entirety of the Mindustry API included with your mod.
- `compileOnly` means that the dependency is only around at compile time, and not included in the jar.

Only use `implementation` if you want to package another Java library *with your mod*, and that library is not present in Mindustry already.

--- 

*[1]* *On Linux/Mac it's `./gradlew`, but if you're using Linux I assume you know how to run executables properly anyway.*  
*[2]: Yes, I know this is stupid. It's a Github UI limitation - while the jar itself is uploaded unzipped, there is currently no way to download it as a single file.*