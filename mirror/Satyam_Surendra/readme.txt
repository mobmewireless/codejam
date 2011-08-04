1. The program takes two image files and compares them pixels by pixels and returns the percentage of their similarity.





2. If the two images are same but the size of one is enlarged or compressed, the algorithm recognizes that and displays that the images are same but only different in size and resolution





3.However..if the two images are same and but one is rotated with respect to other then it follows the normal algorithm of pixel comparison and returns the percentage difference.If, however the images are completely different both in description and size then the algorithm says that the images are not appropriate for comparison.






4.The source files are in Java and can be compiled by any IDE like Eclipse or on the console using javac mirror.java and then java mirror






5.Usage :

Can be used to efficiently compare images of same size and similar images which differ in resolution and size only.