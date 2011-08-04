<?php
set_time_limit(600);
session_start();
$day_array = array();
$last_time = $_SESSION['time'];
$day_array = $_SESSION['day_array'];
$response = file_get_contents("http://search.twitter.com/search.json?phrase=i+love+you&rpp=100");
$flag=true;
while($flag)
{
$outs = json_decode($response,true);
$results = $outs["results"];
$love = 0;
$next_time = $results[0]["created_at"];
foreach($results as $result)
{	
	$time =  $result["created_at"];
	//echo "Next:".date_timestamp_get(date_create($time));
	//echo "Now:".date_timestamp_get(date_create($last_time));
	//echo date_diff ($time,$last_time,true);
	if(abs(getsecs($time)-getsecs($last_time))<=10)
		$love++;
	else
	$flag = false;
}
$url = $outs["next_page"];
//echo $url;
//$flag = false;
$response = file_get_contents("http://search.twitter.com/search.json".$url);
}
$last_time = $next_time;
echo $love;
$localtime = localtime();
$day_array[$localtime[tm_hour]] +=$love;

$_SESSION['time']=$last_time;
$_SESSION['day_array'] = $day_array;
?>
<?php
function getsecs($time)
{
$time = explode(" ",$time);
$time = explode(":",$time[4]);	
return $time[2];
}
?>