java�е�XML
һ��������ʽ
	1.DOM
	2.SAX
	3.DOM4J
	4.JDOM
����DOM��ʽ����
	���裺
		1.����һ��DocumentBuilderFactory�Ķ���
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		2.����һ��DocumentBuiler�Ķ���
		DocumentBuilder db = dbf.newDocumentBuilder();
		3.ͨ��DocumentBuilder���󴴽�Document����
		Document document = db.parse("books.xml");
		4.����
	�ڵ����ͣ�
		Element�ڵ�: nodeType:1,nodeName����ֵ element name,nodeValue����ֵ null
		Attr�ڵ� nodeType:2,nodeName����ֵ  ��������, nodeValue����ֵ ����ֵ
		Text�ڵ�nodeType:3,nodeName����ֵ  #text nodeValue����ֵ  �ڵ�����
	ע�⣺ͨ��dom��ʽ����xmlʱ�õ����ӽڵ�Ҫ�����հ׼����У��հ׺ͻ�����һ���ӽڵ㣩
����SAX����
	���裺
		1.��ȡSAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();
		2.��ȡSAXParser
		SAXParser parser = factory.newSAXParser();
		3.����SAXParserHandler���̳�DefaultHandler
		SAXParserHandler handler = new SAXParserHandler();
		��дhandler�еķ�����
		startDocument�������ĵ���ʼ
		endDocument�������ĵ�����
		startElement:�����ڵ㿪ʼ
		characters:�����У���ͨ��value=new String(ch,start,length)��ȡ�ڵ�ֵ
		endElement:�����ڵ����
�ġ�JDOM����
	���裺
		1.����һ��SAXBuilder����
		SAXBuilder saxBuilder = new SAXBuilder();
		2.��������Document
		org.jdom.Document document = saxBuilder.build(in);
		3.����
			document.getRootElement();//��ȡ��Ԫ��
			rootElement.getChildren();//��ȡ��Ԫ�ص�������Ԫ��
			e.getName();//��ȡԪ������
			e.getValue();//��ȡԪ������
			ע������������ȡ�����ܻ�ȡ��ʵ����Ҫ��ֵ�������Ƿ��пհ�Ԫ��
�塢dom4j����
	���裺
		1.����SAXReader����
		SAXReader saxReader = new SAXReader();
		2.����xml�ļ�
		saxReader.read(new File("res/books.xml"));
		3.����
		document.getRootElement();//��ȡ��Ԫ��
		rootElement.elementIterator()//��ȡ��Ԫ��