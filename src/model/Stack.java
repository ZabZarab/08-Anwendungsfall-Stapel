package model;

//TODO 01: Umsetzung der Klasse Stack gemäß der Dokumentations des Landes.
public class Stack<ContentType> {

    private class Node{
        private Node next;
        private ContentType content;

        public Node(ContentType content){
            this.content = content;
            this.next = null;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
        public ContentType getContent(){
            return content;
        }
    }

    private Node top;

    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }

    public void push(ContentType pContent){
        Node n = new Node(pContent);
        if(pContent != null){
            if (!isEmpty()) {
                n.setNext(top);
            }
            top = n;
        }
    }

    public void pop(){
        if(!isEmpty()){
            top = top.getNext();
        }
    }

    public ContentType top() {
        if (!isEmpty()) return top.getContent();
        return null;
    }
}


