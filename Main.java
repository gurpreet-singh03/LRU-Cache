
public class Main {

    public static void main(String[] args) {


        LRUCache obj = new LRUCache(2);

        obj.put(1,1);
        obj.put(2,2);
        int param_1 = obj.get(1);
        System.out.print( param_1+" ");
        obj.put(3,3);
        int param_2 = obj.get(2);
        System.out.print( param_2+" ");
        obj.put(4,4);
        int param_3 = obj.get(1);
        System.out.print( param_3+" ");
        int param_4 = obj.get(3);
        System.out.print( param_4+" ");
        int param_5 = obj.get(4);
        System.out.print( param_5+" ");









        }
    }


//    ["LRUCache","put","put","get","put","get","put","get","get","get"]
//            [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]