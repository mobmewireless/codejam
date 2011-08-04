<?php
session_start();
$day_array = array();
$day_array = $_SESSION['day_array'];
$keys = array_keys($day_array);
$my_mood = array();
foreach($keys as $my_key)
{
	if($my_key<=10&&$my_key>=5)
	$my_mood['Morning']+=$day_array[$my_key];
	else if($my_key<=11&&$my_key>=13)
	$my_mood['Noon']+=$day_array[$my_key];
	else if($my_key<=14&&$my_key>=16)
	$my_mood['After Noon']+=$day_array[$my_key];
	else if($my_key<=17&&$my_key>=19)
	$my_mood['Evening']+=$day_array[$my_key];
	else if(($my_key<=20&&$my_key>=23)||($my_key>=00&&$my_key<=4))
	$my_mood['Night']+=$day_array[$my_key];

}
echo "The count of people loving";
echo "<br/><b>Morning:</b>".$my_mood['Morning'];
echo "<br/><b>Noon:</b>".$my_mood['Noon'];
echo "<br/><b>After Noon:</b>".$my_mood['After Noon'];
echo "<br/><b>Evening:</b>".$my_mood['Evening'];
echo "<br/><b>Night:</b>".$my_mood['Night'];
echo "<br/> The time of day in IST";
echo "<br/> And maximum is in the, ".array_search(max($my_mood),$my_mood,true);

?>