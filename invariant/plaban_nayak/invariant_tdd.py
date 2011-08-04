import unittest
from invariant_algorithm import dynamic_prog
from invariant_main import main_method


class TestEachFunction(unittest.TestCase):

    def test_dynamic_prog(self):
        """Tests the dynamic_prog function in module invariant_python
            which returns the no of iterations to reach 6174 for a given
            number. It should have value 5 for number 1112
        """
        
        no_of_iterations  = dynamic_prog(1112)
        self.assertEqual(no_of_iterations,5)
        

    def test_main_method(self):
        """Tests the main_method function in module invariant_main which
           returns the dictionary containing {Iterations :Total numbers}
           when the range of number given is the 4 digit numbers
           It should raise ValueError if all numbers are not 4 digit numbers
        """
        
        self.assertRaises(ValueError,main_method,range(900,5000))
        
        
    def test_main_method_result(self):
        """main_method should return a dictionary which shows
           356 numbers have iteration length 1 to reach 6174
        """
        iter_dict = main_method(range(1000,9999))
        self.assertTrue(1 in iter_dict)
        self.assertTrue(iter_dict[1] == 356)
        
        
        
            

        
if __name__ == '__main__':
    unittest.main()
