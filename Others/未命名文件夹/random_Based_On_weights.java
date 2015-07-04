

public int randomBaseOnWeight(int[] arr, int[] weight)
{
    int sum = 0;
    for(int i=0; i<weight.length; i++)
      sum += weight[0];
    Random rand = new Random();
    float randVal = rand.nextFloat();
    int loc = randVal*sum;
    for(int i=0;i<arr.length; i++)
    {
        if(loc<weighti])
            return arr[i];
        loc-=arr[i];
    }
    return 0;
    
}

