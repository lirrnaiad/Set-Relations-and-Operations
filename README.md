# Set Relations and Operations

This project provides a sandbox for playing around with set relations and operations.  
A final project for **MS101 Discrete Mathematics**.

## Description

After the input of the two sets A and B, clicking the ``Get Set Relations / Get Set Operations`` button will generate results that will show what the relation of the two sets are and the resulting set if the different set operations were used upon the two sets.  
<br>
By clicking the ``Switch to Set Relations / Switch to Set Operations`` button, you can toggle whether to show the results for set relations or set operations.  
<br>
You can also toggle ``Toggle Notation`` if you prefer seeing the notation form of the different set relations and operations. Instead of seeing "A Union B", you'll see "A ∪ B".  
<br>
The ``Learn`` menu provides a few short descriptions and examples of the different set relations and operations to give a refresher on how they work.  
<br>
Here are a list of the set relations and operations that are used in this project:  
<br>
**Set Relations:**
- Equal Sets
- Equivalent Sets
- Subsets
- Disjoint Sets
- Power Set
<br>

**Set Operations:**
- Union
- Intersection
- Difference
- Complement
<br>


## Getting Started

### Dependencies

* Windows 10/11
* JDK 21
* atleast JavaFX 17 SDK

Make sure that your command line's Java version is atleast JDK 21. You can check it using the command `java -version`.

Here's what it looks like (if you downloaded the JDK from Oracle; if it's from OpenJDK it'll be different, the important thing is that it's version 21 of Java):
```
C:\>java -version
java version "21.0.1" 2023-10-17 LTS
Java (TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.1+12-LTS-29, mixed mode, sharing)
```

If it's not, take a look at **Executing program**.

### Installing

* Download JDK 21 (or newer) here: https://www.oracle.com/java/technologies/downloads/#java21.
* Download JavaFX 17 SDK (or newer) here: https://gluonhq.com/products/javafx/.
* On the **Releases** tab, install ``DiscreteMath.jar``.

### Executing program

* Make sure your command line is in the same repository using the ``cd`` command. For more info, check the **Help** section.
* Make sure your JDK is of version 21 or newer.
* Once everything has been set up, enter the command ``java -jar DiscreteMath.jar``.

It should show something like this:
```
C:\Users\Sean\Downloads>java -jar DiscreteMath.jar
May 27, 2024 7:33:13 AM com.sun.javafx.application.PlatformImpl startup
```
It may show another line like this, you can disregard it:
```
WARNING: Unsupported JavaFX configuration: classes were loaded from 'unnamed module @75c7137'
```

If any errors occur, refer to the next section.

## Help

### Error: Unable to access jarfile DiscreteMath.jar
Your command line is currently on the wrong directory. Make sure to move to the directory where the ``DiscreteMath.jar`` file is.  
<br>
If the .jar file is in the **Downloads** folder, then it is located at ``C:\Users\[username]\Downloads``, with [username] being the name of your user folder. For the example, I'll use **Sean** as the user folder.  
<br>
You can run this code:
```
cd C:\Users\Sean\Downloads
```
Your command line will then show what repository it is currently, you can then run `java -jar DiscreteMath.jar`:
```
C:\Users\Sean\Downloads>java -jar DiscreteMath.jar
```

### Error: LinkageError occurred while loading main class com.sets.discremathsets.Main
The JDK version your command line is currently using is not of JDK 21 or newer. 
<br>
Run ``java -version``. It should look something similar to this:
```
C:\>java -version
java version "21.0.1" 2023-10-17 LTS
Java (TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.1+12-LTS-29, mixed mode, sharing)
```
To fix this, make sure to download the appropriate JDK from the **Installing** section and install it. The ``jdk-21`` folder (or similar)'s default location will be at ``C:\Users\Program Files\Java``  
<br>
After this, make sure to change the PATH to the ``jdk-21`` folder (or similar). You can do this in two ways:  
#### Setting Temporary Path
* Copy the path of jdk/bin directory where Java is located (C:\Program Files\Java\jdk_version\bin)
* Write the command: ``SET PATH=C:\Program Files\Java\jdk_version\bin`` and hit enter.
* Run ``java -version`` again to check if it was successfully changed.

```
C:\>SET PATH=C:\Program Files\Java\jdk-21\bin

C:\>java -version
java version "21.0.1" 2023-10-17 LTS
Java (TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.1+12-LTS-29, mixed mode, sharing)
```

#### Setting Permanent Path
* Go to **This PC** and right click on it.
* Click on **Properties**.
* Under **Device Specifications**, there should be a related links section, click on **Advanced system settings**.
* Click on **Environment Variables**.

* Click on New tab of User variables, assign value ``JAVA_HOME`` to Variable Name
* ``java\jdk-21\bin`` path (copied path) to Variable Value and click on OK Button
* Finally, click on OK button.

## Version History

* 1.1.0
    * Added **set complement**
    * Added **power set**
    * Added **learn** menu item
    * See [commit change](https://github.com/lirrnaiad/Set-Relations-and-Operations/commits/master/) or See [release history](https://github.com/lirrnaiad/Set-Relations-and-Operations/releases)
* 1.0.0
    * Initial Release
