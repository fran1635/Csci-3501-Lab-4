# Csci-3501-Lab-4
Let n be the number of items input

For each item the algorithm checks if it fits in 1 of 3 bins so that would mean the inner loop at most runs 3 times

The outer loop runs for each input item so n times

This means the max number of bin checks is
3n

Because the number of bins is always 3, and 3 is a constant
O(3n) = O(n)

We know the algorithim is Big Omega(n) because the algorithim must go through every item at least once meaning n times

Since runtime is Big Omega(n) and O(n)

By definition it is also Big Theta(n)

We know f(n) = n so if we let k = 1 then

f(n) is bound by O(n^1) which proves f() is bound by O(n^k)