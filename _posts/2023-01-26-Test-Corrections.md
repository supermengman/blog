---
toc: true
layout: post
description: correcting moment
categories: [markdown,collegeboard]
comments: true
title: Test Corrections 66 Q
---

# Stats
Score: 61/66
Total Score: 0.95
Time: 75 minutes
Weak Areas: 

# Q36 
The question refer to the code from the GridWorld case study.

Consider the following declarations.

```java
Actor a = new Actor();

Bug b = new Bug();

Rock r = new Rock();

Critter c = new Critter();
```
 

Consider the following lines of code.

```java
Line 1:      int dir1 = c.getDirection();

Line 2:      int dir2 = a.getDirection();

Line 3:      int dir3 = b.getDirection();

Line 4:      ArrayList<Location> rLoc = r.getMoveLocations();

Line 5:      ArrayList<Location> cLoc = c.getMoveLocations();
```

Which of the lines of code above will cause a compile time error?

I chose A: Line 1, but it was C :Line 4. I didn't have context for the actual question.

# Q52 Raise Price
```java
public class Toy

{

private String name;

private double price;

public Toy(String n, double p)

{

name = n;

price = p;

}

public void raisePrice(double surcharge) // Line 12

{

return price + surcharge; // Line 14

}
```

I chose E: Replace line 12 with public double raisePrice (double surcharge). Although it would compile, it doesn't actually change the number of price. So, it should have been B: Replace line 14 with price += surcharge;.

The raisePrice method is intended to increase the value of price by adding surcharge to it; the statement "price += surcharge" works as intended. The method should not return a value, as it is a void mutator method, not an accessor method.

# Q54 Recursive String
```java
public static boolean recurMethod(String str)

{

if (str.length() <= 1)

{

return true;

}

else if (str.substring(0, 1).compareTo(str.substring(1, 2)) > 0)

{

return recurMethod(str.substring(1));

}

else

{

return false;

}

}
```

I accidently chose A: recurMethod("abcde"), but it was D: recurMethod("edcba"). It actually compares the letter before to the letter after, so the larger letter should be at the front, not the back.

If the first character of str is lexicographically greater than the second character of str, the method returns the result of the recursive call with a parameter that contains all but the first character of str. If the first character of str is lexicographically less than or equal to the second character of str, the method returns false. If no such character pair (where the first character of str is lexicographically less than or equal to the second character of str) is found, the base case is reached and the value true is returned.

# Q56
```java
private ArrayList myData;

public void removeDups ()

{

  int k = 1;

  while (k < myData.size())

  {

    if (myData.get(k).equals(myData.get(k - 1)))

    {

      myData.remove(k);

    }

    k++;

  }

}
```
I chose D: The body of the if statement should be: myData.remove(k - 1);. I didn't consider that it would shift the array, as deleting an element would make the loop skip items. 

It should be E: There should be an else before the statement k++;. This would prevent it from skipping items in the array by only incrementing if there was nothing removed.

![example](https://assets.learnosity.com/organisations/537/media.academicmerit.com/e2717935e829b72f10626fd11b85fad1/original.jpg)

![code](https://assets.learnosity.com/organisations/537/media.academicmerit.com/6bbf6b02e8e6687b78ff78e0abe6a048/original.jpg)

I chose A: Executing shuffle may cause an ArrayIndexOutOfBoundsException.

It was actually E: The last element of the returned array (result [result.length − 1] ) may not have the correct value. The code doesn't really account for odd numbers, simply dividing the length of the array by two. So, if it's odd, it will just case it into an integer and not account for the last element.