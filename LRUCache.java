import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public  Node(int key,int value) {
            this.key = key;
            this.value=value;
            next = null;
            prev=null;
        }
    }

    public  void addNode(Node newNode){
        newNode.prev=head;
        newNode.next=head.next;
        head.next.prev=newNode;
        head.next=newNode;
    }
    public  void delNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    Map<Integer,Node> mp=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        Node curr=mp.get(key);
        int data=curr.value;
        delNode(curr);
        addNode(curr);
        mp.put(key,head.next);
        return data;

    }

    public void put(int key, int value) {

        if(mp.containsKey(key)){
            Node curr=mp.get(key);
            delNode(curr);
            mp.remove(curr.key);
        }
        if(mp.size()==capacity){
            int k=tail.prev.key;
            delNode(tail.prev);
            mp.remove(k);
        }
        Node newNode=new Node(key,value);
        addNode(newNode);
        mp.put(key,head.next);

    }
}
