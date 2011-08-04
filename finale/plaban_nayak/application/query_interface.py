#!usr/bin/env python
import MySQLdb
import random

class DatabaseError(Exception):
    pass


class QueryInterface :
    """Represent the query inteface"""

    def __init__(self,database_info,main_table = "main_menu"):
        """Constructor for class query interface"""

        try:
            cursor = self.get_cursor(database_info)
            rows = cursor.execute("show tables").fetchall()
            tuple_main_table = (main_table,)
            if not tuple_main_table in rows:
                raise DatabaseError,"No such database or table exists"
            
        except MySQLdb.Error:
            raise DatabaseError,"No such database or table  exists"           
        
    
        self.main_table = main_table
        host , user, passwd, db = database_info
        self.database_info = database_info        
        self.current_table = None
        self.cursor ,self.conn = self.get_cursor(self.database_info)
        self.create_session_id_db()
        

    def __create_session_id_db():
        """Create the session ids tables"""
        
        self.cursor.execute("""
            CREATE TABLE IF NOT EXISTS SESSION_IDS
            (
             session_id INT
            )
            """
            )

    def get_cursor(self,database_info):
        """Return the cursor for the database"""
        
        host , user, passwd, db = database_info        
        try :
            conn = MySQLdb.connect(host = host, user = user,
                                   passwd = passwd, db = db)
            cursor = conn.cursor()
            return cursor,conn
        
        except MySQldb.Error :
                raise DatabaseError,"Cannot connect to database"
            

    def _list_menu(self,mobile_no = None, session_id = None , user_input = None):
        """Return the menu for a particular session """
        
        if mobile_no is None:
            #raise TypeError if mobile_no is None
            raise TypeError,"Mobile number shouldnt be empty"
        
        elif not isinstance(mobile_no,int):
            #raise TypeError if mobile_no is not of int type
            raise TypeError,"Mobile no should be of int type"
        
        if session_id == None:
            
            # if no session_id issued generate session_id
            session_id = randome.randrange(0,10000)
            self.cursor.execute ("""select ID,ITEM from %s """,(self.main_table))
            menu = list (self.cursor.fetchall())
            return (session_id,menu)
        
        else:
            session_ids = list(self.cursor.execute("Select * from SESSION_IDS"))
            if not session_id in session_ids:
                raise ValueError,"No such session_id exists"
            
            
            if user_input is None:
                raise TypeError,"Input cannot be None"
            
            self.cursor.execute ("""select ITEM,TEXT,NEXT_TABLE, from %s where ID = %d""",(self.current_table,int(user_input)))
            row = self.cursor.fetchall()
            
            
            if rows is None:
                raise TypeError,"Invalid User Input"
            else :
                if row[0] == "EXIT":
                    return None
                
                if row[1] is not NULL:
                    return (row[1])
                
                elif row[1] is NULL and row[2] is not NULL:
                    self.current_table = row[2]
                    self.cursor.execute ("""select ID,ITEM  from %s """,(self.current_table))
                    menu = enumerate (list ( self.cursor.fetchall()))
            return menu
        

    def __del__(self):
        """Destructor ,Close the database connection"""
        self.cursor.close()
        self.conn.commit()
        self.conn.close()
    


   
        
        
        
    
        
        

        
    
