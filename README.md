# burgers
Members: Aryan Bhatt, Eric Chen, Melanie Chow

QuickSort's Big-Oh Runtime Classifications:
Best-Case: O(nxlog(n))
Average-Case: O( n x log(n) )
Worst-Case: O(nxlog(n)

 We tested the runtime by creating arrays of n items and timing how long it would take to perform quicksort on those arrays. We justified our best case and worst case classifications by thinking about how the arrays of each case would look and how it would change after partition. In the worst case, partition only partitions one item to a side (eg. choosing the minimum or maximum value in the bounds as the pvtPos). In that case, the bounds only detracts by 1. In the best case, the array is already sorted and the bounds would become smaller and smaller as the pvtPos would be the middle value. In this case the bounds detract quickly. However, in the big scale of things, we think that these big-ohs may be the same, espeically since the average case was nlogn as well. Choosing which pvtPos to partition did not really make a difference either, since in most cases we don't know the order of the array. 
  
Mean execution times for dataset of size n:
  Batch size: 5000
  
  n=1000     time: 91,445 ns
  
  n=2000     time: 183,769 ns
  
  n=3000     time: 313,521 ns
  
  n=4000     time: 405,829 ns
  
  n=5000     time: 500,748 ns
  
  
  n=6000     time: 610,279 ns
  
  n=7000     time: 730,446 ns
  
  n=8000     time: 845,869 ns
  
  n=9000     time: 940,874 ns
  
  n=10000    time: 1,129,605 ns
  
  
  This is our graph and our data table:
  ![alt tag](https://github.com/melaniechow/burgers/blob/master/graphs/tableandgraph.png)
  
  Based on the data we collected, Quicksort appears to have a Big-Oh classification of nlogn. We see that the line of y=30x (a linear function) is quite close to the data points, but towards 5,000 array items, our data curls upward. We then plotted the graph of 30xlogx, which fits the data better and accounts for the slight increase that is not present in the linear graph. Having a log in the runtime makes sense due to the binary "splitting"/"partiioning" movement we do with the array. The linear part also makes sense due to the linear search of going through the arrays and simply comparing and swapping. 
  
  ![alt tag](https://github.com/melaniechow/burgers/blob/master/graphs/linecomparisions.png)
  
 
