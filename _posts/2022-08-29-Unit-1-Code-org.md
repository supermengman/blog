---
toc: true
layout: post
description: Learning about object oriented programming
categories: [markdown,code.org,collegeboard]
comments: true
title: Unit 1 Code.org learning
---

# Classes

Java classes are the basic building block, like a template for objects of the class. A class is defined in its own .java file, and the name of the file has to match with the class name.

![Code.org class header practice]({{site.baseurl}}/images/codeUnit1/classHeader.png)

A class can contain data (variables) and actions (methods). It can also extend functionality of another parent class, which will be discussed later in this blog.

# Instances of classes

The instance of a class is an object. It is defined in it's own java file, where attributes for the object instance can be set as well as methods for the object. 

To instance a class as an object, first type the class name, then the object name, equals new class();.

![Code.org class instance]({{site.baseurl}}/images/codeUnit1/classInstance.png)

As seen in the image above, the Painter class has been instanced, and the Painter object was defined in a separate file. 

# Object Calling Methods

The class definition probably contains some sort of methods for the object, when instanced, to do. To call a function, first write the object instance name, a period, and then the method called.

For example:

```java
Reader reader1 = new Reader(); // initiates new reader class instance called reader1
reader1.checkOutBook(bookName); // calls method checkOutBook with a given name
```

![Code.org class instance]({{site.baseurl}}/images/codeUnit1/classInstance.png)

As seen above, the object myPainter is also calling a method: move().

Calling methods is extremely common in the realm of Java programming, and often takes on other actions like doing math calculations or displaying text.

# Object Mutating Data

An object mutating data means that the object changes some sort of data. From last week, it can change the primitive data types plus the wrapper classes. However, it can also change the state of an object. This is not always a good thing, as it could change or break the program as well as increase memory usage.

Objects are reference type data. So, if you set another variable equal to that object and change some parameters, it automatically affects the original.

Sometimes that is what you want, changing the value of the object itself rather than having to make another object. 

For example, the String object is immutable. To change the string, a new string object must be created:

```Java
String a = "code code"
a = a.concat(" code") // has to make new string a again instead of just appending
```

StringBuilder is mutable, so the methods can just change the object
```Java
StringBuilder a = new StringBuilder("code code")
a.append(" code") // has to make new string a again instead of just appending
```

# Extends

As the name suggests, extends in java "extends" a class. The class created is inherited from another class, but more methods can be written in addition to the methods already in the original class. The attributes are also inherited.

The **subclass** is the class that inherits, while the **superclass** is the class being inherited from.

To extend, simply put ```extends``` and then the superclass. 

```super``` can also be used to refer to the superclass objects. Inside the class itself, ```super();``` can be called in order to inherit all the original methods and attributes.

![Code.org extends and super]({{site.baseurl}}/images/codeUnit1/extendsSuper.png)

As seen above, the PainterPlus class extends the Painter class, inheriting the attributes and methods with super. There is then a new method to turn right, being:

```java
public void turnRight() {
    this.turnLeft();
    this.turnLeft();
    this.turnLeft();
}
```

This can then be called in the main function by initializing a PainterPlus instance, and calling the method to turnRight like so:

```java
PainterPlus myPainterPlus = new PainterPlus(); 
myPainterPlus.turnRight();
```

This can be taken further with more sophisticated methods.

# Loops and Selection Statements

Like most programming languages, java also has while and if statements. 

In a while loop, as long as the condition is true, the code will continue repeating until it is false.

![Code.org while loop]({{site.baseurl}}/images/codeUnit1/whileExample.png)

This snippet of code uses a while loop so when the painter is on the bucket, it will take the paint until there is no more bucket.

As for if statements, it usually comes in a pair of if and else. If the condition is met, some code will run. If not, then the code under the else block will run instead. It reads like english.

![Code.org if statement]({{site.baseurl}}/images/codeUnit1/ifExample.png)

This one combines both while and if. While the painter can move, and isn't on a bucket, the painter will move. If it is not on a bucket, it will take paint, but once it cannot move, it will stop.

# Final Product of Code.org

![Code.org pattern]({{site.baseurl}}/images/codeUnit1/pattern.png)

Eventually, all these elements were combined to form a pattern in Lesson 14. A new class PatternPainter was created that extends Painter, and has methods to paint a checkerboard. The BackgroundPainter class was also created to extend Painter, and paint over any non-painted tiles. Finally, these were put together to form the final product.