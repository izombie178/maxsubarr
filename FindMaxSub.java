package subarray;

import subarray.LinkedList.Node;
import java.util.*;

public class FindMaxSub {

	public  static LinkedList findMaximumSubList(LinkedList nums) {
		Node node=nums.head;
		ArrayList<Node> nodes = new ArrayList<>();
		while(node.next!=null)
		{
			if (!(node==null))
				nodes.add(node);
			node=node.next;
		}
		Node start_node = null;
		Node end_node = null;
		int maximum_sum=0;
		for(int x=0;nodes.size()>x;x++)
		{
			int node_sum=0;
			for(int y=x;nodes.size()>y;y++)
			{
				node_sum+=nodes.get(y).data;
				if(node_sum>maximum_sum)
				{
					maximum_sum=node_sum;
					start_node=nodes.get(x);
					end_node=nodes.get(y);
				}
			}
		}
		LinkedList linkedList = new LinkedList();
		return nums.subList(start_node,end_node);
	}
	
	public static int[] findMaximumSubArray(int[] nums){
		int maximum_sum=0;
		int start_of_array=0;
		int end_of_array=0;
		int start_of_array_index=0;
		int end_of_array_index=0;
		for(int x=0;nums.length>x;x++)
		{
			int index_sum=0;
			for(int y=x;nums.length>y;y++)
			{
				index_sum+=nums[y];
				if(index_sum>maximum_sum)
				{
					maximum_sum=index_sum;
					start_of_array=nums[x];
					end_of_array=nums[y];
					start_of_array_index=x;
					end_of_array_index=y;
				}
			}
		}
		int arr[]=new int[]{};
		arr=Arrays.copyOfRange(nums, start_of_array_index, end_of_array_index+1);
		return arr;
	}

	public static void main(String args[])
	{
		int arr[]={13,-3,-25,-20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

		int subarr[]=findMaximumSubArray(arr);
		System.out.println(Arrays.toString(subarr));

		LinkedList linkedList = new LinkedList(arr);

		LinkedList sublist = findMaximumSubList(linkedList);

		System.out.println(sublist.toString());

	}
}
