/*written by Tatiana Azulay*/
public abstract class Node {
    public int value;
    public Node leftNode;
    public Node rightNode;
    public Node(int val, Node left, Node right) {
        value = val;
        leftNode = left;
        rightNode = right;
    }
    public int getValue() {return value;}
}
 class idNode extends Node {
    public idNode(int val) { 
    super(val, null, null); 
    }
}
class intNode extends Node {
    public intNode(int val) {
    super(val, null, null);
    }
}
class MulNode extends Node {
    public MulNode(int val, Node left, Node right) {
    super(val, left, right);
    }
    public int getValue() {
    return (leftNode.getValue() * rightNode.getValue());
    }
}
 class pNode extends Node {
    public pNode(Node left) {
    super(left.getValue(), left, null);
    }
    public int getValue() {
      return leftNode.getValue();
    }
}
 class subNode extends Node {
    public subNode(int val, Node left, Node right) {
    super(val, left, right);
    }
    public int getValue() {
      return (leftNode.getValue() - rightNode.getValue());
    }
}
 class sumNode extends Node {
    public sumNode(int val, Node left, Node right) {
    super(val, left, right);
    }
    public int getValue() { 
      return (leftNode.getValue() + rightNode.getValue()); 
    }
}