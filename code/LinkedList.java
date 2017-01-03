public class LinkedList<E>
{
	class Link implements SingleLink
	{
		private Link frontLink;
		private Link backLink;
		private E element;
		public Link(Link backLink,E element)
		{
			this.element=element;
			backLink.frontLink=this;
			this.backLink=backLink;
			frontLink=null;
		}
		public Link(E element)
		{
			this.element=element;
			backLink=null;
			frontLink=null;
		}
		public E get()
		{
			return element;
		}
		public Link next()
		{
			return frontLink;
		}
		public Link previous()
		{
			return backLink;
		}
		public void add()
		{
			backLink.frontLink=this;
			frontLink.backLink=this;
		}
		public void remove()
		{
			backLink.frontLink=frontLink;
			frontLink.backLink=backLink;
		}
		public void removeStartLink()
		{
			frontLink.backLink=null;
		}
		public void removeEndLink()
		{
			backLink.frontLink=null;
		}
	}
	private Link startLink;
	private Link endLink;
	private Link middleLink;
	private int length;
	public LinkedList(E element)
	{
		startLink=new Link(element);;
		endLink=startLink;
		middleLink=startLink;
		length=1;
	}
	public LinkedList()
	{
		startLink=null;
		endLink=null;
		middleLink=null;
		length=0;
	}
	private LinkedList(Link startLink,Link endLink,int length)
	{
		this.startLink=startLink;
		this.middleLink=startLink;
		this.endLink=endLink;
		this.length=length;
	}
	public void add(E element)
	{
		Link link;
		if (length==0)
		{
			link=new Link(element);
			startLink=link;
			middleLink=link;
		}
		else
		{
			link=new Link(endLink,element);
		}
		endLink=link;
		length++;
	}
	public void restart()
	{
		middleLink=startLink;
	}
	public boolean next()
	{
		if(middleLink==endLink)
		{
			return false;
		}
		else
		{
			middleLink=middleLink.next();
			return true;
		}
	}
	public boolean previous()
	{
		if(middleLink==startLink)
		{
			return false;
		}
		else
		{
			middleLink=middleLink.previous();
			return true;
		}
	}
	public E get()
	{
		return middleLink.get();
	}
	public SingleLink takeLink()
	{
		SingleLink result=middleLink;
		remove();
		length--;
		return result;
	}
	public void addLink(SingleLink singleLink)
	{
		Link link=(Link) singleLink;
		link.add();
		length++;
	}
	public boolean remove()
	{
		if (length==0)
		{
			return false;
		}
		if(length<=1)
		{
			startLink=null;
			middleLink=null;
			endLink=null;
		}
		else if(middleLink==startLink)
		{
			middleLink.removeStartLink();
			middleLink=middleLink.next();
			startLink=middleLink;
		}
		else if(middleLink==endLink)
		{
			middleLink.removeEndLink();
			middleLink=middleLink.previous();
			endLink=middleLink;
		}
		else
		{
			middleLink.remove();
			middleLink=middleLink.previous();
		}
		length--;
		return true;
	}
	public int length()
	{
		return length;
	}
	public LinkedList clone()
	{
		return new LinkedList(startLink,endLink,length);
	}
	public String toString()
	{
		if (length==0)
		{
			return "[]";
		}
		Link tempMiddleLink=middleLink;
		restart();
		String result="[";
		do
		{
			if(middleLink!=tempMiddleLink)
			{
				result+=(get().toString()+",");
			}
			else
			{
				result+=("["+(get().toString())+"],");
			}
		}
		while(next());
		result+=("] length: "+length);
		middleLink=tempMiddleLink;
		return result;
	}
}
