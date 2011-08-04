<?
for ($i=1;$i<=9;$i++)
{
$file = $i.".txt";
$fileopen = fopen($file, 'r');
$data = fread($fileopen,filesize($file));
$count = count(explode("
", $data))-1; 
echo $i.".txt -".$count." results.<br>";
$page = $_SERVER['PHP_SELF'];
$sec = "1";
header("Refresh: $sec; url=$page");
}
?>