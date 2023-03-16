---
toc: true
layout: post
description: correcting moment
categories: [markdown,collegeboard]
comments: true
title: Test Corrections 39 Q
---

# Stats
Score: 36/39
Total Score: 0.92
Time: 45 minutes

# Q3 A and B Classes with show method

consider the following two classes 
```java
public class A
{
    public void show()
    {
        System.out.println("A");
    }
}

public class B extends A
{
    public void show()
    {
        System.out.println("B");
    }
}
```

WHat is printed when the following code is executed?
```java
A obj = new B();
obj.show();
```

I chose A: A, but it was B: B. This would be the result if obj was instantiated as a new A object instead of a new B object.

The object cretaed is type B, so the show method is in B.

# Q33 Find maximum in 1D array
I. 
```java
int max = Integer.MIN_VALUE;
for (int value : array)
{
    if (value > max)
    {
        max = value;
    }
}
```

II.
```java
int max = 0;
boolean first = true;
for (int value : array)
{
    if (first)
    {
        max = value;
        first = false;
    }
    else if (value > max)
    {
        max = value;
    }
}
```

III.
```java
int max = arr[0];
for (int k = 1; k < arr.length; k++)
{
    if (arr[k] > max)
    {
        max = arr[k];
    }
}
```

I chose D: II and III only. Choice I sets max to Integer.MIN_VALUE, which is the smallest possible integer value. Then it accesses each element in arr and assigns them value. If value is greater than max, max is assigned value since it is now the largest value so far.

I didn't know what Integer.MIN_VALUE was.

# Q39

```java
List<String> students = new ArrayList<String>();

students.add("Alex");
students.add("Bob");
students.add("Carl");

for (int k = 0; k < students.size(); k++)
{
    System.out.print(students.set(k, "Alex") + " ");
}

System.out.println();

for (String str : students)
{
    System.out.print(str + " ");
}
```

I chose A: Alex Alex Alex 
Alex Alex Alex. However, the set method returns the previous value, not the new value set by Alex. 

So, the output is C: Alex Bob Carl Alex Alex Alex.