<?php






$return = "";

	for ($i = 1; $i <= 9; $i++)
	{
			$file_content = file_get_contents ($i.".txt");
			$numbers = explode("-", $file_content);
			$no_of_items = sizeof($numbers) - 1;
			$return = $return."<li>Number of 10digit numbers in ".$i.".txt file: ".$no_of_items."</li>";
	}
echo $return;

?>