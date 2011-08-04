#!/usr/bin/env python
import unittest
import MySQLdb
from  application.query_interface import QueryInterface,DatabaseError


class TestClassQuery(unittest.TestCase):
    """Test the Query Interface class"""

    def setUp(self):
        """Do before testing"""
        #Create a database USSDApplication       
        conn = MySQLdb.connect(host = "localhost",user = "root",passwd="c0d3jam!")
        cursor = conn.cursor()
        cursor.execute("Create database USSDApplication")
                                       
        
       
    def test_constructor(self):
        """check the constructor of the query interface class"""
        database_info = ["localhost","root","c0d3jam!","USSD"]
        
        #check if it raises NoSuchDatabaseError if a invalid database is given
        self.assertRaises(DatabaseError,QueryInterface,QueryInterface(database_info))
        database_info = ["localhost","root","c0d3jam!","USSDApplication"]
        cursor.execute (" create table main_menu ( ID INT AUTO_INCREMENT, ITEM VARCHAR(25),TEXT VARCHAR(25), NEXT_TABLE VARCHAR(25), PRIMARY KEY (ID)")
        cursor.execute("""INSERT INTO main_menu VALUES ("INDIA","DELHI",NULL),("AUSTRALIA","SIDNEY",NULL),("SRILANKA","COLUMBO",NULL)""")
        


        
        
        
        

        
        
        
        
        
        
                         
        
        
    
if __name__ == "__main__":
    unittest.main()
