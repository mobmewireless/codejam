CLOCK
------------

Discrpition
--------------
    The program prints time with an accuracy of +/-3 minutes in the best verbal
    representation it can (I hope its fuzzy enough).

    The program allows you to print this output in two ways
      1. if you run the program without any command line arguments it takes system
          time and gives an output
      2. if you run the program with a time separated by ':' it uses this as its input

    The program uses two dictionaries to find words for the given time.
    The time of day is decided based on the given hour.
    All this is concatenated into a single string and printed to the consol.



Dependencies
--------------
python-2.7

Usage
-------
    fuzzi_clock.py

    Optionaly you can give a time of your own(in railway time).
    fuzzi_clock.py <hh:mm:ss>
