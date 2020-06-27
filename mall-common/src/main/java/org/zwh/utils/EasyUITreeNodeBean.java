package org.zwh.utils;
public class EasyUITreeNodeBean {

    private long id;
    private String text;
    private String state;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

    public void setState(String state) {
         this.state = state;
     }
     public String getState() {
         return state;
     }
	@Override
	public String toString() {
		return "EasyUITreeNodeBean [id=" + id + ", text=" + text + ", state=" + state + "]";
	}
	public EasyUITreeNodeBean(long id, String text, String state) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
	}
	public EasyUITreeNodeBean() {
		super();
	}  
     
}