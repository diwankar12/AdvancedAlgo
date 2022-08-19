package Arrays;


import java.util.ArrayList;
import java.util.PriorityQueue;



class Node{

    int value ;
    int index;
    int position ;
    Node(int value,int index,int position){
        this.value = value ;
        this.index=index;
        this.position=position ;
    }

}


class MergeSortedArrays{

    public static void main(String[] args) {
       int[][] arr = {{1,2,3},{4,5,6},{7,8,9}} ;
       int[][] arr2 = {{1 ,2 ,3,4},{ 2 ,2 ,3,4},{5, 5, 6,6},{ 7, 8, 9, 9}} ;
       int[][] arr3 = {{57,81},{ 63 ,71}} ;

        //System.out.println(mergeKArrays(arr,3).toString());
        System.out.println(mergeKArrays(arr2,4).toString());
        System.out.println(mergeKArrays(arr3,2).toString());


    }

    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2)->n1.value-n2.value);

        for(int i=0;i<arr.length;i++){
            pq.add(new Node(arr[i][0],0,i)) ;
        }



        while(!pq.isEmpty()){

            Node node = pq.poll();
            System.out.println(node.value);
            ans.add(node.value) ;

            if(node.index<arr.length-1){
                int x = node.position ;
                int y = node.index+1 ;
                pq.add(new Node(arr[x][y],node.index+1,node.position));
            }

        }

        return ans ;


    }
}
