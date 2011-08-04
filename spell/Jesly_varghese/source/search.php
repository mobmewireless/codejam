<?php
	function search($Word,$Array)
	{
	
	foreach($Array as $Handle)
		{
			
			if (trim($Word)==trim($Handle))
				{
					#echo "Found";
					return True;
				}
		}
	return False;
	}