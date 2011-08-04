Contest ID: mirror
Write a program which when given links to two images on the Internet, finds out how similar they are. [Bonus points if it ranks images on a similarity scale from 0 - very different to 100 - exactly the same]

Dependencies:
	linux (for wget)
	fftw3(libfftw3)
	opencv

Acknowledgement:
I would like to acknowledge http://nashruddin.com/phase-correlation-function-in-opencv.html for providing the base code

Installation and usage:
1) gcc phase_correlation.c -o phase_correlation `pkg-config --cflags opencv` `pkg-config --cflags fftw3` `pkg-config --libs opencv` `pkg-config --libs fftw3` -lcxcore -lcv -lhighgui -lfftw3
2)run the code as ./phase_correlation <1st url> <2nd url>
the file get saved in the directory as jpg.

For comparison you can use the following links:-

1) http://nashruddin.com/media/old/0201_4.jpg  and  http://nashruddin.com/media/old/0201_5.jpg (effect of noise)
2) http://nashruddin.com/media/old/0201_2.jpg and http://nashruddin.com/media/old/0201_3.jpg  (image shift)
3) http://4.bp.blogspot.com/_qh7vc6Onfaw/Sp4uIz6czJI/AAAAAAAAAFE/jeFshUng_JQ/s320/computers-acer-wallpapers-172619904.jpg  and  http://4.bp.blogspot.com/_qh7vc6Onfaw/Sp4ujfbytnI/AAAAAAAAAFM/-iB9jDYF9p8/s320/computers-acer-wallpapers-580003750.jpg  (2 different images)

