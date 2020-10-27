package amv87.myCode;

public class LLNode {
    //this is the word
    private String key;
    //this is the amount of times it is in the document
    private Integer value;

    //refers to the next node
    LLNode next;

    //constructor for LLNode class
    public LLNode (String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    //getter and setters of appropriate variables that were used throughout the project

    public String getKey() {
        return key;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
