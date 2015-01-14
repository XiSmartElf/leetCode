package leetCode.Stack;
//tricky problem. go uphill! or same level. whenever a downhill occurs, stops and do the following:
//1. pop all the pushed index of previous uphill histo
//for each we pop a histogram, find the hight using it's index.
// use it's height[index] *((i-1)-stack.peek()) to the area and replace max if bigger
//((i-1)-stack.peek()) is the distance between the popped height and the last uphill histogram before downhil and the elem right before the popped height elem
//such way would not miss some very big area. what's stored in stack is like mutliple walls avoid you overcal your distance
//draw the graph will understand it 

import java.util.Stack;

public class _84_Largest_Rectangle_Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestRectangleArea(new int[]{2,3,4,5,3,5,4,2}));
	}
	
	public static int largestRectangleArea(int[] height) {
        if (height==null) return 0;//Should throw exception
        if (height.length==0) return 0;
    
        Stack<Integer> index= new Stack<Integer>();
        index.push(-1);
        int max=0;
    
        for  (int i=0;i<height.length;i++){
                //Start calculate the max value
            while (index.peek()>-1)
                if (height[index.peek()]>height[i]){
                    int top=index.pop();                    
                    max=Math.max(max,height[top]*(i-1-index.peek()));  
                    System.out.println(height[top]*(i-1-index.peek())+" when i is: "+i+" and Height is: "+height[top]+" "+index);
                }else break;
    
            index.push(i);
        }
        while(index.peek()!=-1){
            int top=index.pop();
            max=Math.max(max,height[top]*(height.length-1-index.peek()));
        }        
        return max;
    }

}
