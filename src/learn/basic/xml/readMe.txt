java中的XML
一、解析方式
	1.DOM
	2.SAX
	3.DOM4J
	4.JDOM
二、DOM方式解析
	步骤：
		1.创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		2.创建一个DocumentBuiler的对象
		DocumentBuilder db = dbf.newDocumentBuilder();
		3.通过DocumentBuilder对象创建Document对象
		Document document = db.parse("books.xml");
		4.解析
	节点类型：
		Element节点: nodeType:1,nodeName返回值 element name,nodeValue返回值 null
		Attr节点 nodeType:2,nodeName返回值  属性名称, nodeValue返回值 属性值
		Text节点nodeType:3,nodeName返回值  #text nodeValue返回值  节点内容
	注意：通过dom方式解析xml时得到的子节点要包含空白及换行（空白和换行算一个子节点）
三、SAX解析
	步骤：
		1.获取SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		2.获取SAXParser
		SAXParser parser = factory.newSAXParser();
		3.创建SAXParserHandler，继承DefaultHandler
		SAXParserHandler handler = new SAXParserHandler();
		重写handler中的方法：
		startDocument：解析文档开始
		endDocument：解析文档结束
		startElement:解析节点开始
		characters:解析中，可通过value=new String(ch,start,length)获取节点值
		endElement:解析节点结束
四、JDOM解析
	步骤：
		1.创建一个SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		2.创建创建Document
		org.jdom.Document document = saxBuilder.build(in);
		3.解析
			document.getRootElement();//获取根元素
			rootElement.getChildren();//获取根元素的所有子元素
			e.getName();//获取元素名称
			e.getValue();//获取元素内容
			注：上面两个获取方法能获取到实际想要的值，不管是否有空白元素
五、dom4j解析
	步骤：
		1.创建SAXReader对象
		SAXReader saxReader = new SAXReader();
		2.加载xml文件
		saxReader.read(new File("res/books.xml"));
		3.解析
		document.getRootElement();//获取根元素
		rootElement.elementIterator()//获取子元素