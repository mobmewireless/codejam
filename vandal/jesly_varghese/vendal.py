import zipfile #python library to work with zip library
import xml.dom.minidom
import os
import sys

def ownBase(Document):
	TextNode = Document.createElement('text:p')
	TextNodeStyle =  Document.createAttribute('text:style-name')
	TextNode.setAttributeNode(TextNodeStyle)
	TextNode.setAttribute('text:style-name','X6')
	TextContent = Document.createTextNode('"All your base are belong to us"')
	TextNode.appendChild(TextContent)
	return TextNode


	
def ownBaseStyle(Document):
	TextNode = Document.createElement('style:style')
	NodeStyle =  Document.createAttribute('style:name')
	TextNode.setAttributeNode(NodeStyle)
	TextNode.setAttribute('style:name','X6')
	StyleNode = Document.createElement('style:text-properties')
	StyleFontColor = Document.createAttribute('fo:color')
	StyleFontType =  Document.createAttribute('style:font-name')
	StyleFontSize =  Document.createAttribute('fo:font-size')		
	StyleFontSizeAsian = Document.createAttribute('style:font-size-asian')
	StyleNode.setAttributeNode(StyleFontColor)
	StyleNode.setAttributeNode(StyleFontType)
	StyleNode.setAttributeNode(StyleFontSize)
	StyleNode.setAttribute('fo:color','#ff3366')
	StyleNode.setAttribute('style:font-name','Comic Sans MS')
	StyleNode.setAttribute('style:font-size-asian','72pt')
	StyleNode.setAttribute('fo:font-size','72pt')
	TextNode.appendChild(StyleNode)
	return TextNode

def reWriteXML(ZipFilePath,XMLContent):
	XMLFile = open('content.xml','w')
	XMLFile.write(XMLContent)
	XMLFile.close()
	ZipFile = zipfile.ZipFile(ZipFilePath,mode='a')
	ZipFile.write('content.xml')
	ZipFile.close()
	print 'Archived...!!!!!!!'

def processFontDeclerations(StyleElements):
	for Style in StyleElements:
		Style.setAttribute('style:name','Comic Sans MS')
		Style.setAttribute('style:font-family-generic','script')
		Style.setAttribute('svg:font-family','Comic Sans MS')

def processStyle(StyleElements,XMLParser):
	for Style in StyleElements:
			Style.appendChild(replaceStyleNodes(XMLParser))
			
def replaceStyleNodes(Document):
	StyleNode = Document.createElement('style:text-properties')
	StyleFontColor = Document.createAttribute('fo:color')
	StyleFontType =  Document.createAttribute('style:font-name')
	StyleFontSize =  Document.createAttribute('fo:font-size')		
	StyleFontSizeAsian = Document.createAttribute('style:font-size-asian')
	StyleNode.setAttributeNode(StyleFontColor)
	StyleNode.setAttributeNode(StyleFontType)
	StyleNode.setAttributeNode(StyleFontSize)
	StyleNode.setAttribute('fo:color','#ff3366')
	StyleNode.setAttribute('style:font-name','Comic Sans MS')
	StyleNode.setAttribute('style:font-size-asian','32pt')
	StyleNode.setAttribute('fo:font-size','32pt')
	return StyleNode

def processODT(ODTFile): #setting font to comic sans and font to 32pt
	XMLFile = ODTFile.read()
	XMLParser = xml.dom.minidom.parseString(XMLFile)
	XMLParser.getElementsByTagName('office:automatic-styles')[0].appendChild(ownBaseStyle(XMLParser))
	XMLParser.getElementsByTagName('office:text')[0].insertBefore(ownBase(XMLParser),XMLParser.getElementsByTagName('text:sequence-decls')[0])
	processFontDeclerations(XMLParser.getElementsByTagName('style:font-face'))
	processStyle(XMLParser.getElementsByTagName('style:style'),XMLParser)
	return XMLParser.toxml('utf-8')
		
def extractODT(FilePath):                 #extract odt file
	ChildZip = zipfile.ZipFile(FilePath) 
	#print 'FilePath:',FilePath
	ContentFile = ChildZip.open('content.xml')
	ProcessedXML = processODT(ContentFile)
	reWriteXML(str(ChildZip.filename),ProcessedXML)

def processParent(FileName): #function to extract the zip file
	ParentZip =zipfile.ZipFile(FileName)
	ResultantZip = zipfile.ZipFile(FileName+'pwnd.zip',mode='w')
	FilePath = str(ParentZip.filename)+'_pwnd/'
	#print ParentZip.filename
	for ODTFile in ParentZip.namelist():
		ParentZip.extract(ODTFile,FilePath)
		extractODT(FilePath+ODTFile)
		ResultantZip.write(FilePath+ODTFile)
		os.unlink(FilePath+ODTFile)

	ParentZip.close()
	os.unlink('content.xml')
	os.removedirs(FilePath)
try:
	processParent(sys.argv[1])
except:
	print 'Usage vendal.py <zipfilename> //Complete path if not in same directory'