README
------

1.DESIGN
  ------

  This Python code is used to find the similarity between the two images loaded from urls provided.The basic idea is to load the images from the link and find their root mean square difference.
  
2.DEPENDENCIES
  ------------
  Python
  PIL
  
3.Usage
  -----
  Run the program as:
      python mirror.py
      
  Then you must provide the url link one after the another at the prompt. For eg.:
      Enter url 1:http://www.google.co.jp/intl/ja_jp/images/logo.gif
      Enter url 2:http://www.norcalblogs.com/bored/a.jpg
      
  The program will then find the similarity between the images in percentage value and also rank them accordingly. Eg.:
      The images are 29.28% similar
      The images are almost different

