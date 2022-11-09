---
toc: true
layout: post
description: correcting moment
categories: [markdown,collegeboard]
comments: true
title: Test Corrections 2014 Practice
---

# Q4 Selection with variables x and y

```java
int x = 7;
int y = 3;

if ((x<10) && (y<0))
    System.out.println("Value is: " + x*y);
else
    System.out.println("Value is: " + x/y);
```

I chose A: Value is 21. This was because I misread the condition, believing it to be y < 10 instead of 0. So, I thought the condition would evaluate to true. Instead, it is false, so the else code block should run. as x and y are integers, the x/y must also return an integer, truncating the decimals in 7/3 to 2. The answer is C.

# Q23 manipulate method and animals list

```java
private List<String> animals;

public void manipulate()
{
    for (int k = animals.size() -1; k>0; k--)
    {
        if (animals.get(k).substring(0,1).equals("b"))
        {
            animals.add(animals.size()-k,animals.remove(k));
        }
    }
}

animals list is initialized as 
["bear", "zebra", "bass", "cat", "koala", "baboon"]
```

I chose D: 
["bear", "baboon", "zebra", "bass", "cat", "koala"].

For this one, I did not fully iterate through the loop in my head. The code basically moves any animal with a b into the "opposite" index (being the index that is the same amount of indices away from the other side of the list). However, as it goes throughout the whole thing, it would swap the b animals back to their right spot, so it's just the original again.

Answer is B: 
["bear", "zebra", "bass", "cat", "koala", "baboon"]

# Q26 Print odd integers in 1D array but not even

I basically misinterpreted what a for each loop would do, thinking that each x would be an index when in actuality it is the actual element. So, it should be A:

```java
for (int x: arr)
    if (x % 2 != 0)
        System.out.println(x);
```