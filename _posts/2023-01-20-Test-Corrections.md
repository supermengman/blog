---
toc: true
layout: post
description: correcting moment
categories: [markdown,collegeboard]
comments: true
title: Test Corrections 52 Q
---

# Stats
Score: 43/52
Total Score: 0.9 + 1.8 = 2.7/3

# Q4 ABCDEF substring

```java
String oldStr = "ABCDEF";

String newStr = oldStr.substring(1, 3) + oldStr.substring(4);

System.out.println(newStr);

```

I chose D: BCDEF. That would be if newStr was oldStr.substring(1, 3) + oldStr.substring(3). So, it's C: BCEF

# Q25 Execute Manipulate

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

["baboon", "bear", "zebra", "bass", "cat", "koala"].

For this one, I did not fully iterate through the loop in my head. The code basically moves any animal with a b into the "opposite" index (being the index that is the same amount of indices away from the other side of the list). However, as it goes throughout the whole thing, it would swap the b animals back to their right spot, so it's just the original again.

Answer is B: 
["bear", "zebra", "bass", "cat", "koala", "baboon"]

# Q29 Olympics Concat

```java
int a = 1988;

int b = 1990;

String claim = " that the world’s athletes " + "competed in Olympic Games in ";

String s = "It is " + true + claim + a + " but " + false + claim + b + ".";
```

I thought it was E: does not compile, but it's actually C: It is true that the world’s athletes competed in Olympic Games in 1988 but false that the world’s athletes competed in Olympic Games in 1990. The + operator concatenates strings, booleans, and integers. So, it's not a problem that true and false are booleans, and it's not a problem that a and b are integers.

# Q31 Print in row major order

```java
public static void rowMajor(int[][] arr)

{

/* missing code */

}
```

I chose E: 
```java
for (int[] j : arr)
{
   for (int k : j)
   {
      System.out.print(arr[k] + " ");
   }
}
```

It's actually D: 
```java
for (int[] j : arr)
{
   for (int k : j)
   {
      System.out.print(k + " ");
   }
}
```

Instead of using k as the index, it's already the actual number. So, it's just k.

# Q35 print values while traversing ArrayList numbers
In the code segment below, assume that the ArrayList object numbers has been properly declared and initialized to contain [0, 2, 4, 5].

```java
for (int k = numbers.size() - 1; k >= 0; k--)

{

if (numbers.get(k) > k)

{

System.out.print(k + " ");

}

}
```

What, if anything, is printed as a result of executing the code segment?

I chose D: 5 4 2, but that would be if it printed out the value at k. It's actually printing the index itself, so its C: 3 2 1

# Q40 Remove names from a List
```java
/** Removes all occurrences of nameToRemove from nameList.
* @param nameList a list of names
* @param nameToRemove a name to be removed from nameList
*/
public void removeName(List<String> nameList, String nameToRemove)
{
/* missing implementation */
}
```
options: 
```java
I for (String name : nameList)

{

if (name.equals(nameToRemove))

name.remove();

}

 

II for (int k = 0; k < nameList.size(); k++)

{

if (nameList.get(k).equals(nameToRemove))

nameList.remove(k);

}

 

III for (int k = nameList.size() - 1; k >= 0; k--)

{

if (nameList.get(k).equals(nameToRemove))

nameList.remove(k);

}
```

I Chose D: II and III, but II doesn't work. As it traverses the array forward, as it removes an element, the size of the array decreases, so the next element is skipped. So, it's actually C: III only

# Q42 Remove zeroes from Arraylist by index
```java
public static main void mystery(List<Integer> nums){
   for (int k = 0; k < nums.size(); k++) {
      if (nums.get(k).intValue() == 0) {
         nums.remove(k);
      }
   }
}
```
List w/ [0,0,4,2,5,0,3,0]

I chose B: [4,2,5,3], but it was D: [0,4,2,5,3]. This was because the loop iterated forward while also removing indices, so it skipped a zero.

# Q45 strArrMethod
```java
public static String[] strArrMethod(String[] arr)

{

String[] result = new String[arr.length];

for (int j = 0; j < arr.length; j++)

{

String sm = arr[j];

for (int k = j + 1; k < arr.length; k++)

{

if (arr[k].length() < sm.length())

{

sm = arr[k]; // Line 12

}

}

result[j] = sm;

}

return result;

}


String[] testTwo = {"last", "day", "of", "the", "school", "year"};

String[] resultTwo = strArrMethod(testTwo);
```

How many times is // line 12 called?
I chose D: 15 times, but it was A: 4 times. Correct. Line 12 is executed each time the variable sm is updated because a new smallest value is found. When j has the value 0, sm is updated for "day" and "of". When j has the value 1, sm is updated for "of". When j has the value 4, sm is updated for "year". When j has any of the values 2, 3, or 5, sm is not updated. Line 12 is executed four times.

# Q52 X and O board
I chose B: the checkerboard with 0,0 as an O, but iot was actually E: where it was a checkerboard but checked for even or odd.
The first set of nested for loops sets each element in board to “O”. The next for loop starts val at 0 and increments by 1 until val is 4, when val is 5 the loop terminates. When val is even, board is not updated, so nothing happens when val is 0. When val is 1, row is assigned 1 and col is assigned 0. The boolean condition in the while loop is true, so board[1][0] is assigned “X”. Then col is incremented to 1 and row is decremented to 0 and board[0][1] is assigned “X”. Then col is incremented to 2 and row is decremented to -1 and the while loop terminates. When val is 2, nothing changes about board. When val is 3, row is assigned 3 and col is assigned 0. The boolean condition in the while loop is true, so board[3][0] is assigned “X”. Then col is incremented to 1 and row is decremented to 2 and board[2][1] is assigned “X”. Then col is incremented to 2 and row is decremented to 1 and board[1][2] is assigned “X”. Then col is incremented to 3 and row is decremented to 0 and board[0][3] is assigned “X”. Finally, col is incremented to 4 and row is decremented to -1 and the while loop terminates. When val is 4, nothing changes about board.