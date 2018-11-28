package data;

/***
 * 
 * ClassName: Node <br/> 
 * Function: 节点类，组成链式结构 <br/>
 * 
 * date: 2018年9月17日 下午10:33:07 <br/> 
 * @author ChaosBom 
 * @version  
 * @since JDK 1.8
 * 
 * @modified By：   <修改人> <br/>                                        
 * @modified Date:<修改日期>  <br/>                                  
 * @desc：修改日志 <修改描述> <br/>
 */
public class Node
{
	private Object obj;
	private Node preNode;
	private Node nextNode;

	public Node(){
		this.obj=null;
	}
	
	public Node(Object obj){
		this.obj=obj;
	}
	
	public Object getObj()
	{
		return obj;
	}

	public void setObj(Object obj)
	{
		this.obj = obj;
	}

	public Node getPreNode()
	{
		return preNode;
	}

	public void setPreNode(Node preNode)
	{
		this.preNode = preNode;
	}

	public Node getnextNode()
	{
		return nextNode;
	}

	public void setNetxNode(Node nextNode)
	{
		this.nextNode = nextNode;
	}

}
